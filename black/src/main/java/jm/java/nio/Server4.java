package jm.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Roger on 2015/9/18.
 */
public class Server4 {
    Selector selector = null;
    ServerSocketChannel ssc = null;
    SocketChannel sc = null;
    SelectionKey key = null;
    ServerSocket serverSocket = null;

    public static void main(String[] args) {
        Server4 server4 = new Server4();
        server4.start();
    }

    public void start(){
        try {
            selector = Selector.open();
            //创建ServerSocketChannel，并绑定端口。
            ssc = ServerSocketChannel.open();
            //这里是阻塞的，serversocket.
            ssc.configureBlocking(true);
            serverSocket = ssc.socket();
            InetSocketAddress inetAddress = new InetSocketAddress(8089);
            serverSocket.bind(inetAddress);

            Poller poller = new Poller(selector);
            Thread thread = new Thread(poller);
            thread.setDaemon(true);
           thread.start();

            while (true){
                sc = ssc.accept();
                sc.configureBlocking(false);
                //key = sc.register(selector, SelectionKey.OP_READ);
                poller.addChannel(sc);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class Poller implements Runnable{

        private Selector selector = null;
        private Queue<SocketChannel> queue = new ArrayBlockingQueue<SocketChannel>(10);

        public Poller(Selector selector){
            this.selector = selector;
        }

        public void addChannel(SocketChannel channel){
            queue.add(channel);
        }

        @Override
        public void run() {
            while(true){


            SocketChannel sc = null;
            while ((sc =queue.poll()) != null) {

                try {
                    sc.register(selector,SelectionKey.OP_READ);
                } catch (ClosedChannelException e) {
                    e.printStackTrace();
                }
                System.out.println("this is poller thread!");
                try {
                    selector.select();
                    System.out.println("after select!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Set<SelectionKey> kyes = selector.selectedKeys();
                Iterator<SelectionKey> iterator = kyes.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key1 = iterator.next();
                    if (key1.isValid() && key1.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel) key1.channel();
                        if (socketChannel != null) {
                            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                            int size = 0;
                            try {
                                size = sc.read(byteBuffer);
                                if (size != -1) {
                                    byteBuffer.flip();
                                    Charset set = Charset.forName("UTF-8");
                                    CharBuffer charBuffer = set.decode(byteBuffer);
                                    System.out.print(charBuffer);
                                    size = sc.read(byteBuffer);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }
            }
        }}
    }
}

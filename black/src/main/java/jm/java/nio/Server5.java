package jm.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by Roger on 2015/9/18.
 */
public class Server5 {
    Selector selector = null;
    ServerSocketChannel ssc = null;
    SocketChannel sc = null;
    SelectionKey key = null;
    ServerSocket serverSocket = null;

    public static void main(String[] args) {
        Server5 server4 = new Server5();
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
                selector.close();
                selector.wakeup();
                key = sc.register(selector, SelectionKey.OP_READ);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class Poller implements Runnable{
        private Selector selector = null;
        public Poller(Selector selector){
            this.selector = selector;
        }
        @Override
        public void run() {
            try {
                System.out.println("before");
                int count = selector.select();
                System.out.println("after select : " + count);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

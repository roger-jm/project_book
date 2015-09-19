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
public class Server3 {
    Selector selector = null;
    ServerSocketChannel ssc = null;
    SocketChannel sc = null;
    SelectionKey key = null;
    ServerSocket serverSocket = null;

    public static void main(String[] args) {

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

            startPoller();

            while (true){
                sc = ssc.accept();
                register(sc);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void register(SocketChannel sc) {

    }

    private void startPoller() {
        Poller poller = new Poller();
        Thread thread = new Thread(poller,"myPoller");
        thread.setDaemon(true);
        thread.start();
    }

    class Poller implements Runnable{

        private Selector selector = null;

        public Poller( ){
            try {
                this.selector = Selector.open();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void run() {

        }
    }
}

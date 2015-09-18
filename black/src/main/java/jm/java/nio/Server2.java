package jm.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Roger on 2015/9/18.
 */
public class Server2 {
    public static void main(String[] args) {
        Selector selector = null;
        ServerSocketChannel ssc = null;
        SocketChannel sc = null;
        SelectionKey key = null;
        ServerSocket serverSocket = null;

        try {
            //创建一个selector
            selector = Selector.open();

            //创建ServerSocketChannel，并绑定端口。
            ssc = ServerSocketChannel.open();
            //ssc.configureBlocking(false);
            serverSocket = ssc.socket();
            InetSocketAddress inetAddress = new InetSocketAddress(8089);
            serverSocket.bind(inetAddress);

            //ssc.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("before while true");
            while (true){
                //选出一个通道
                System.out.println("while true ing...");
                sc = ssc.accept();

                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                int size = sc.read(byteBuffer);
                if(size !=-1){
                    byteBuffer.flip();
                    Charset set =  Charset.forName("UTF-8");
                    CharBuffer charBuffer = set.decode(byteBuffer);
                    System.out.print(charBuffer);
                    size = sc.read(byteBuffer);
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

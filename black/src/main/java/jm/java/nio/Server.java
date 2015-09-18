package jm.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * Created by Roger on 2015/9/17.
 */
public class Server {
    public static void main(String[] args) {
        ServerSocketChannel serverSocketChannel = null;
        Selector selector = null;
        SocketChannel socketChannel = null;
        ByteBuffer bb = ByteBuffer.allocate(32);
        Charset charset = Charset.forName("UTF-8");
        SelectionKey key2 = null;
        try {
            serverSocketChannel = ServerSocketChannel.open();
            selector = Selector.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(8088));
            SelectionKey key = serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
            int cout = 0;
            while (true){
                //System.out.println(cout++);
                selector.select();
                Iterator<SelectionKey> its = selector.selectedKeys().iterator();
                while (its.hasNext()){
                    SelectionKey k = its.next();
                    if(k.isAcceptable()){
                        socketChannel = serverSocketChannel.accept();
                        if(socketChannel==null){
                            continue;
                        }
                        socketChannel.configureBlocking(false);
                        key2 = socketChannel.register(selector,SelectionKey.OP_READ);
                    }else{
                        if(!key2.isValid()){
                            continue;
                        }
                        socketChannel = (SocketChannel) key2.channel();
                        int byteSize = socketChannel.read(bb);
                        while (byteSize!=-1){
                            Buffer temp = bb.flip();
                            //System.out.println((CharBuffer)temp);
                            CharBuffer charBuffer = charset.decode((ByteBuffer) temp);
                            System.out.print(charBuffer);
                            bb.clear();
                            if(!key2.isValid()){
                                continue;
                            }
                            byteSize = socketChannel.read(bb);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                serverSocketChannel.close();
                if(socketChannel!=null){
                    socketChannel.close();
                }
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

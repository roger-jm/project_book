package com.jm.java.channel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;

/**
 * This is Project project_book
 * Created by jmwmj
 * On 2015/7/23
 * At 10:41
 */
public class EchoChannelSocket {

    public static void main(String[] args) {
        try {
            SocketChannel channel = SocketChannel.open();
            Socket serverSocket = channel.socket();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

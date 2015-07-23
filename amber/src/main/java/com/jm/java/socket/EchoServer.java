package com.jm.java.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This is Project project_book
 * Created by jmwmj
 * On 2015/7/23
 * At 9:21
 */
public class EchoServer {
    ServerSocket serverSocket = null;
    public void createServer(){
        try {
            serverSocket = new ServerSocket(8989,100);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Socket socket = null;
    InputStream inputStream = null;
    OutputStream outputStream = null;
    public void listen(){
        try {
            socket = serverSocket.accept();
            inputStream = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

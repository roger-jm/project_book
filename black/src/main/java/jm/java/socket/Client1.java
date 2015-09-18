package jm.java.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Roger on 2015/9/17.
 */
public class Client1 {
    public static void main(String[] args) {
        Socket socket = null;
        InputStream  inputStream = null;
        OutputStream outputStream = null;
        try {
            socket = new Socket("localhost",8089);
            outputStream = socket.getOutputStream();
            String ss = "thinks";
            outputStream.write(ss.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

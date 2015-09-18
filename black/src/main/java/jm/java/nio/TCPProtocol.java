package jm.java.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;

/**
 * Created by Roger on 2015/9/17.
 */
public interface TCPProtocol {

    void handleAccept(SelectionKey key) throws IOException;

    void handleRead(SelectionKey key) throws IOException;

    void handleWrite(SelectionKey key) throws IOException;
}

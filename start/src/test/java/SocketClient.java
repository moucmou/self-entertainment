import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author AmazingZ
 * @date 2019/5/8 11:41
 */
public class SocketClient {
    public static void main(String[] args) {
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress(10001));
            while (!socketChannel.finishConnect()) {
                continue;
            }
            ByteBuffer writeBuffer = ByteBuffer.wrap("hello World\n\r".getBytes());
            ByteBuffer readBuffer = ByteBuffer.allocate("hello World\n\r".getBytes().length);
            int totalBytesReceived = 0;
            int bytesReceived;
            while (totalBytesReceived < "hello World".getBytes().length) {
                if (writeBuffer.hasRemaining()) {
                    socketChannel.write(writeBuffer);
                }
                if ((bytesReceived = socketChannel.read(readBuffer)) == -1) {
                    throw new SocketException("Connection closed prematurely");
                }
                totalBytesReceived += bytesReceived;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socketChannel != null) {
                    socketChannel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

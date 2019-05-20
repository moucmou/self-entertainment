import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;
/**
 * @author AmazingZ
 * @date 2019/5/7 16:57
 */
public class SocketServer {
    public static void main(String[] args) {

        try {
            ServerSocketChannel serverSocketChannel= ServerSocketChannel.open();
            Selector selector=Selector.open();
            serverSocketChannel. bind(new InetSocketAddress(10001));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while(true){
                if(selector.select(3000)==0){
                    continue;
                }
                 Iterator<SelectionKey> iterator= selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    SelectionKey selectionKey=iterator.next();
                    if(selectionKey.isAcceptable()){
                        SocketChannel clientChannel=      serverSocketChannel.accept();
                        clientChannel.configureBlocking(false);
                        clientChannel.register(selectionKey.selector(),SelectionKey.OP_READ);
                    }
                    if(selectionKey.isReadable()){
                        SocketChannel selectableChannel= (SocketChannel)selectionKey.channel();
                        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
                        while (selectableChannel.read(byteBuffer)!=-1){
                            byteBuffer.flip();
                            System.out.println(new String(byteBuffer.array()));
                            byteBuffer.clear();
                        }
                    }
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

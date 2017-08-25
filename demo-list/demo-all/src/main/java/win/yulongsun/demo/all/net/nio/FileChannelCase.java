package win.yulongsun.demo.all.net.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by sunyl21830 on 2017/8/2.
 */
public class FileChannelCase {


    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("pom.xml", "rw");
            //Channel
            FileChannel channel = file.getChannel();
            //Buffer
            ByteBuffer buffer = ByteBuffer.allocate(100);
            int read = channel.read(buffer);
            while (read!=-1){
                buffer.flip();//Channel-->Buffer
                while (buffer.hasRemaining()){
                    System.out.println(buffer.get());
                }
                buffer.clear();
            }
            channel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package win.yulongsun.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by sunyl21830 on 2017/7/31.
 */
public class NioCase {

    public static void main(String[] args) {
        try {
//            File file = new File( "D:\\me\\learn-list\\demo-list\\demo-all\\readme.md");
//            FileInputStream fileInputStream = new FileInputStream(file);
//            FileChannel channel = fileInputStream.getChannel();
//            ByteBuffer buffer = ByteBuffer.allocate(1024);
//            channel.read(buffer);
//            System.out.println(buffer.toString());
//            channel.close();

            FileOutputStream fileOutputStream = new FileOutputStream("D:\\me\\learn-list\\demo-list\\demo-all\\readme.md2");
            FileChannel outChannel = fileOutputStream.getChannel();
            ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
            String msg = "testMsg";
            writeBuffer.put(msg.getBytes());
            writeBuffer.flip();
            outChannel.write(writeBuffer);
            outChannel.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

package win.yulongsun.demo.all.readerwriter;

import java.io.*;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 读者写着模型
 *
 * @author Sun.YuLong on 2018/5/29.
 */
public class ReaderWriterTest implements Reader, Writer {

    @Override
    public void read(String fileNamePath) {
        System.out.println("读者begin");
        System.out.println("读者-" + Thread.currentThread().getId() + "-content=" + readFile(fileNamePath));
        System.out.println("读者end");
        System.out.println("-------------------------------");

    }

    @Override
    public void write(String fileNamePath) {
        try {
            RandomAccessFile file     = new RandomAccessFile(new File(fileNamePath), "rw");
            FileLock         fileLock = file.getChannel().tryLock();
            System.out.println("写者begin");
            file.writeUTF("write");
            System.out.println("写者-" + Thread.currentThread().getId() + "-write");
            System.out.println("写者end");
            System.out.println("-------------------------------");
            fileLock.release();
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ReaderWriterTest readerWriterTest = new ReaderWriterTest();
        String           fileNamePath     = "D:\\readme.txt";
        //写者:单线程池
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                readerWriterTest.write(fileNamePath);
            }
        }, 0L, 5L, TimeUnit.SECONDS);
        //读者
        Executors.newScheduledThreadPool(10).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                readerWriterTest.read(fileNamePath);
            }
        }, 0L, 100L, TimeUnit.MILLISECONDS);
    }


    public static String readFile(String fileName) {
        FileInputStream fis = null;
        StringBuffer    sb  = new StringBuffer();
        try {
            fis = new FileInputStream(new File(fileName));
            byte[] b        = new byte[100];
            int    readbyte = 0;
            while ((readbyte = fis.read(b)) != -1) {
                sb.append(new String(b, 0, readbyte, Charset.defaultCharset()));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("文件[" + fileName + "]未发现", e);
        } catch (IOException e) {
            throw new RuntimeException("文件读取[" + fileName + "]失败", e);
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
            }
        }
        return sb.toString().trim();
    }

}

interface Reader {
    void read(String fileNamePath);
}

interface Writer {
    void write(String fileNamePath);
}

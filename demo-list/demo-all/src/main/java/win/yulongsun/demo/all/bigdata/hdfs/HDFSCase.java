package win.yulongsun.demo.all.bigdata.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Sun.Yulong on 2017/8/13.
 */
public class HDFSCase {
    private Configuration conf;
    private FileSystem fs;

    @Before
    public void init() throws IOException {
        conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://node1:90000");
        fs = FileSystem.get(conf);
    }

    @After
    public void destory() throws IOException {
        fs.close();
    }

    @Test
    public void testUpload() throws IOException {
        fs.copyFromLocalFile(new Path(""), new Path(""));
    }


}

package win.yulongsun.zk;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * 增删改查
 */
public class ZKCase {


    private static final int SESSION_TIMEOUT = 30000;
    private ZooKeeper zooKeeper;

    Watcher watcher = new Watcher() {
        public void process(WatchedEvent watchedEvent) {
            System.out.println("watchedEvent:" + watchedEvent.toString());
        }
    };

    /**
     * 创建一个ZK实例
     */
    public void createZKInstance(String PATH) throws IOException {
        zooKeeper = new ZooKeeper(PATH, SESSION_TIMEOUT, watcher);

    }


    public void ZKOperations() throws KeeperException, InterruptedException {
        zooKeeper.create("/zk", "myData".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        //查看是否创建成功
        System.out.println(zooKeeper.getData("/zk", false, null));
        //修改节点数据
        zooKeeper.setData("/zk", "newData".getBytes(), -1);
        //查看是否修改成功
        zooKeeper.getData("/zk", false, null);
        //删除节点
        zooKeeper.delete("/zk", -1);
        //查看节点是否被成功删除
        zooKeeper.exists("/zk", false);
    }


    //关闭实例
    public void closeZK() throws InterruptedException {
        if (zooKeeper != null) {
            zooKeeper.close();
        }
    }

    public static void main(String[] args) {
        String PATH = "127.0.0.1:2181";
        ZKCase    app  = new ZKCase();
        try {
            app.createZKInstance(PATH);
            app.ZKOperations();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                app.closeZK();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

package win.yulongsun.demo.all.db.mongo;

import com.mongodb.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sunyl21830 on 2017/7/11.
 */
public class MongoDBCase {

    private MongoClient client;
    private DB db;
    private DBCollection emp;

    @Before
    public void setUp() throws Exception {
        client = new MongoClient("127.0.0.1");
        db = client.getDB("test");
        emp = db.getCollection("emp");
    }

    @Test
    public void insert() {
        //insert
        BasicDBObject object = new BasicDBObject("name", "sunyulong222")
                .append("age", "23")
                .append("passwd", "111")
                .append("addr", new BasicDBObject("postcode", "2012").append("street", "周王庙").append("city", "嘉兴"));
        emp.insert(object);
    }

    @Test
    public void select() {
        DBCursor cursor = emp.find();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }

    @Test
    public void update(){
        BasicDBObject object = new BasicDBObject("name", "sunyulong222");
        DBObject resultObj = emp.findOne(object);
        object.put("name", "lisi");
        emp.update(resultObj,object);
    }
}

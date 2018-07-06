package win.yulongsun.demo.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.StringWriter;

/**
 * @author Sun.YuLong on 2018/7/6.
 */
public class HelloVelocity {
    public static void main(String[] args) {
        Velocity.init();
        VelocityContext context = new VelocityContext();
        context.put("content","hello world");
        context.put("who","sunyulong");
        Template template = Velocity.getTemplate("myTemplate.vm");
        StringWriter writer = new StringWriter();
        template.merge(context,writer);
        writer.flush();
        System.out.println(writer.toString());
    }
}

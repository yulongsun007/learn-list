package win.yulongsun.demo.all.net.netty.heartbeat;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import win.yulongsun.demo.all.net.netty.protocol.Header;
import win.yulongsun.demo.all.net.netty.protocol.NettyMessage;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Sun.Yulong on 2017/8/28.
 */
public class LoginAuthRespHandler extends ChannelHandlerAdapter {
    private ConcurrentHashMap<String, Boolean> ipLoginedMap = new ConcurrentHashMap<String, Boolean>();
    private String[]                           ipWhiteList  = {"127.0.0.1"};

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
        NettyMessage message   = (NettyMessage) msg;
        NettyMessage loginResp = null;
        //如果是握手请求，则处理；其他请求，则透传
        if (message.getHeader() != null && message.getHeader().getType() == MessageType.LOGIN_REQ.value()) {
            String remoteIp = ctx.channel().remoteAddress().toString();
            if (ipLoginedMap.containsKey(remoteIp)) {
                //重复登录，拒绝
                loginResp = buildResponse((byte) -1);
            } else {
                //校验白名单
                boolean isOk = false;
                for (String ip : ipWhiteList) {
                    if (ip.equals(remoteIp)) {
                        isOk = true;
                        break;
                    }
                }
                loginResp = isOk ? buildResponse((byte) 0) : buildResponse((byte) -1);
                if (isOk) {
                    ipLoginedMap.put(remoteIp, true);
                }
            }
            //
            ctx.fireChannelRead(loginResp);
            System.out.println(String.format("The Login Response is :[%s], body is [%s]", loginResp, loginResp.getBody()));
        } else {
            ctx.fireChannelRead(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        ipLoginedMap.remove(ctx.channel().remoteAddress().toString());  //删除缓存
        ctx.close();
        ctx.fireExceptionCaught(cause);
    }

    private NettyMessage buildResponse(byte result) {
        NettyMessage respMessage = new NettyMessage();
        Header       header      = new Header();
        header.setType(MessageType.HEARTBEAT_RESP.value());
        respMessage.setHeader(header);
        respMessage.setBody(result);
        return respMessage;
    }
}

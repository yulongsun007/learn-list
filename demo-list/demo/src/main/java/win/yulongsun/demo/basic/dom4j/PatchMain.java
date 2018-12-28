package win.yulongsun.demo.basic.dom4j;

import java.io.IOException;

/**
 * Created by sunyl21830 on 2017/7/13.
 * <p>
 * 1.停掉待升级环境的通讯机服务.
 * 2.备份待升级通讯机环境,整个目录(comm-server)备份.(您可以在客户机上建立一个backup目录,每次备份时,以当前日期命名一个子目录,把备份文件存进去)
 * 3.删除待升级环境下的comm-server\apps,lib,deploys 这3个目录.
 * 4.将程序包里的comm-server\apps,lib,version拷贝到待升级环境(一定要有第3步操作,然后才能进行第4步操作)
 * 5.将升级包的通讯机拷贝一份到待升级环境的桌面上,直接启动一下.比较下升级包的comm-server\conf目录下各文件与待升级环境同名目录下各文件是否有差异,缺少的要补上.
 * 6.重启通讯机即可
 * 7.一般来说,升级通讯机时,OPENAPI也是要同步升级的,保持版本一致.
 * 8.先启动OPENAPI,再启动通讯机
 * <p>
 * <p>
 * ※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※
 * 关于通讯机与OPENAPI交互:
 * 1.通讯机与OPENAPI交互超时时间在comm-server\conf\api.client.properties 里有配置,建议配置为30秒(即30000);
 * 2.要确保通讯机启动时,第一次与OPENAPI交互是正常的,之后即使网络异常(通讯机--->OPENAPI端),再恢复网络,
 * 通讯机与OPENAPI的交互也会自动恢复正常的;
 * 3.需要重启通讯机的场景:
 * a.调整了comm-server\conf\下任意的文件
 * b.直销的省份,城市字典表,若有更新,且通讯机需要用到时,最好重启下通讯机方能生效(通讯机也存在缓存机制,暂不支持缓存自动刷新)
 * c.若通讯机第一次调用OPENAPI就失败了(因网络或其它等原因),那么在在OPENAPI正常后,需要重启一下通讯机(相反,若中途失败,则不需重启)
 * ※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※
 */
public class PatchMain {

    public static void main(String[] args) throws IOException {
        //1.停掉待升级环境的通讯机服务.
        //2.备份待升级通讯机环境
    }
}

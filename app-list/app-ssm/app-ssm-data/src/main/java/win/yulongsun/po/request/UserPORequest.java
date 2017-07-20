package win.yulongsun.po.request;

import win.yulongsun.common.CommonRequest;

/**
 * @author sunyulong on 2017/1/10.
 */
public class UserPORequest extends CommonRequest {

    private Integer id;

    private String name;

    private String account;

    private String password;

    private String mobile;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}

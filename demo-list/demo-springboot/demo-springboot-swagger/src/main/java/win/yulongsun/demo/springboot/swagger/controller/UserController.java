package win.yulongsun.demo.springboot.swagger.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import win.yulongsun.demo.springboot.swagger.vo.User;

/**
 * @author Sun.YuLong on 2018/2/8.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation(value = "获取用户列表", notes = "")
    @RequestMapping(value = "/getUseList", method = RequestMethod.GET)
    public String getUseList() {
        return "getUseList value";
    }


    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户VO", required = true, dataType = "User")
    @RequestMapping(value = "createUser", method = RequestMethod.POST)
    public String createUser(@RequestBody User user) {
        return "createUser value";
    }

    @ApiOperation(value = "更新用户", notes = "根据id更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "更新实体", required = true, dataType = "User")

    })
    @RequestMapping(value = "updateUser", method = RequestMethod.PUT)
    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        return "updateUser";
    }
}

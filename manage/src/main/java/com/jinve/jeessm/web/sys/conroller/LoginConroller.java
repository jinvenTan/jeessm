package com.jinve.jeessm.web.sys.conroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jinve.jeessm.web.sys.entity.User;
import com.jinve.jeessm.web.sys.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author jinven
 * @create 2017-12-13 14:47
 **/
@Controller
@RequestMapping(value = "/sys")
public class LoginConroller {

    @Resource
    private UserService userService;

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(User user){
        System.out.println("login success");
        return "login2";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String loginFial(User user){
        System.out.println("login success");
        return "login2";
    }

    @RequestMapping(value = "/toList")
    public String toUserList(HttpServletResponse response) throws IOException {
        return "/sys/userList";
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public String  findList() throws Exception{
        List<User> userList = userService.findList();
        ObjectMapper mapper = new ObjectMapper();
        String userListJson = null;
        userListJson = mapper.writeValueAsString(userList);
        return userListJson;
    }

    @RequestMapping(value = "listPage",method = RequestMethod.GET)
    @ResponseBody
    public String  findListPage(HttpServletRequest request) throws Exception{
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        List<User> userList = userService.findPage(page,rows);
        ObjectMapper mapper = new ObjectMapper();
        String userListJson = mapper.writeValueAsString(userList);
        return userListJson;
    }
}

package com.jinve.jeessm.web.sys.conroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jinve.jeessm.common.utils.CacheUtils;
import com.jinve.jeessm.common.utils.Encodes;
import com.jinve.jeessm.common.utils.MD5Util;
import com.jinve.jeessm.web.sys.entity.User;
import com.jinve.jeessm.web.sys.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.poi.util.StringUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author jinven
 * Created by tanjingwen on 2017/12/7.
 */
@Controller
@RequestMapping(value = "/user")
public class UserConroller {


    @Resource
    private UserService userService;

    @RequestMapping(value = "index")
    public String getUserById(HttpServletRequest request, Model model){
        String id = request.getParameter("id");
        User user = userService.get(id);
        model.addAttribute("user",user);
        return "index";
    }

    @RequestMapping(value = "edit")
    public String toEdit(){
        return "/sys/createUser";
    }
    @RequestMapping(method = RequestMethod.PUT)
    public String update(User user){
        user.preUpdate();
        int update = userService.update(user);
        System.out.println(update);
        return "list";
    }

    @ResponseBody
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String saveUser(User user){
        try {
            user.preInsert();
            user.preUpdate();
            String password = MD5Util.generate(user.getLoginName(),user.getPassword());
            user.setPassword(password);
            int result = userService.creatUser(user);
            return "/sys/userList";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/sys/createUser";
    }

}

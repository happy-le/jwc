package com.ld.jwc.controller;

import com.ld.jwc.bean.RespBean;
import com.ld.jwc.jwc_score_job.model.mysql.entity.JwcScoreJob.User;
import com.ld.jwc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    /**
     * 退出
     * @param request
     * @return
     */
    @RequestMapping("/loginOut")
    @ResponseBody
    public RespBean loginOut(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        if (session != null) {
            session.setAttribute(session.getId(), null);
        }
        return new RespBean();
    }

    /**
     * 登录验证
     * @param request
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, Model model) {

        String name = request.getParameter("username");
        String password = request.getParameter("password");

        //TODO校验

        Map<String,String> map = new HashMap<>();
        map.put("name",name);
        map.put("pwd",password);

        User user = null;
        try {
            user = userService.login(map);
        } catch (Exception e) {
            LOGGER.error("user login is error...",e);
        }

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute(session.getId(),user);
            model.addAttribute("user", user);

            LOGGER.info("user login is success,{}",name);
            return new ModelAndView("redirect:/index");
        } else {
            request.setAttribute("errorInfo", "验证失败");
            return new ModelAndView("login/login");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/setsession", method = RequestMethod.GET)
    public Map<String, Object> setSession (HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        request.getSession().setAttribute("设置session的网址是", request.getRequestURL());   // 设置session值
        map.put("request Url", request.getRequestURL());
        return map;
    }
    @ResponseBody
    @RequestMapping(value = "/getsession", method = RequestMethod.GET)
    public Object getSettion (HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());  // 取值
        map.put("message", request.getSession().getAttribute("map"));
        return map;
    }
}

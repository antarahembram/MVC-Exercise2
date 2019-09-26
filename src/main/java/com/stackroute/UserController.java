package com.stackroute;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @RequestMapping(value = "/",method=RequestMethod.GET)
    public String s( ModelMap model) {

        return "index";
    }

    @RequestMapping(value = "/display",method=RequestMethod.POST)
    public String submit(@RequestParam String userName, @RequestParam String password, ModelMap model) {

        ApplicationContext context=new AnnotationConfigApplicationContext(UserConfig.class);
        User user=context.getBean(User.class);
        user.setName(userName);
        user.setPassword(password);

        model.addAttribute("name",user.getName());
        return "display";
    }


}
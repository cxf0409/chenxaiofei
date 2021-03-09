package cn.com.taiji.learn.sshelloworld.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("login1")
    public String login(){
        return "LoginPage";
    }

}

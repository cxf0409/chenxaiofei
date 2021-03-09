package cn.com.taiji.learn.sshelloworld.api;
import cn.hutool.core.util.StrUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

//    @RequestMapping(value = "/h",method = RequestMethod.GET)
    @GetMapping("/h")
    public String helloWorld(){
        return "Hello World!";
    }

    @PostMapping("/h")
    public String add(
            @RequestParam(value = "name",required = true)
                    String name){
//        if(StrUtil.isBlank(name)){
//           throw new RuntimeException("不能为null");
//        }
        return "Added Success:"+name;
    }
    @PostMapping("/error")
    public String error(){
        return "错误";
    }



//    Delete  Update
}

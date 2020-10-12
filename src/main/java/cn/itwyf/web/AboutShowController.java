package cn.itwyf.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: Blog
 * @author: fei
 * @description:
 * @create: 2020-05-06 15:33
 */

@Controller
public class AboutShowController {

    /**
     * 跳转到about.html
     * @return
     */
    @GetMapping("/about")
    public String about() {
        return "about";
    }
}

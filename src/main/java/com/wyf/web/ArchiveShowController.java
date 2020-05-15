package com.wyf.web;

import com.wyf.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: Blog
 * @author: fei
 * @description:
 * @create: 2020-05-06 14:59
 */

@Controller
public class ArchiveShowController {


    private BlogService blogService;

    @Autowired
    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }

    /**
     * 归档页面的信息
     * @param model
     * @return
     */
    @GetMapping("/archives")
    public String archives(Model model) {
        model.addAttribute("archiveMap",blogService.archiveBlog());
        model.addAttribute("blogCount",blogService.countBlog());
        return "archives";
    }
}

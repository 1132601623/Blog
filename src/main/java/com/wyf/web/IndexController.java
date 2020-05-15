package com.wyf.web;

import com.wyf.service.BlogService;
import com.wyf.service.TagService;
import com.wyf.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: Blog
 * @author: fei
 * @description:
 * @create: 2020-04-24 14:21
 */

@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    /**
     * 主页数据
     * @param pageable 分页
     * @param model
     * @return
     */
    @GetMapping("/")
    public String index(@PageableDefault(size = 5, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        model.addAttribute("page", blogService.blogList(pageable));
        model.addAttribute("types", typeService.findTopType(6));
        model.addAttribute("tags", tagService.listTagTop(10));
        model.addAttribute("recommendBlogs", blogService.listRecommendBlogTop(8));
        return "index";
    }

    /**
     * 主页的模糊查询
     * @param pageable
     * @param query
     * @param model
     * @return
     */
    @PostMapping("/search")
    public String aearch(@PageableDefault(size = 5, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                         @RequestParam String query , Model model) {
        model.addAttribute("page", blogService.blogList("%" + query + "%", pageable));
        model.addAttribute("query", query);
        return "search";
    }

    /**
     * 根据id查询
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.getAndConvert(id));
        return "blog";
    }

    /**
     * 页面footer部分的博客
     * @param model
     * @return
     */
    @GetMapping("/footer/newblog")
    public String newBlog(Model model) {
        model.addAttribute("newblogs",blogService.listRecommendBlogTop(3));
        return "_fragments :: newBlogList";
    }
}

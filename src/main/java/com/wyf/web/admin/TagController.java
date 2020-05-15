package com.wyf.web.admin;

import com.wyf.pojo.Tag;
import com.wyf.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * @program: Blog
 * @author: fei
 * @description:
 * @create: 2020-04-29 20:15
 */

@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    private TagService tagService;
    //展示标签列表
    @GetMapping("/tags")
    public String tags(@PageableDefault(size = 3, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable, Model model) {

        model.addAttribute("page", tagService.TagList(pageable));
        return "admin/tags";
    }

    //返回一个新增页面
    @GetMapping("/tags/input")
    public String input(Model model)  {
        model.addAttribute("tag", new Tag());
        return "admin/tags-input";
    }

    //新增
    @PostMapping("/tags")
    public String save(@Valid Tag tag, BindingResult result, RedirectAttributes attributes) {
        Tag t = tagService.getTagByName(tag.getName());
        if (t != null) {
            result.rejectValue("name", "errorName", "不能添加重复的标签");
        }

        if (result.hasErrors()) {
            return "admin/tags-input";
        }

        Tag t1 = tagService.saveTag(tag);
        if (t1 == null) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }

        return "redirect:/admin/tags";
    }

    //修改页面跳转
    @GetMapping("/tags/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        Tag tag = tagService.getTag(id);
        model.addAttribute("tag", tag);
        return "admin/tags-input";
    }


    //修改
    @PostMapping("/tags/{id}")
    public String save(@Valid Tag tag, BindingResult result, @PathVariable Long id, RedirectAttributes attributes) {
        Tag t = tagService.getTagByName(tag.getName());
        if (t != null) {
            result.rejectValue("name", "errorName", "不能添加重复的标签");
        }

        if (result.hasErrors()) {
            return "admin/tags-input";
        }

        Tag t1 = tagService.updateTag(id, tag);
        if (t1 == null) {
            attributes.addFlashAttribute("message", "更新失败");
        } else {
            attributes.addFlashAttribute("message", "更新成功");
        }

        return "redirect:/admin/tags";
    }

    //删除

    @GetMapping("/tags/{id}/delete")
    public String deleteTag(@PathVariable Long id, RedirectAttributes attributes) {
        attributes.addFlashAttribute("message", "删除成功");
        tagService.deleteTag(id);
        return "redirect:/admin/tags";
    }

}

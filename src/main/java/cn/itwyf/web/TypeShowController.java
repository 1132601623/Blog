package cn.itwyf.web;

import cn.itwyf.pojo.Type;
import cn.itwyf.vo.BlogQueryVo;
import cn.itwyf.service.BlogService;
import cn.itwyf.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @program: Blog
 * @author: fei
 * @description:
 * @create: 2020-05-05 16:28
 */

@Controller
public class TypeShowController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/types/{id}")
    public String types(@PageableDefault(size = 5, sort = {"updateTime"}, direction = Sort.Direction.DESC)Pageable pageable, @PathVariable Long id, Model model) {
        List<Type> types = typeService.findTopType(10000);
        if (id == -1) {
            id = types.get(0).getId();
        }
        BlogQueryVo blogQueryVo = new BlogQueryVo();
        blogQueryVo.setTypeId(id);
        model.addAttribute("types", types);
        model.addAttribute("page", blogService.blogList(pageable, blogQueryVo));
        model.addAttribute("activeTypeId", id);
        return "types";
    }
}

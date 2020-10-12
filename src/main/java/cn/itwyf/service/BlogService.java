package cn.itwyf.service;

import cn.itwyf.pojo.Blog;
import cn.itwyf.vo.BlogQueryVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface BlogService {
    //根据id查询
    Blog getBlog(Long id);

    //分页查询
    Page<Blog> blogList(Pageable pageable, BlogQueryVo blog);

    //新增博客
    Blog saveBlog(Blog blog);

    //修改博客
    Blog updateBlog(Long id, Blog blog);

    //删除博客
    void deleteBlog(Long id);

    /**
     * 首页的博客列表数据
     * @param pageable
     * @return
     */
    Page<Blog> blogList(Pageable pageable);

    /**
     *
     * @param tagId
     * @param pageable
     * @return
     */
    Page<Blog> blogList(Long tagId, Pageable pageable);

    Page<Blog> blogList(String query, Pageable pageable);

    List<Blog> listRecommendBlogTop(Integer size);

    Blog getAndConvert(Long id);

    Map<String, List<Blog>> archiveBlog();

    Long countBlog();
}

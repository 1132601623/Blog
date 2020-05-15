package com.wyf.service;

import com.wyf.pojo.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {
    //查询所有数据
    Page<Tag> TagList(Pageable pageable);

    //根据id查询数据
    Tag getTag(Long id);

    //新增
    Tag saveTag(Tag tag);

    //修改
    Tag updateTag(Long id, Tag tag);

    //删除
    void deleteTag(Long id);

    //根据名字查询
    Tag getTagByName(String name);

    List<Tag> findAllTags();

    List<Tag> listTag(String ids);

    List<Tag> listTagTop(Integer size);

}

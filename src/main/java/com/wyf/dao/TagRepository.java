package com.wyf.dao;

import com.wyf.pojo.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @program: Blog
 * @author: fei
 * @description:
 * @create: 2020-04-29 20:39
 */

public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag getTagByName(String name);

    @Query("select t from Tag t")
    List<Tag> findTop(Pageable pageable);
}

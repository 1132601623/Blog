package cn.itwyf.service;

import cn.itwyf.pojo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeService {
    //新增
    Type saveType(Type type);

    //修改
    Type updateType(Long id, Type type);

    //查询
    Type getType(Long id);

    //分页
    Page<Type> TypeList(Pageable pageable);

    //删除
    void deleteType(Long id);

    Type getTypeByName(String name);

    List<Type> findAllType();

    List<Type> findTopType(Integer size);
}

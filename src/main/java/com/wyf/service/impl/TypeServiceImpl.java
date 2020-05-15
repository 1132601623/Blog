package com.wyf.service.impl;

import com.wyf.NotFoundException;
import com.wyf.dao.TypeRepository;
import com.wyf.pojo.Type;
import com.wyf.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: Blog
 * @author: fei
 * @description:
 * @create: 2020-04-28 21:47
 */

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    //新增
    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    //修改
    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        Type t = typeRepository.findById(id).get();
        if (t == null) {
            throw  new NotFoundException("资源不存在");
        }
        BeanUtils.copyProperties(type, t);
        return typeRepository.save(t);
    }

    //查询
    @Transactional
    @Override
    public Type getType(Long id) {
        return typeRepository.findById(id).get();
    }

    //分页
    @Transactional
    @Override
    public Page<Type> TypeList(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }


    //删除
    @Transactional
    @Override
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }

    @Override
    public List<Type> findAllType() {
        return typeRepository.findAll();
    }

    @Transactional
    @Override
    public List<Type> findTopType(Integer size) {
        Sort sort = Sort.by(Sort.Order.desc("blogs.size"));
        Pageable pageable = PageRequest.of(0, size, sort);
        return typeRepository.findTop(pageable);
    }
}

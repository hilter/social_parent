package com.sh.base.service;

import com.sh.base.dao.LabelDao;
import com.sh.base.pojo.Label;
import com.sh.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author 麦客子
 * @desc  标签的业务
 * @email leeshuhua@163.com
 * @create 2018/12/14 7:35
 **/
@Service
public class LabelService {

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询所有标签
     * @return
     */
    public List<Label> findAll(){
        return labelDao.findAll();
    }

    /**
     * 根据id查询一个标签
     * @param id
     * @return
     */
    public Label findById(String id){
        return labelDao.findById(id).get();
    }

    /**
     * 保存
     * @param label
     */
    public void add(Label label){
        label.setId(String.valueOf(idWorker.nextId()));
        labelDao.save(label);
    }

    /**
     * 更新
     * @param label
     */
    public void update(Label label){
        labelDao.save(label);
    }

    /**
     * 根据id删除
     * @param id
     */
    public void delete(String id){
        labelDao.deleteById(id);
    }
}

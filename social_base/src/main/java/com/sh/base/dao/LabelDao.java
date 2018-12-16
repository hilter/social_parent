package com.sh.base.dao;

import com.sh.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 麦客子
 * @desc 标签的持续层接口
 * @email leeshuhua@163.com
 * @create 2018/12/14 7:35
 **/
public interface LabelDao extends JpaRepository<Label,String>{
}

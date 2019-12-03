package com.cozi.springboot.service;

import com.cozi.springboot.pojo.Matter;

import java.util.Map;

/**
 * @Author xiaosai
 * @Date 2019-12-2 11:30
 * @Version 1.0
 */

public interface MatterService {

    Map<String,Object> addMatter(Matter matter);

    Map<String,Object> editMatter(Matter matter);

    Map<String,Object> delMatter(Integer id);

    Map<String,Object> getMatter(Integer pageNo, Integer pageSize);
}

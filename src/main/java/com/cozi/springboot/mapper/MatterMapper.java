package com.cozi.springboot.mapper;

import com.cozi.springboot.pojo.Matter;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

/**
 * @Author xiaosai
 * @Date 2019-12-2 13:04
 * @Version 1.0
 */
public interface MatterMapper {

    //添加matter
    void insertMatter(Matter matter) throws Exception;

    //修改matter
    void updateMatter(Matter matter) throws Exception;

    //通过id查找
    int selectOneMatter(@Param(value = "id") Integer id);

    //删除matter
    void deleteMatter(@Param(value = "id") Integer id) throws Exception;

    //查询matter
    Page<Matter> selectMatter();
}

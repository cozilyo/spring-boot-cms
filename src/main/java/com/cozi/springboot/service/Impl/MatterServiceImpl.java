package com.cozi.springboot.service.Impl;

import com.cozi.springboot.common.ReturnMap;
import com.cozi.springboot.mapper.MatterMapper;
import com.cozi.springboot.pojo.Matter;
import com.cozi.springboot.service.MatterService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author xiaosai
 * @Date 2019-12-2 11:31
 * @Version 1.0
 */

@Service
public class MatterServiceImpl implements MatterService {

    @Autowired
    private MatterMapper matterMapper;

    private static Map<String,Object> map = new HashMap<>();

    @Override
    public Map<String,Object> addMatter(Matter matter) {
        try {
            matterMapper.insertMatter(matter);
        } catch (Exception e) {
            map= ReturnMap.failureResponse("新增失败");
            e.printStackTrace();
        }
        map=ReturnMap.successResponse("新增成功");
        return map;
    }

    @Override
    public Map<String, Object> editMatter(Matter matter) {
        if(matter.getId().intValue()>=0){
            if(matterMapper.selectOneMatter(matter.getId())<=0){
                map=ReturnMap.failureResponse("待修改条例不存在！");
                return map;
            }
        }else {
            map=ReturnMap.failureResponse("待修改条例id不合法！");
            return map;
        }
        try {
            matterMapper.updateMatter(matter);
        } catch (Exception e) {
            map=ReturnMap.failureResponse("修改失败");
            e.printStackTrace();
        }
        map=ReturnMap.successResponse("修改成功");
        return map;
    }

    @Override
    public Map<String, Object> delMatter(Integer id) {
        if(id.intValue()>=0){
            if(matterMapper.selectOneMatter(id)<=0){
                map=ReturnMap.failureResponse("待删除条例不存在！");
                return map;
            }
        }else {
            map=ReturnMap.failureResponse("待删除条例id不合法！");
            return map;
        }
        try {
            matterMapper.deleteMatter(id);
        } catch (Exception e) {
            map=ReturnMap.failureResponse("删除失败");
            e.printStackTrace();
        }
        map=ReturnMap.successResponse("删除成功");
        return map;
    }

    @Override
    public Map<String, Object> getMatter(Integer pageNo, Integer pageSize) {
        if(pageNo.intValue()>0&&pageSize.intValue()>0){
            //PageHelper插件
            PageHelper.startPage(pageNo,pageSize,"id");//按照id排序
            Page<Matter> matters = matterMapper.selectMatter();
            PageInfo<Matter> pageInfo = new PageInfo<>(matters);
            map=ReturnMap.successResponse("成功获取matter信息");
            map.put("rows",pageInfo);
        }else {
            map=ReturnMap.failureResponse("请给出正确的当前页数或每页条数");
            return map;
        }
        return map;
    }
}

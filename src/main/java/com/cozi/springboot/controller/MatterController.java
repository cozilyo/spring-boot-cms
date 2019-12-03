package com.cozi.springboot.controller;

import com.cozi.springboot.pojo.Matter;
import com.cozi.springboot.pojo.PageTemplate;
import com.cozi.springboot.service.MatterService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author xiaosai
 * @Date 2019-12-2 11:14
 * @Version 1.0
 */

@Api(tags = "Cms接口")
@Controller
@RequestMapping("/cms")
public class MatterController {

    @Autowired
    private MatterService matterService;

    private static Map<String,Object> map = new HashMap<>();


    @RequestMapping(value = "/addFtl",method = RequestMethod.GET)
    public String getAddMatter(){
        return "add";
    }

    @RequestMapping(value = "/updateFtl",method = RequestMethod.GET)
    public String getUpdateMatter(){
        return "update";
    }


    /**
     *
     * @param matter 内容实体
     * @param request 请求体
     * @param response 响应体
     * @return
     */
    @ApiOperation(value = "新增内容条例", notes = "新增内容条例")
    @ApiResponses({
            @ApiResponse(code = 200,message = "{\n" +
                    "    \"return_msg\": \"返回描述\",\n" +
                    "    \"return_code\": 返回状态\n" +
                    "}"),
            @ApiResponse(code = 201,message = "请求成功并且服务器创建了新的资源"),
            @ApiResponse(code = 401,message = "请求要求身份验证"),
            @ApiResponse(code = 403,message = "服务器拒绝请求"),
            @ApiResponse(code = 404,message = "服务器找不到请求的网页")
    })
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addMatter(@RequestBody Matter matter,
                                        HttpServletRequest request,
                                        HttpServletResponse response){
        //新增matter
        if(matter!=null){
            map = matterService.addMatter(matter);
        }
        return map;
    }

    @ApiOperation(value = "修改内容条例", notes = "修改内容条例")
    @ApiResponses({
            @ApiResponse(code = 200,message = "{\n" +
                    "    \"return_msg\": \"返回描述\",\n" +
                    "    \"return_code\": 返回状态\n" +
                    "}"),
            @ApiResponse(code = 201,message = "请求成功并且服务器创建了新的资源"),
            @ApiResponse(code = 401,message = "请求要求身份验证"),
            @ApiResponse(code = 403,message = "服务器拒绝请求"),
            @ApiResponse(code = 404,message = "服务器找不到请求的网页")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> editMatter(@RequestBody Matter matter,
                                         HttpServletRequest request,
                                         HttpServletResponse response){
        if(matter!=null){
            map = matterService.editMatter(matter);
        }
        return map;
    }

    @ApiOperation(value = "删除内容条例", notes = "删除内容条例")
    @ApiResponses({
            @ApiResponse(code = 200,message = "{\n" +
                    "    \"return_msg\": \"返回描述\",\n" +
                    "    \"return_code\": 返回状态\n" +
                    "}"),
            @ApiResponse(code = 201,message = "请求成功并且服务器创建了新的资源"),
            @ApiResponse(code = 401,message = "请求要求身份验证"),
            @ApiResponse(code = 403,message = "服务器拒绝请求"),
            @ApiResponse(code = 404,message = "服务器找不到请求的网页")
    })
    //@ApiImplicitParam(name = "id", value = "内容条例id", required = true)
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> delMatter(@RequestBody Matter matter,
                                        HttpServletRequest request,
                                        HttpServletResponse response){
        map = matterService.delMatter(matter.getId());
        return map;
    }

    /**
     *
     * @param pageTemplate
     * @param request
     * @param response
     * @return
     */
    @ApiOperation(value = "查找内容条例", notes = "查找内容条例")
    @ApiResponses({
            @ApiResponse(code = 200,message = "{\n" +
                    "    \"return_msg\": \"返回描述\",\n" +
                    "    \"return_code\": 返回状态\n" +
                    "}"),
            @ApiResponse(code = 201,message = "请求成功并且服务器创建了新的资源"),
            @ApiResponse(code = 401,message = "请求要求身份验证"),
            @ApiResponse(code = 403,message = "服务器拒绝请求"),
            @ApiResponse(code = 404,message = "服务器找不到请求的网页")
    })
    /*@ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", required = true, dataType = "Integer")
    })*/
    @RequestMapping(value = "/get",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getMatter(@RequestBody PageTemplate pageTemplate,
                                        HttpServletRequest request,
                                        HttpServletResponse response){
        map = matterService.getMatter(pageTemplate.getPageNo(), pageTemplate.getPageSize());
        return map;
    }


}

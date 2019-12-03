package com.cozi.springboot.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author xiaosai
 * @Date 2019-12-2 11:15
 * @Version 1.0
 */
@ApiModel(value = "条例信息", description = "条例信息")
public class Matter {

    private Integer id;

    @ApiModelProperty(value = "拥有者")
    private String owner;//拥有者

    @ApiModelProperty(value = "内容")
    private String details;//内容

    @ApiModelProperty(value = "查看次数")
    private Integer view;//查看次数

    @ApiModelProperty(value = "只读 0-只读，1-读写")
    private Integer readOnly;//只读

    @ApiModelProperty(value = "发布时间")
    private String releaseTime;//发布时间

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "修改时间")
    private String modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public Integer getReadOnly() {
        return readOnly;
    }

    //只有为0或者1时，否则默认为0
    public void setReadOnly(Integer readOnly) {
        if(readOnly.equals(0)||readOnly.equals(1)){
            this.readOnly = readOnly;
        }else {
            this.readOnly = 0;
        }

    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "Matter{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", details='" + details + '\'' +
                ", view=" + view +
                ", readOnly=" + readOnly +
                ", releaseTime='" + releaseTime + '\'' +
                ", createTime='" + createTime + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                '}';
    }
}

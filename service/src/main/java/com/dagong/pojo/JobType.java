package com.dagong.pojo;

import java.util.ArrayList;
import java.util.List;

public class JobType {
    private Integer id;

    private String name;

    private Integer parentId;

    private Integer level;

    private List<JobType> childList = new ArrayList<>();

    public void addChild(JobType jobType){
        childList.add(jobType);
    }

    public List<JobType> getChildList() {
        return childList;
    }

    public void setChildList(List<JobType> childList) {
        this.childList = childList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "JobType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", level=" + level +
                ", childList=" + childList +
                '}';
    }
}
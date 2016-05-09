package com.dagong.job.vo;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by liuchang on 16/4/24.
 */
public class JobVO implements Serializable{

    private static final long serialVersionUID = 3491094902177309781L;
    private String id;

    @NotNull
    private String jobName;
    @NotNull
    private String companyId;
    @NotNull
    private String companyName;
    @NotNull
    private String companyUser;
    @NotNull
    private String detail;

    private Integer needNumber;

    private long createTime;
    @NotNull
    private Integer jobType;

    private String jobTypeName;

    private Integer startSalary;

    private Integer endSalary;

    private Integer bonus;

    private Integer royalty;

    private Integer discuss;

    private long modifyTime;

    private long startTime;

    private long endTime;

    private String modifyUser;

    private Integer status;

    private String address;

    private String contractor;

    private String phoneNumber;

    private Integer degree;

    private String workedYear;

    private String welfare;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyUser() {
        return companyUser;
    }

    public void setCompanyUser(String companyUser) {
        this.companyUser = companyUser;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getNeedNumber() {
        return needNumber;
    }

    public void setNeedNumber(Integer needNumber) {
        this.needNumber = needNumber;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public Integer getJobType() {
        return jobType;
    }

    public void setJobType(Integer jobType) {
        this.jobType = jobType;
    }

    public String getJobTypeName() {
        return jobTypeName;
    }

    public void setJobTypeName(String jobTypeName) {
        this.jobTypeName = jobTypeName;
    }

    public Integer getStartSalary() {
        return startSalary;
    }

    public void setStartSalary(Integer startSalary) {
        this.startSalary = startSalary;
    }

    public Integer getEndSalary() {
        return endSalary;
    }

    public void setEndSalary(Integer endSalary) {
        this.endSalary = endSalary;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public Integer getRoyalty() {
        return royalty;
    }

    public void setRoyalty(Integer royalty) {
        this.royalty = royalty;
    }

    public Integer getDiscuss() {
        return discuss;
    }

    public void setDiscuss(Integer discuss) {
        this.discuss = discuss;
    }

    public long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(long modifyTime) {
        this.modifyTime = modifyTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public String getWorkedYear() {
        return workedYear;
    }

    public void setWorkedYear(String workedYear) {
        this.workedYear = workedYear;
    }

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare;
    }
}

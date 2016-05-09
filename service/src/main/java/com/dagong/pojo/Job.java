package com.dagong.pojo;

import java.util.HashMap;

public class Job {
    private String id;

    private String jobName;

    private String companyId;

    private String companyName;

    private String companyUser;

    private String detail;

    private Integer needNumber;

    private long createTime;

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

    private HashMap<String,Object> extraProperties = new HashMap<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
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
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
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
        this.address = address == null ? null : address.trim();
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor == null ? null : contractor.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
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
        this.workedYear = workedYear == null ? null : workedYear.trim();
    }

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare == null ? null : welfare.trim();
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobTypeName() {
        return jobTypeName;
    }

    public void setJobTypeName(String jobTypeName) {
        this.jobTypeName = jobTypeName;
    }

    public HashMap<String, Object> getExtraProperties() {
        return extraProperties;
    }

    public void addExtraProperties(String key,Object value) {
        this.extraProperties.put(key,value);
    }

    public String getCompanyUser() {
        return companyUser;
    }

    public void setCompanyUser(String companyUser) {
        this.companyUser = companyUser;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id='" + id + '\'' +
                ", jobName='" + jobName + '\'' +
                ", companyId='" + companyId + '\'' +
                ", detail='" + detail + '\'' +
                ", needNumber=" + needNumber +
                ", createTime=" + createTime +
                ", jobType=" + jobType +
                ", startSalary=" + startSalary +
                ", endSalary=" + endSalary +
                ", bonus=" + bonus +
                ", royalty=" + royalty +
                ", discuss=" + discuss +
                ", modifyTime=" + modifyTime +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", modifyUser='" + modifyUser + '\'' +
                ", status=" + status +
                ", address='" + address + '\'' +
                ", contractor='" + contractor + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", degree=" + degree +
                ", workedYear='" + workedYear + '\'' +
                ", welfare='" + welfare + '\'' +
                '}';
    }
}
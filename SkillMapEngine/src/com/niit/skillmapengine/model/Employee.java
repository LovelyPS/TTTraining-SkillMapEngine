package com.niit.skillmapengine.model;


public class Employee 
{
	String mailid;
	String password;
	String name;
	String mobile;
	int centreCode;
	String supervisor;
	String qualification;
	int yop;
	int experience;
	int nofvisit;
	String status; 
	String remark;
	String role;
	
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public int getCentreCode() {
		return centreCode;
	}
	public void setCentreCode(int centreCode) {
		this.centreCode = centreCode;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public int getYop() {
		return yop;
	}
	public void setYop(int yop) {
		this.yop = yop;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	public int getNofvisit() {
		return nofvisit;
	}
	public void setNofvisit(int nofvisit) {
		this.nofvisit = nofvisit;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Employee [mailid=" + mailid + ", password=" + password + ", name=" + name + ", mobile=" + mobile
				+ ", centreCode=" + centreCode + ", supervisor=" + supervisor + ", qualification=" + qualification
				+ ", yop=" + yop + ", experience=" + experience + ", nofvisit=" + nofvisit + ", status=" + status
				+ ", remark=" + remark + ", role=" + role + "]";
	}
	
	
	
}

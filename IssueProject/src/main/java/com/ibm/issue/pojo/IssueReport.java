package com.ibm.issue.pojo;

public class IssueReport {
	private String userid;
	private String name;
	private Integer createNum;
	private Integer modifiNum;
	private Integer finishNum;
	private Double  completeRate;
	private String  rateString;
	private Report report;
	
	
	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCreateNum() {
		return createNum;
	}

	public void setCreateNum(Integer createNum) {
		this.createNum = createNum;
	}

	public Integer getModifiNum() {
		return modifiNum;
	}

	public void setModifiNum(Integer modifiNum) {
		this.modifiNum = modifiNum;
	}

	public Integer getFinishNum() {
		return finishNum;
	}

	public void setFinishNum(Integer finishNum) {
		this.finishNum = finishNum;
	}


	public Double getCompleteRate() {
		return completeRate;
	}

	@Override
	public String toString() {
		return "IssueReport [userid=" + userid + ", name=" + name + ", createNum=" + createNum + ", modifiNum="
				+ modifiNum + ", finishNum=" + finishNum + ", completeRate=" + completeRate + ", rateString="
				+ rateString + ", report=" + report + "]";
	}

	public String getRateString() {
		return rateString;
	}

	public void setRateString(String rateString) {
		this.rateString = rateString;
	}

	public void setCompleteRate(Double completeRate) {
		this.completeRate = completeRate;
	}

	
}

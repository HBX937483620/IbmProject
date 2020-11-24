package com.ibm.issue.pojo;

public class AllMessage {
	private Integer createNum;
	private Integer modefiNum;
	private Integer finishNum;
	private Integer adminNum;
	private Integer commonNum;
	private Integer manageNum;
	public Integer getCreateNum() {
		return createNum;
	}
	public void setCreateNum(Integer createNum) {
		this.createNum = createNum;
	}
	public Integer getModefiNum() {
		return modefiNum;
	}
	public void setModefiNum(Integer modefiNum) {
		this.modefiNum = modefiNum;
	}
	public Integer getFinishNum() {
		return finishNum;
	}
	public void setFinishNum(Integer finishNum) {
		this.finishNum = finishNum;
	}
	public Integer getAdminNum() {
		return adminNum;
	}
	public void setAdminNum(Integer adminNum) {
		this.adminNum = adminNum;
	}
	public Integer getCommonNum() {
		return commonNum;
	}
	public void setCommonNum(Integer commonNum) {
		this.commonNum = commonNum;
	}
	public Integer getManageNum() {
		return manageNum;
	}
	public void setManageNum(Integer manageNum) {
		this.manageNum = manageNum;
	}
	@Override
	public String toString() {
		return "AllMessage [createNum=" + createNum + ", modefiNum=" + modefiNum + ", finishNum=" + finishNum
				+ ", adminNum=" + adminNum + ", commonNum=" + commonNum + ", manageNum=" + manageNum + "]";
	}
}

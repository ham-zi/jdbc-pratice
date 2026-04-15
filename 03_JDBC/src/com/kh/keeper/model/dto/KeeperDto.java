package com.kh.keeper.model.dto;

import java.sql.Date;

public class KeeperDto {

	private String KeeperId;
	private String keeperName;
	private Date hireDate;
	private String zoneId;
	
	public KeeperDto() {
		super();
	}

	public KeeperDto(String keeperName, String zoneId) {

		this.keeperName = keeperName;
		this.zoneId = zoneId;
	}

	public KeeperDto(String keeperId, String keeperName, Date hireDate, String zoneId) {
		super();
		KeeperId = keeperId;
		this.keeperName = keeperName;
		this.hireDate = hireDate;
		this.zoneId = zoneId;
	}

	public String getKeeperId() {
		return KeeperId;
	}

	public void setKeeperId(String keeperId) {
		KeeperId = keeperId;
	}

	public String getKeeperName() {
		return keeperName;
	}

	public void setKeeperName(String keeperName) {
		this.keeperName = keeperName;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getZoneId() {
		return zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	@Override
	public String toString() {
		return "KeeperDto [KeeperId=" + KeeperId + ", keeperName=" + keeperName + ", hireDate=" + hireDate + ", zoneId="
				+ zoneId + "]";
	}
	
	
	
	
	
	
}

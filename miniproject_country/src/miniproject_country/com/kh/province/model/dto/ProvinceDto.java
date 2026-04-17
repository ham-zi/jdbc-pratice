package miniproject_country.com.kh.province.model.dto;

public class ProvinceDto {
	private int provinceNo;
	private String provinceName;
	private String localNo;
	
	public ProvinceDto() {
		super();
	}

	public ProvinceDto(String provinceName, String localNo) {
		super();
		this.provinceName = provinceName;
		this.localNo = localNo;
	}

	public ProvinceDto(int provinceNo, String provinceName, String localNo) {
		super();
		this.provinceNo = provinceNo;
		this.provinceName = provinceName;
		this.localNo = localNo;
	}
	

	public int getProvinceNo() {
		return provinceNo;
	}
	public void setProvinceNo(int provinceNo) {
		this.provinceNo = provinceNo;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getLocalNo() {
		return localNo;
	}
	public void setLocalNo(String localNo) {
		this.localNo = localNo;
	}
	@Override
	public String toString() {
		return "ProvinceDto [provinceNo=" + provinceNo + ", provinceName=" + provinceName + ", localNo=" + localNo
				+ "]";
	}
	
	
	
}

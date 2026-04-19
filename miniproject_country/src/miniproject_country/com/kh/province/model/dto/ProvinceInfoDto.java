package miniproject_country.com.kh.province.model.dto;

public class ProvinceInfoDto {
	
	private int provinceNo;
	private String provinceName;
	private String localNo;
	private Long totalPopulation;
	private Long totalArea;
	public ProvinceInfoDto(int provinceNo, String provinceName, String localNo, Long totalPopulation, Long totalArea) {
		super();
		this.provinceNo = provinceNo;
		this.provinceName = provinceName;
		this.localNo = localNo;
		this.totalPopulation = totalPopulation;
		this.totalArea = totalArea;
	}
	public ProvinceInfoDto() {
		super();
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
	public Long getTotalPopulation() {
		return totalPopulation;
	}
	public void setTotalPopulation(Long totalPopulation) {
		this.totalPopulation = totalPopulation;
	}
	public Long getTotalArea() {
		return totalArea;
	}
	public void setTotalArea(Long totalArea) {
		this.totalArea = totalArea;
	}
	
	
	
}

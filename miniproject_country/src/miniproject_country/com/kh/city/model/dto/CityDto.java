package miniproject_country.com.kh.city.model.dto;

public class CityDto {
	
	private int cityNo;
	private String cityName;
	private String localProduct;
	private String hotPlace;
	private Long cityPopulation;
	private Long cityArea;
	private int provinceNo;
	
	public CityDto() {
		super();
	}
	
	
	public CityDto(int cityNo, String cityName, String localProduct, String hotPlace, Long cityPopulation,
			Long cityArea, int provinceNo) {
		super();
		this.cityNo = cityNo;
		this.cityName = cityName;
		this.localProduct = localProduct;
		this.hotPlace = hotPlace;
		this.cityPopulation = cityPopulation;
		this.cityArea = cityArea;
		this.provinceNo = provinceNo;
	}
	
	
	
	public CityDto(String cityName, String localProduct, String hotPlace, Long cityPopulation, Long cityArea,
			int provinceNo) {
		super();
		this.cityName = cityName;
		this.localProduct = localProduct;
		this.hotPlace = hotPlace;
		this.cityPopulation = cityPopulation;
		this.cityArea = cityArea;
		this.provinceNo = provinceNo;
	}


	public int getCityNo() {
		return cityNo;
	}
	public void setCityNo(int cityNo) {
		this.cityNo = cityNo;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getLocalProduct() {
		return localProduct;
	}
	public void setLocalProduct(String localProduct) {
		this.localProduct = localProduct;
	}
	public String getHotPlace() {
		return hotPlace;
	}
	public void setHotPlace(String hotPlace) {
		this.hotPlace = hotPlace;
	}
	public Long getCityPopulation() {
		return cityPopulation;
	}
	public void setCityPopulation(Long cityPopulation) {
		this.cityPopulation = cityPopulation;
	}
	public Long getCityArea() {
		return cityArea;
	}
	public void setCityArea(Long cityArea) {
		this.cityArea = cityArea;
	}
	public int getProvinceNo() {
		return provinceNo;
	}
	public void setProvinceNo(int provinceNo) {
		this.provinceNo = provinceNo;
	}
	@Override
	public String toString() {
		return "CityDto [cityNo=" + cityNo + ", cityName=" + cityName + ", localProduct=" + localProduct + ", hotPlace="
				+ hotPlace + ", cityPopulation=" + cityPopulation + ", cityArea=" + cityArea + ", provinceNo="
				+ provinceNo + "]";
	}
	
	

}

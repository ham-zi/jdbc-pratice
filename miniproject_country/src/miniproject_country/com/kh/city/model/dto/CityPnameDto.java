package miniproject_country.com.kh.city.model.dto;

public class CityPnameDto {
	
	private int cityNo;
	private String cityName;
	private String localProduct;
	private String hotPlace;
	private Long cityPopulation;
	private Long cityArea;
	private String provinceName;
	public CityPnameDto(int cityNo, String cityName, String localProduct, String hotPlace, Long cityPopulation,
			Long cityArea, String provinceName) {
		super();
		this.cityNo = cityNo;
		this.cityName = cityName;
		this.localProduct = localProduct;
		this.hotPlace = hotPlace;
		this.cityPopulation = cityPopulation;
		this.cityArea = cityArea;
		this.provinceName = provinceName;
	}
	public CityPnameDto() {
		super();
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
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

}

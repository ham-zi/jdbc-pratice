package com.kh.species.model.dto;

public class SpeciesDto {
	private String speciesId;
	private String speciesName;
	private String speciesClass;
	
	
	
	public SpeciesDto() {
		super();
	}

	public SpeciesDto(String speciesName, String spciesClass) {
		super();
		this.speciesName = speciesName;
		this.speciesClass = spciesClass;
	}

	public SpeciesDto(String speciesId, String speciesName, String spciesClass) {
		super();
		this.speciesId = speciesId;
		this.speciesName = speciesName;
		this.speciesClass = spciesClass;
	}

	
	
	public String getSpeciesId() {
		return speciesId;
	}

	public void setSpeciesId(String speciesId) {
		this.speciesId = speciesId;
	}

	public String getSpeciesName() {
		return speciesName;
	}

	public void setSpeciesName(String speciesName) {
		this.speciesName = speciesName;
	}

	public String getSpciesClass() {
		return speciesClass;
	}

	public void setSpciesClass(String spciesClass) {
		this.speciesClass = spciesClass;
	}

	
	
	@Override
	public String toString() {
		return "SpeciesDto [speciesId=" + speciesId + ", speciesName=" + speciesName + ", spciesClass=" + speciesClass
				+ "]";
	}
	
	
	
	
	
}

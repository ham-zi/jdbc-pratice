package com.kh.species.model.service;

import java.util.List;

import com.kh.species.model.dao.SpeciesDao;
import com.kh.species.model.dto.SpeciesDto;

public class SpeciesService {
	SpeciesDao speciesDao = new SpeciesDao();
	
	
	public int save(SpeciesDto dto) {
		return speciesDao.save(dto);
	}
	
	public List<SpeciesDto> findAll() {
		return speciesDao.findAll(); 
	}

	public int update(SpeciesDto dto) {
		return speciesDao.update(dto);
	}
	
	public int delete(String speciesId) {
		return speciesDao.delete(speciesId);
	}
	
	public SpeciesDto findById(String speciesId) {
		return speciesDao.findById(speciesId);
	}
	
	public List<SpeciesDto> findByKeyword(String keyword) {
		return speciesDao.findByKeyword(keyword);
	}
}

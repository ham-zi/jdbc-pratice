package com.kh.animal.controller;

import java.util.List;

import com.kh.animal.model.dto.AnimalDto;
import com.kh.animal.model.service.AnimalService;

public class AnimalController {

	public int save(AnimalDto animal) {
		return new AnimalService().save(animal);
		
	}
	
	public List<AnimalDto> findAll() {
		return new AnimalService().findAll();
	}
	
	public AnimalDto findById(String id) {
		return new AnimalService().findById(id);
	}
	
	public List<AnimalDto> findByKeyword(String name) {
		return new AnimalService().findByKeyword(name);
	}
	
	public int updateAnimal(AnimalDto animal) {
		return new AnimalService().updateAnimal(animal);
	}
	public int deleteAnimal(String animalNo) {
		return new AnimalService().deleteAnimal(animalNo);
	}
}

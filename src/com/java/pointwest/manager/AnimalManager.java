package com.java.pointwest.manager;

import java.util.List;

import com.java.pointwest.beans.Animal;

public class AnimalManager {
	public List<Animal> putNewAnimal(Animal obj, List<Animal> animalList){
		animalList.add(obj);
		return animalList;	
	}
	
	public boolean removeAnimal(String refId,List<Animal> animalList) {
		boolean checker = false;
			for (Animal animal : animalList) {
				if (Integer.parseInt(refId) == animal.getReferenceId()) {
					animalList.remove(animal);
					checker = true;
					break;
				}
			}
		return checker;
	}
}

package com.java.pointwest.beans;

public abstract class Animal {
	private String name;
	private String age;
	private String gender;
	private String animalType;
	private int referenceId;
	static private int counter = 2000;
	
	abstract public String getSound();
	
	
	public Animal() {
		counter++;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}
	
	public int getCounter() {
		return counter;
	}


	public int getReferenceId() {
		return referenceId;
	}


	public void setReferenceId(int referenceId) {
		this.referenceId = referenceId;
	}
}

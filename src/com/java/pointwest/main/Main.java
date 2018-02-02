package com.java.pointwest.main;

import java.util.ArrayList;
import java.util.List;

import com.java.pointwest.beans.Animal;
import com.java.pointwest.ui.AnimalUIDisplay;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Animal> animalList = new ArrayList<Animal>();
		AnimalUIDisplay animalDisplay = new AnimalUIDisplay();
		boolean toContinue = true;
		
		while (toContinue) {
			toContinue = animalDisplay.checkAndDisplayMenu(animalList);
		}
		System.out.println("You successfully exit!");
	}

}

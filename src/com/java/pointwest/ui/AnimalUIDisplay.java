package com.java.pointwest.ui;

import java.util.List;
import java.util.Scanner;

import com.java.pointwest.beans.Animal;
import com.java.pointwest.beans.Cats;
import com.java.pointwest.beans.Dog;
import com.java.pointwest.beans.Parrot;
import com.java.pointwest.manager.AnimalManager;
import com.java.pointwest.util.Constants;

public class AnimalUIDisplay {

	public boolean checkAndDisplayMenu(List<Animal> animalList) {
		boolean toContinue = true;
		Scanner scan = new Scanner(System.in);
		String optionChoice = "";
		if (animalList.size() < 10 && animalList.size() > 0) {
			optionChoice = displayMenu("1");
			checkOptionChoice(optionChoice);
			toContinue = doChoiceOption(optionChoice,"option1",animalList);

		} else if (animalList.size() == 10) {
			System.out.println(Constants.SHELTER_FULL_MESSAGE);
			String decisionValue = scan.nextLine();

			if ("Y".equalsIgnoreCase(decisionValue)) {
				optionChoice = displayMenu("2");
				checkOptionChoice(optionChoice);
				toContinue = doChoiceOption(optionChoice,"option2",animalList);
			} else if ("N".equalsIgnoreCase(decisionValue)) {
				toContinue = false;
			} else {
				System.out.println("Invalid Choice. Please Y or N only!");
			}

		} else if (animalList.size() == 0) {
			System.out.println(Constants.SHELTER_EMPTY_MESSAGE);
			optionChoice = displayMenu("3");
			checkOptionChoice(optionChoice);
			toContinue = doChoiceOption(optionChoice,"option3",animalList);
		}

		return toContinue;

	}

	public String displayMenu(String choice) {
		Scanner scan = new Scanner(System.in);
		switch (choice) {
		case "1":
			System.out.println("Please Select an option");
			System.out.println("1. Add an Animal");
			System.out.println("2. Remove an Animal");
			System.out.println("3. View All Animals");
			System.out.println("4. Exit");
			System.out.print("Choice: ");
			break;
		case "2":
			System.out.println("Please Select an option");
			System.out.println("1. Remove an Animal");
			System.out.println("2. View All Animals");
			System.out.println("3. Exit");
			System.out.print("Choice: ");
			break;
		case "3":
			System.out.println("Please Select an option");
			System.out.println("1. Add an Animal");
			System.out.println("2. Exit");
			System.out.print("Choice: ");
			break;
		default:
			System.out.println("Invalid choice for the type of displaying a menu");
			break;
		}

		return scan.nextLine();
	}
	
	public boolean doChoiceOption(String choice,String option,List<Animal> animalList) {
		Scanner scan = new Scanner(System.in);
		boolean toContinue = true;
		if ("option1".equalsIgnoreCase(option)) {
			switch (choice) {
			case "1":
				System.out.println("1. A Dog");
				System.out.println("2. A Cat");
				System.out.println("3. Parrot");
				System.out.print("Choice: ");
				animalToAddChoice(scan.nextLine(),animalList);
				break;
			case "2":
				boolean checker = false;
				AnimalManager animalMgr = new AnimalManager();
				if (!animalList.isEmpty()) {
					System.out.println("Here is the list of our current animals!");
					displayCurrentAnimals(animalList);
					System.out.println("Enter Animal Referrence Id : ");
					String refIdChoice = scan.nextLine();
					checker = animalMgr.removeAnimal(refIdChoice, animalList);
					if (checker) {
						System.out.println("The animal is now removed");
					} else {
						System.out.println("Animal ID not found");
					}
				}
				
				break;
			case "3":
				
				if (!animalList.isEmpty()) {
					System.out.println("Meet our lovely animal friends!");
					displayAnimalGreetings(animalList);
				}
				break;
			case "4":
				toContinue = false;
				break;
			default:
				System.out.println("invalid choice please choose from 1-3 only");
				break;
			}
		} else if ("option2".equalsIgnoreCase(option)) {
			switch (choice) {
			case "1":
				boolean checker = false;
				AnimalManager animalMgr = new AnimalManager();
				if (!animalList.isEmpty()) {
					System.out.println("Here is the list of our current animals!");
					displayCurrentAnimals(animalList);
					System.out.println("Enter Animal Referrence Id : ");	
				}
				String refIdChoice = scan.nextLine();
				checker = animalMgr.removeAnimal(refIdChoice, animalList);
				if (checker) {
					System.out.println("The animal is now removed");
				} else {
					System.out.println("Animal ID not found");
				}
				break;
			case "2":
				if (!animalList.isEmpty()) {
					System.out.println("Meet our lovely animal friends!");
					displayAnimalGreetings(animalList);
				}
				break;
			case "3":
				toContinue = false;
				break;
			default:
				System.out.println("invalid choice please choose from 1-2 only");
				break;
			}
		} else if ("option3".equalsIgnoreCase(option)) {
			switch (choice) {
			case "1":
				System.out.println("1. A Dog");
				System.out.println("2. A Cat");
				System.out.println("3. Parrot");
				System.out.print("Choice: ");
				animalToAddChoice(scan.nextLine(),animalList);
				break;
			case "2":
				toContinue = false;
				break;
			default:
				System.out.println("invalid choice. The only choice is 1.");
				break;
			}
		}
		return toContinue;
	}
	
	public void animalToAddChoice(String animalChoice,List<Animal> animalList) {
		AnimalManager animalMgr = new AnimalManager();
		Scanner scan = new Scanner(System.in);
		switch (animalChoice) {
		case "1":
			Animal dogAnimal = new Dog();
			System.out.print("Name: ");
			dogAnimal.setName(scan.nextLine());
			System.out.print("Age: ");
			dogAnimal.setAge(scan.nextLine());
			System.out.print("Gender: ");
			dogAnimal.setGender(scan.nextLine());
			dogAnimal.setAnimalType("Dog");
			dogAnimal.setReferenceId(dogAnimal.getCounter());
			animalMgr.putNewAnimal(dogAnimal, animalList);
			break;
		case "2":
			Animal catAnimal = new Cats();
			System.out.println("Name: ");
			catAnimal.setName(scan.nextLine());
			System.out.println("Age: ");
			catAnimal.setAge(scan.nextLine());
			System.out.println("Gender: ");
			catAnimal.setGender(scan.nextLine());
			catAnimal.setAnimalType("Cat");
			catAnimal.setReferenceId(catAnimal.getCounter());
			animalMgr.putNewAnimal(catAnimal, animalList);
			break;
		case "3":
			Animal parrotAnimal = new Parrot();
			System.out.println("Name: ");
			parrotAnimal.setName(scan.nextLine());
			System.out.println("Age: ");
			parrotAnimal.setAge(scan.nextLine());
			System.out.println("Gender: ");
			parrotAnimal.setGender(scan.nextLine());
			parrotAnimal.setAnimalType("Parrot");
			parrotAnimal.setReferenceId(parrotAnimal.getCounter());
			animalMgr.putNewAnimal(parrotAnimal, animalList);
			break;
		default:
			System.out.println("Invalid choice please choose from 1-3 only.");
			break;
		}
		System.out.println("Animal is now added");
	}
	
	public void displayAnimalGreetings(List<Animal> animalList) {
		for (Animal animal : animalList) {
			int refId = animal.getReferenceId();
			String animalSound = animal.getSound();
			String name = animal.getName();
			String animalType = animal.getAnimalType();
			String gender = animal.getGender();
			String age = animal.getAge();
			System.out.println(refId + " : " + animalSound + " Hi! I'm " + name + " the " + animalType + 
								", " + age + " yrs old and I'm a " + gender);
		}
	}
	public void displayCurrentAnimals(List<Animal> animalList) {
		for (Animal animal : animalList) {
			int refId = animal.getReferenceId();
			String name = animal.getName();
			String animalType = animal.getAnimalType();
			System.out.println(refId + " : "  + name + " the " + animalType);
		}
	}
	public boolean checkOptionChoice(String choice) {
		if (choice.contains("123")) {
			return true;
		} else {
			return false;
		}
	}
}

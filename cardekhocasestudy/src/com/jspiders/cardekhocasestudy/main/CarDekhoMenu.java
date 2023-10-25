package com.jspiders.cardekhocasestudy.main;

import java.util.List;
import java.util.Scanner;

import com.jspiders.cardekhocasestudy.entity.Car;
import com.jspiders.cardekhocasestudy.operation.CarOperation;

public class CarDekhoMenu {
	
    public static void main(String[] args) {
    	CarOperation operation = new CarOperation();
    	Scanner scanner = new Scanner(System.in);
    	boolean flag = true;
    	
    	while(flag) {
    		System.out.println("\n========== Car Dekho Menu ==========");
    		System.out.println("1. Add car\n2. Get all cars\n3. Get car by id\n4. Delete car\n5. Update car details\n6. Exit.");
    		System.out.println("Enter your choice");
    		int choice = scanner.nextInt();
    		
    		switch (choice) {
			case 1:
				Car car = new Car();
				System.out.println("Enter car id.");
				car.setId(scanner.nextInt());
				scanner.nextLine();
				System.out.println("Enter name of car");
				car.setName(scanner.nextLine());
				System.out.println("Enter brand of Car");
				car.setBrand(scanner.nextLine());
				System.out.println("Enter price of car.");
				car.setPrice(scanner.nextDouble());
				scanner.nextLine();
				System.out.println("Enter car fuel type");
				car.setFuelType(scanner.next());
				operation.addCarDetails(car); 
				break;

			case 2 :
				List<Car> cars = operation.getAllCars();
				for (Car car2 : cars) {
					System.out.println(car2);
				}
				break ;
				
			case 3 :
				System.out.println("Enter car id.");
				Car car2 = operation.getCarById(scanner.nextInt());
				System.out.println(car2);
				break ;
				
			case 4 : 
				System.out.println("Enter car id.");
				operation.deleteCar(scanner.nextInt());
				break ;
			
			case 5 :
				System.out.println("Enter car id.");
				operation.uodateCar(scanner.nextInt(), scanner);
				break;
			
			case 6 : 
				System.out.println("Thank You!");
				flag = false ;
				break;
				
			default:
				System.out.println("Invalid choice.");
			}
    	}
    	
    	scanner.close();
    }
}

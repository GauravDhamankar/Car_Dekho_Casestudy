package com.jspiders.cardekhocasestudy.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jspiders.cardekhocasestudy.entity.Car;


public class CarOperation {

	private Connection connection ;
	private PreparedStatement preparedStatement ;
	private ResultSet resultSet ;
	private String query ;
	
    public void addCarDetails(Car car) {
    	try {
			connection = openConnection() ;
			query = "insert into car values(?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, car.getId());
			preparedStatement.setString(2, car.getName());
			preparedStatement.setString(3, car.getBrand());
			preparedStatement.setDouble(4, car.getPrice());
			preparedStatement.setString(5, car.getFuelType());
			int row = preparedStatement.executeUpdate();
			System.out.println("Car added successfully\n"+row+" rows are affected.");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }

    public List<Car> getAllCars() {
    	
       ArrayList<Car> list = new ArrayList<>();
       
       try {
		connection = openConnection();
		query = "select * from car";
		preparedStatement = connection.prepareStatement(query);
		resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			Car car = new Car();
			car.setId(resultSet.getInt(1));
			car.setName(resultSet.getString(2));
			car.setBrand(resultSet.getString(3));
			car.setPrice(resultSet.getDouble(4));
			car.setFuelType(resultSet.getString(5));
			list.add(car);
			
		}
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
       
       return list ;
    }

    public Car getCarById(int id) {
        Car car = new Car();
        
        try {
			connection = openConnection();
			query = "select * from car where id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				car.setId(resultSet.getInt(1));
				car.setName(resultSet.getString(2));
				car.setBrand(resultSet.getString(3));
				car.setPrice(resultSet.getDouble(4));
				car.setFuelType(resultSet.getString(5));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        
        return car;
    }

    public void deleteCar(int id) {
    	
    	try {
			connection = openConnection();
			query = "delete from car where id = ?" ;
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int row = preparedStatement.executeUpdate();
			System.out.println("Car is deleted successfully.\n"+row+" rows are affected.");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }
    
    public void uodateCar(int id, Scanner scanner) {
    	
    	try {
			connection = openConnection();
			query = "update car set name = ?, brand = ?, price = ?, fueltype = ? where id = ?";
			preparedStatement = connection.prepareStatement(query);
			scanner.nextLine();
			System.out.println("Enter car name.");
			preparedStatement.setString(1, scanner.nextLine());
			System.out.println("Enter car brand.");
			preparedStatement.setString(2, scanner.nextLine());
			System.out.println("Enter car price.");
			preparedStatement.setDouble(3, scanner.nextDouble());
			System.out.println("Enter fuel type");
			preparedStatement.setString(4, scanner.next());
			preparedStatement.setInt(5, id);
			int row = preparedStatement.executeUpdate();
			System.out.println("Car details updated successfully.\n"+row+" rows are affected.");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }
    
    private Connection openConnection() throws ClassNotFoundException, SQLException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3","root","root");
    }
    
    private void closeConnection() throws SQLException {
    	if (connection != null) {
			connection.close();
		}
    	if (preparedStatement != null) {
			preparedStatement.close();
		}
    	if (resultSet != null) {
			resultSet.close();
		}
    }


}

package com.mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MainCls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SetUp s = new SetUp();  //create an object of setup class
		s.creatDatabase();
	//	s.createTable();
	//	s.insertData();
	//	s.readData();
	//	s.updateData();
	//	s.deleteData();
		
	}
}

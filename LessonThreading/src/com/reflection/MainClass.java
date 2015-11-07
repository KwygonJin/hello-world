package com.reflection;

import java.lang.reflect.*;

public class MainClass {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {		
	    Field field;
		ParentClass child = new ChildClass();
		Class childClass = child.getClass();    
		Field[] fields = childClass.getDeclaredFields(); 
	
		try {
			field = childClass.getField("parentTest");
			System.out.println("Parent public field: " + field.get(child));		    
			field.set(child, "NEW parent test");
			System.out.println("Parent public field new value: " + field.get(child));
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		
		try {
			field = childClass.getDeclaredField("test");
			field.setAccessible(true); //установка возможности редактирования private поля
			System.out.println("Child private field: " + field.get(child) );
			field.set(child, "NEW child test");
			System.out.println("Child private field new value: " + field.get(child));
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}   
		
		try {
			field = childClass.getDeclaredField("privateParentTest");
		} catch (NoSuchFieldException e) {
			System.out.println("Exception on private parent field !");
			e.printStackTrace();
		}
	}
}

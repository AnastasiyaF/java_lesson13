/*
 *  Created by Anastasiya Findziukevich
 *  02/04/2017
 *  
 *  Task 13.
 *  
 *  Проанализируйте библиотеку IO Streams. 
 *  Напишите собственные примеры сериализации, десериализации.
 *  
 *  Задача сделана на основе 11. Первоначально данные считываются с файла. Затем добавляем новый элемент и записываем объекты, затем пробуем считать.
 */

package com.epam.java_training.main;

import com.epam.java_training.controller.ControllerProduct;



public class Main {
	
	
	public static void main(String[] args) {
		
		
		ControllerProduct product_controller = new ControllerProduct();
		
		System.out.println("Все элементы текущие:");
		
		product_controller.printcurrentList();
		
		
		System.out.println("Добавим новый элемент: category_15, code_15, 2017/08/09, annotation_15");
		
		product_controller.addNewElement("category_15", "code_15", "2017/08/09", "annotation_15");
		
		
		System.out.println("Пример сериализации. Сохраним объекты в файл.");
		
		product_controller.saveObjectToFile();
		
		
		System.out.println("Добавим новый элемент: category_17, code_17, 2017/08/09, annotation_17");
		
		product_controller.addNewElement("category_17", "code_17", "2017/08/09", "annotation_17");
		
        
		System.out.println("Все элементы текущие:");
		
		product_controller.printcurrentList();
		
		System.out.println("Пример десериализации. Считываем объекты, которые были записаны в файл: category_17 - нет такой записи.");
		
		product_controller.getObjectsFromFile();
		
	}

}

/*
 *  Created by Anastasiya Findziukevich
 *  02/04/2017
 *  
 *  Task 13.
 *  
 *  ��������������� ���������� IO Streams. 
 *  �������� ����������� ������� ������������, ��������������.
 *  
 *  ������ ������� �� ������ 11. ������������� ������ ����������� � �����. ����� ��������� ����� ������� � ���������� �������, ����� ������� �������.
 */

package com.epam.java_training.main;

import com.epam.java_training.controller.ControllerProduct;



public class Main {
	
	
	public static void main(String[] args) {
		
		
		ControllerProduct product_controller = new ControllerProduct();
		
		System.out.println("��� �������� �������:");
		
		product_controller.printcurrentList();
		
		
		System.out.println("������� ����� �������: category_15, code_15, 2017/08/09, annotation_15");
		
		product_controller.addNewElement("category_15", "code_15", "2017/08/09", "annotation_15");
		
		
		System.out.println("������ ������������. �������� ������� � ����.");
		
		product_controller.saveObjectToFile();
		
		
		System.out.println("������� ����� �������: category_17, code_17, 2017/08/09, annotation_17");
		
		product_controller.addNewElement("category_17", "code_17", "2017/08/09", "annotation_17");
		
        
		System.out.println("��� �������� �������:");
		
		product_controller.printcurrentList();
		
		System.out.println("������ ��������������. ��������� �������, ������� ���� �������� � ����: category_17 - ��� ����� ������.");
		
		product_controller.getObjectsFromFile();
		
	}

}

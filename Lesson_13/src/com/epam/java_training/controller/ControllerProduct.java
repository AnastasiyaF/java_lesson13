package com.epam.java_training.controller;

import java.util.ArrayList;
import java.util.List;

import com.epam.java_training.dao.ProductListDao;
import com.epam.java_training.model.Product;

public class ControllerProduct {
	
	List<Product> result_list;
	ProductListDao product_listDAO;
	
	public ControllerProduct(){
		result_list = new ArrayList<Product>();
		product_listDAO = new ProductListDao();
	}
	
	public void addNewElement(String category, String code, String release, String annotation){
		
		product_listDAO.addProduct(category, code, release, annotation);
		
	}
	
	public void findByParameterList(String category_find, String code_find, String release_find, String annotation_find){
		
		this.result_list = product_listDAO.findByParameter(category_find, code_find, release_find, annotation_find);
		
		this.printList();
		
	}
	
	public void findByParameterString(String string_find){
		
		this.result_list = product_listDAO.findByString(string_find);
		
		this.printList();
		
	}

	public void printList(){
		
		
		if (this.result_list.isEmpty()){
			System.out.println("The collection is empty.");
		}
		
		for (Product product : this.result_list){
			System.out.println(product);		
		}
		
	}
	
	public void printcurrentList(){
		
		product_listDAO.printList();
		
	}
	
	public void saveToFile(){
		
		product_listDAO.saveToFile();
		
	}
	
	public void saveObjectToFile(){
		
		product_listDAO.saveObjectsToFile();
		
	}

	public void getObjectsFromFile(){
	
		this.result_list = product_listDAO.readObjectsFromFile();
		
		this.printList();
	
	}
	
}

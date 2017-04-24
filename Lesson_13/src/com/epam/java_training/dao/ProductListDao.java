package com.epam.java_training.dao;

import java.util.ArrayList;
import java.util.List;

import com.epam.java_training.exception.ExistElementException;
import com.epam.java_training.model.Product;
import com.epam.java_training.source.FileSource;
import com.epam.java_training.source.FileSourceFactory;

public class ProductListDao {

	private List<Product> product_list;
	private FileSource fileSource = FileSourceFactory.getFileSource();
	
	public ProductListDao() {
		this.product_list = fileSource.getProduct_list();
	}
	
	public boolean addProduct(Product product){
		
		if (this.checkExistProduct(product) == true){
			
			throw new ExistElementException(product.toString());
		}
		
		this.product_list.add(product);
		
		fileSource.setProduct_list(this.product_list);
		return true;
	}
	
	public boolean addProduct(String category, String code, String release, String annotation){
		
		Product product = new Product(category, code, release, annotation);
		
		this.product_list.add(product);
		
		fileSource.setProduct_list(this.product_list);
		return true;
	}
	
	
	public boolean deleteProduct(int position){
		
		this.product_list.remove(position);
		return true;
	}

	
	public boolean checkExistProduct(Product current_product){
		
		return this.product_list.contains(current_product);
	}
	
	public void printList(){
		
		if (this.product_list.isEmpty()){
			System.out.println("The collection is empty.");
		}
		
		for (Product product : this.product_list){
			System.out.println(product);		
		}
		
	}
	
	public List<Product> findByParameter(String category_find, String code_find, String release_find, String annotation_find){
		List<Product> result_list = new ArrayList<>();
		Boolean findElement = true;;
		
		for (Product product : this.product_list) {
			
			findElement = true;
			
			if (category_find !=null){
				if (!product.getCategory().equals(category_find)){
					findElement = false;
				} 						
			}
			
			if (code_find !=null){
				if (!product.getCode().equals(code_find)){
					findElement = false;
				} 						
			}
			
			if (release_find !=null){
				if (!product.getRelease_date().equals(release_find)){
					findElement = false;
				} 						
			}
			
			if (annotation_find !=null){
				if (!product.getAnnotation().equals(annotation_find)){
					findElement = false;
				} 						
			}
			
			if (findElement){
				result_list.add(product);
			}
		} 
		
		return result_list;
		
	}
	
	public List<Product> findByString(String string_find){
		List<Product> result_list = new ArrayList<>();
		Boolean findElement = false;
		
		for (Product product : this.product_list) {
			
			findElement = false;
			
			if (string_find !=null){
				if (product.getCategory().contains(string_find)){
					findElement = true;
				}
				else if (product.getCode().contains(string_find)){
					findElement = true;
				} 
				else if (product.getAnnotation().contains(string_find)){
					findElement = true;
				} 		
			}
			
			if (findElement){
				result_list.add(product);
			}
		} 
		
		return result_list;
		
	}
	
	public void saveToFile(){
		
		fileSource.writeToFile();
		
	}
	
	public void saveObjectsToFile(){
		
		fileSource.writeObjectsToFile();
		
	}
	
	public List<Product> readObjectsFromFile(){
		
		List<Product> result_list = new ArrayList<>();
		
		result_list = fileSource.readObjectsFromFile();
		
		return result_list;
		
	}
	
	
}

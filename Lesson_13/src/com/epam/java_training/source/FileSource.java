package com.epam.java_training.source;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.epam.java_training.model.Product;

public class FileSource {
	private String filename = "file.txt";
	private String filename_output = "file_output.txt";
	private String filename_objects = "file_objects.ser";
	
	private File file;
	private File file_output;
	private File file_objects;
	
	List<Product> product_list;
	
	FileSource(){
		file = new File(filename);
		file_output = new File(filename_output);
		file_objects = new File(filename_objects);
		
		product_list = new ArrayList<Product>();
		this.readDataFromFile();
	}
	
	public String getFilename(){
		return this.filename;
	}
	
	public File getFile(){
		return this.file;
	}
	
	public List<Product> getProduct_list(){
		
		return this.product_list;
	}
	
	public void setProduct_list(List<Product> product_list){
		
		this.product_list = product_list;
	}
	
	public void parseString(String read_string){
		
		Product product = new Product();
		
		String delimeters = ";";
		String[] tokens = read_string.split(delimeters);
		
		product.setCategory(tokens[0]);
		product.setCode(tokens[1]);
		product.setRelease_date(tokens[2]);
		product.setAnnotation(tokens[3]);
		
		product_list.add(product);
	}
	
	public void readDataFromFile(){  
		
		try {
			
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String sringFromReader;

			while ((sringFromReader = br.readLine()) != null) {
					this.parseString(sringFromReader);
			}
	
			br.close();
		}
		catch (FileNotFoundException e) {

				e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
    }
	
	public void writeToFile(){
		
		if(this.file_output.exists() == false){
            try {
            	this.file_output.createNewFile() ;
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
		
		try {
			FileWriter fw = new FileWriter(file_output); 
			BufferedWriter bw = new BufferedWriter(fw);
		
	    	
	    	for (Product product : product_list) {
		    	
	    		bw.write(product.stringFormat());
		    	bw.newLine();
			}
	    	
	    	bw.close();
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
	}	
	
	public void writeObjectsToFile(){
		
		System.out.println("Write objects to file - Start.");
		
		if(this.file_objects.exists() == false){
            try {
            	this.file_objects.createNewFile() ;
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
		
		try {
			FileOutputStream fos = new FileOutputStream(file_objects); 
		
			ObjectOutputStream objOutputStream = new ObjectOutputStream(fos);
			
	    	for (Product product : product_list) {
		    	
	    		objOutputStream.writeObject(product);
			}
	    	
	    	fos.close();
	    	
	    	System.out.println("Write objects to file - End.");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Product> readObjectsFromFile(){  
			
		List<Product> result_list = new ArrayList<Product>();
		
		System.out.println("Read objects from file - Start.");
		
		try {
				
			FileInputStream fis = new FileInputStream(file_objects);
			
			ObjectInputStream objInputStream = new ObjectInputStream(fis);

			Object object;
					
			while (fis.available() > 0) {
				
				object = objInputStream.readObject();
				
				if(object instanceof Product){
					
					result_list.add((Product)object);
				}
				else{
					System.out.println("Cannot read objects from file.");
				}
			}
		
			fis.close();
			
			System.out.println("Read objects from file - End.");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return result_list;
	}
}

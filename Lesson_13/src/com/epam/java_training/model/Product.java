package com.epam.java_training.model;

import java.io.Serializable;

public class Product implements Serializable{
	
	private String category;
	private String code;
	private String release_date;
	private String annotation;
	private static final long serialVersionUID = 1L;
	
	public Product(){
		
	}
	
	public Product(String category, String code, String release_date, String annotation) {
		this.category = category;
		this.code = code;
		this.release_date = release_date;
		this.annotation = annotation;
	}

	public String getCategory(){
		return category; 
	}
	
	public void setCategory(String category){
		this.category = category;
	}
	
	public String getCode(){
		return code; 
	}
	
	public void setCode(String code){
		this.code = code; 
	}
	
	public String getRelease_date(){
		return release_date; 
	}
	
	public void setRelease_date(String release_date){
		this.release_date = release_date; 
	}
	
	public String getAnnotation(){
		return annotation; 
	}
	
	public void setAnnotation(String annotation){
		this.annotation = annotation; 
	}
	
	@Override
	public String toString() {
		return "category = " + this.category + ", code = " + this.code + ", release_date = " + this.release_date + ", annotation = " + this.annotation;
	}
	
	public String stringFormat() {
		return this.category + ";" + this.code + ";" + this.release_date + ";" + this.annotation;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((release_date == null) ? 0 : release_date.hashCode());
		result = prime * result + ((annotation == null) ? 0 : annotation.hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object object) {
		
		if( this == object){
			return true;
		}
		
		if (object == null){
			return false;
		}
		
		if (this.getClass() != object.getClass()){
			return false;
		}
		
		Product object_compare = (Product) object;
		
		if (null == category) {
			return (category == object_compare.category);
		} else {
			if (!category.equals(object_compare.category)) {
				return false;
			}
		}
	
		if (null == code) {
			return (code == object_compare.code);
		} else {
			if (!code.equals(object_compare.code)) {
				return false;
			}
		}
		
		if (null == release_date) {
			return (release_date == object_compare.release_date);
		} else {
			if (!release_date.equals(object_compare.release_date)) {
				return false;
			}
		}
		
		if (null == annotation) {
			return (annotation == object_compare.annotation);
		} else {
			if (!annotation.equals(object_compare.annotation)) {
				return false;
			}
		}
		
		
		return true;
	}
}

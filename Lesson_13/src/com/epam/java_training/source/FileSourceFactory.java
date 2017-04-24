package com.epam.java_training.source;

public class FileSourceFactory {
	private static final FileSource filesource = new FileSource();
	
	private FileSourceFactory(){
		
	}
	public static FileSource getFileSource(){

		return filesource;
	}
}

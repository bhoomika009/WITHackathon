package com.hirehelpers.exception;

import java.io.IOException;

public class FileStorageException extends Exception {
	
	 public FileStorageException(String errorMessage) {
	        super(errorMessage);
	    }

	public FileStorageException(String string, IOException ex) {
		ex.printStackTrace();
	}

}

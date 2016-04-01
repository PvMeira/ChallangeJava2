package main;

import java.io.IOException;

import dataManager.Browser;
import reader.ReaderFile;

public class mainStartUp {

	public static void main(String[] args) throws IOException {
		
        
		ReaderFile readNewFile = new ReaderFile();
		readNewFile.readFile();
		Browser browser=new Browser();


	}

}


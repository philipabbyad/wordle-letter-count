package com.exercise.wordlelettercount;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class WordleLetterCount {

   File testFile = new File("hello_world.txt");

    public void readTextFile() {
      try {
         Scanner fileReader = new Scanner(testFile);
         String data = "";
         while (fileReader.hasNextLine()) {
           data = fileReader.nextLine();
           System.out.println(data);
         }
         fileReader.close();


       } catch (FileNotFoundException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
       }
    }
 
 }

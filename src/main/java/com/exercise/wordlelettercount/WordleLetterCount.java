package com.exercise.wordlelettercount;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class WordleLetterCount {

   File testFile = new File("names.txt");
   ArrayList<String> names = new ArrayList<>();

   public void readTextFile() {
      try {
         Scanner fileReader = new Scanner(testFile);
         while (fileReader.hasNextLine()) {
            names.add(fileReader.nextLine());
         }
         fileReader.close();
      } catch (FileNotFoundException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
      }

      for (String name : names) {
         System.out.println("Hello, " + name + "!");
      }
   }

   
   
 
 }

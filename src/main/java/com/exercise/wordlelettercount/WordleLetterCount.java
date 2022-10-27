package com.exercise.wordlelettercount;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class WordleLetterCount {

   File testFile = new File("names.txt");
   ArrayList<String> names = new ArrayList<>();

   public HashMap readTextFile() {
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

      HashMap<String, Integer> words = new HashMap<>();
      for (String name : names) {
         words.put(name, countUniqueLetters(name));
      }
      return words;
   }

   public Integer countUniqueLetters(String word) {
      Integer numUniqueLetters = 5;
      char[] charsInWord = word.toCharArray();
      StringBuilder charsToSkip = new StringBuilder();

      for (int charIndex = 0; charIndex < charsInWord.length; charIndex++) {
         if (charsToSkip.toString().indexOf(charsInWord[charIndex]) == -1) {
            for (int charIndexToCompare = charIndex + 1; charIndexToCompare < charsInWord.length; charIndexToCompare++) {
               if(charsInWord[charIndex] == charsInWord[charIndexToCompare]) {
                  numUniqueLetters--;
                  charsToSkip.append(charsInWord[charIndex]);
               }
            } 
         }
      }
      return numUniqueLetters;
   }
 }

package com.exercise.wordlelettercount;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class WordleLetterCount {

   File testFile = new File("names.txt");
   ArrayList<String> words = new ArrayList<>();

   public HashMap readTextFile() {
      try {
         Scanner fileReader = new Scanner(testFile);
         while (fileReader.hasNextLine()) {
            words.add(fileReader.nextLine());
         }
         fileReader.close();
      } catch (FileNotFoundException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
      }

      HashMap<String, Integer> wordsWithCount = new HashMap<>();
      for (String word : words) {
         // words.put(name, countUniqueLetters(name));
         wordsWithCount.put(word, countMostRepeatedLetter(word));
      }
      return wordsWithCount;
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

   public Integer countMostRepeatedLetter(String word) {
      char[] charsInWord = word.toCharArray();
      HashMap<Character, Integer> repeatedLetters = new HashMap<>();
      Integer mostRepeatedLetterCount = 1;
      StringBuilder charsToSkip = new StringBuilder();

      for (int charIndex = 0; charIndex < charsInWord.length; charIndex++) {
         if (charsToSkip.toString().indexOf(charsInWord[charIndex]) == -1) {
            for (int charIndexToCompare = charIndex + 1; charIndexToCompare < charsInWord.length; charIndexToCompare++) {
               if(charsInWord[charIndex] == charsInWord[charIndexToCompare]) {
                  Character repeatedCharacter = charsInWord[charIndex];
                  if (!repeatedLetters.containsKey(repeatedCharacter)) {
                     repeatedLetters.put(repeatedCharacter, 2);
                     charsToSkip.append(charsInWord[charIndex]);
                  } else {
                     repeatedLetters.put(repeatedCharacter, repeatedLetters.get(repeatedCharacter) + 1);
                  }
               }
            } 
         }
      }

      for (Integer value : repeatedLetters.values()) {
         if (value > mostRepeatedLetterCount) {
            mostRepeatedLetterCount = value;
         }
      }

      return mostRepeatedLetterCount;
   }



 }
package com.exercise.wordlelettercount;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.FileNotFoundException;

public class WordleLetterCount {

   public ArrayList<String> createWordListFromFile() {
      File testFile = new File("names.txt");
      ArrayList<String> wordList = new ArrayList<>();

      try {
         Scanner fileReader = new Scanner(testFile);
         while (fileReader.hasNextLine()) {
            wordList.add(fileReader.nextLine());
         }
         fileReader.close();
      } catch (FileNotFoundException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
      }

      return wordList;
   }

   public TreeMap createMapOfWordsAndRepeatLetterCounts (ArrayList<String> wordList) {
      TreeMap<String, Integer> wordsWithCount = new TreeMap<>();
      for (String word : wordList) {
         String cleanedWord = cleanWord(word);
         if (cleanedWord.length() == 5) {
            wordsWithCount.put(word, countMostRepeatedLetter(cleanedWord));
         }
      }
      return wordsWithCount;
   }

   public TreeMap createMapOfWordsAndUniqueLetterCounts (ArrayList<String> wordList) {
      TreeMap<String, Integer> wordsWithCount = new TreeMap<>();
      for (String word : wordList) {
         String cleanedWord = cleanWord(word);
         if (cleanedWord.length() == 5) {
            wordsWithCount.put(word, countUniqueLetters(cleanedWord));
         }
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

   public String cleanWord(String word) {
      StringBuilder cleanWordStringBuilder = new StringBuilder();
      String cleanWord = word.trim().toLowerCase();
      char[] charsInCleanedWord = cleanWord.toCharArray();

      for (char cleanChar : charsInCleanedWord) {
         if (Character.isLetter(cleanChar)) {
            cleanWordStringBuilder.append(cleanChar);
         }
      }

      cleanWord = cleanWordStringBuilder.toString();

      return cleanWord;
   }
 }
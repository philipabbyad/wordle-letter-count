package com.exercise.wordlelettercount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WordleLetterCountApplication {

	public static void main(String[] args) {
		WordleLetterCount letterCount = new WordleLetterCount();
		System.out.println(letterCount.createMapOfWordsAndRepeatLetterCounts(letterCount.createWordListFromFile()));
	}
}
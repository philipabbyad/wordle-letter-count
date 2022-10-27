package com.exercise.wordlelettercount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WordleLetterCountApplication {

	public static void main(String[] args) {
		WordleLetterCount letterCount = new WordleLetterCount();
		//  letterCount.readTextFile();
		// System.out.println(letterCount.countUniqueLetters("rrtty"));
		System.out.println(letterCount.readTextFile());
	}

}

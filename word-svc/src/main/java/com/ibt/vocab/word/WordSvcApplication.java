package com.ibt.vocab.word;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import com.ibt.vocab.word.model.Word;
import com.ibt.vocab.word.service.WordService;
import java.util.Arrays;

@SpringBootApplication
public class WordSvcApplication implements CommandLineRunner {

	@Autowired
	private WordService wordService;

	public static void main(String[] args) {
		SpringApplication.run(WordSvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Word word = new Word();
		word.setWord("hello");
		word.setMeaning("greeting");
		word.setExamples(Arrays.asList("hello world", "hello there"));
		wordService.addWord(word);

		Word word1 = new Word();
		word1.setWord("hello1");
		word1.setMeaning("greeting");
		word1.setExamples(Arrays.asList("hello world", "hello there"));

		wordService.addWord(word);
		wordService.addWord(word1);
		System.out.println(wordService.count());
	}

}

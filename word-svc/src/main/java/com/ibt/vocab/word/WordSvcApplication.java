package com.ibt.vocab.word;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import com.ibt.vocab.word.model.Word;
import com.ibt.vocab.word.service.WordService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.core.io.ClassPathResource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class WordSvcApplication implements CommandLineRunner {

    @Autowired
    private WordService wordService;

    @Override
    public void run(String... args) throws Exception {
        // Print initial count
        log.info("Initial word count: " + wordService.count());

        // Read JSON file
        ObjectMapper mapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("import-words.json");
        Map<String, List<Word>> wordsMap = mapper.readValue(
            resource.getInputStream(),
            new TypeReference<Map<String, List<Word>>>() {}
        );

        // Add words from JSON
        List<Word> words = wordsMap.get("words");
        for (Word word : words) {
            wordService.addWord(word);
        }

        // Add your existing test words
        Word word = new Word();
        word.setWord("hello");
        word.setMeaning("greeting");
        word.setExamples(Arrays.asList("hello world", "hello there"));
        wordService.addWord(word);

        Word word1 = new Word();
        word1.setWord("hello1");
        word1.setMeaning("greeting");
        word1.setExamples(Arrays.asList("hello world", "hello there"));
        wordService.addWord(word1);

        // Print final count

        log.info("All words:");
        log.debug(mapper.writeValueAsString(wordService.getAllWords()));
        log.info("Final word count: " + wordService.count());


    }

    public static void main(String[] args) {
        SpringApplication.run(WordSvcApplication.class, args);
    }
}

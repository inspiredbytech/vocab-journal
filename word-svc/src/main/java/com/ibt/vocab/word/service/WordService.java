package com.ibt.vocab.word.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ibt.vocab.word.model.Word;
import com.ibt.vocab.word.repository.WordRepository;


@Service
public class WordService {
 
    private final WordRepository wordRepository;

    @Autowired
    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public Word addWord(Word word) {
        //TODO: findByWord().orElse(wordRepository.save(word));
        return wordRepository.save(word);
    }

    public List<Word> getAllWords() {
        return wordRepository.findAll();
    }

    public Word getWordById(UUID id) {
        return wordRepository.findById(id).orElseThrow(() -> new RuntimeException("Word not found"));
    }

    public Word updateWord(Word word) {
        return wordRepository.save(word);
    }

    public void deleteWord(UUID id) {
        wordRepository.deleteById(id);
    }

    public long count() {
        return wordRepository.count();
    }

}

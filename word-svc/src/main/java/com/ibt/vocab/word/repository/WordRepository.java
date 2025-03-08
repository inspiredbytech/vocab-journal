package com.ibt.vocab.word.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ibt.vocab.word.model.Word;
import com.ibt.vocab.word.service.WordService;

@Repository
public interface WordRepository extends JpaRepository<Word, UUID> {
    
}

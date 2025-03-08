package com.ibt.vocab.word.model;
import java.util.List;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor
@Entity 
@Getter
@Setter
@Table(name = "word")
public class Word {
    
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "word", nullable = false, unique = false)
    private String word;


    @Column(name = "meaning", nullable = true, unique = false)
    private String meaning;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @Column(name = "examples", nullable = true, unique = false)
    private List<String> examples;
}

package com.vocabularyapp.entitiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="vocab")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vocabulary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="word")
    private String word;
    @Column(name="word_eng")
    private String wordEng;
    @Column(name="count")
    private int count;
    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;


}

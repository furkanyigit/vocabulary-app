package com.vocabularyapp.repository;

import com.vocabularyapp.entitiy.Vocabulary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VocabularyRepository extends JpaRepository<Vocabulary,Long> {
    Page<Vocabulary> findAll(Pageable pageable);
}

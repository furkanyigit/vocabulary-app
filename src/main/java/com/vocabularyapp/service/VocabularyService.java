package com.vocabularyapp.service;


import com.vocabularyapp.entitiy.Vocabulary;
import com.vocabularyapp.service.dto.Practic;

import java.util.List;

public interface VocabularyService {

    Vocabulary save(Vocabulary vocabulary);
    Vocabulary getById(Long id);
    List<Vocabulary> getAll();
    void deleteById(Long id);
    Boolean update(Vocabulary vocabulary,Long id);
    Boolean counter(Long id, Practic practic);
    List<Vocabulary> getVocabulary(int no, int size);

}

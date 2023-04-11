package com.vocabularyapp.service;

import com.vocabularyapp.entitiy.Vocabulary;
import com.vocabularyapp.repository.VocabularyRepository;
import com.vocabularyapp.service.dto.Practic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VocabularyServiceImpl implements VocabularyService {
    @Autowired
    VocabularyRepository vocabularyRepository;

    @Override
    public Vocabulary save(Vocabulary vocabulary) {
        vocabularyRepository.save(vocabulary);
        return vocabulary;
    }


    @Override
    public Page<Vocabulary> getVocabulary(int no, int size,int count1, int count2) {
        Pageable pageable = PageRequest.of(no, size);
        Page<Vocabulary> vocabularyPage = vocabularyRepository.findAllByCountBetween(count1,count2,pageable);
        vocabularyPage.getTotalElements();
        return vocabularyPage;
    }

    @Override
    public Vocabulary getById(Long id) {
        return vocabularyRepository.findById(id).orElse(null);
    }

    @Override
    public List<Vocabulary> getAll() {
        return vocabularyRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        vocabularyRepository.deleteById(id);
    }

    @Override
    public Boolean update(Vocabulary vocabulary, Long id) {
        Vocabulary dbVocabulary = vocabularyRepository.findById(id).orElse(null);
        if (dbVocabulary != null) {
            dbVocabulary.setWord(vocabulary.getWord());
            dbVocabulary.setWordEng(vocabulary.getWordEng());
            vocabularyRepository.save(dbVocabulary);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean counter(Long id, Practic practic) {

        Vocabulary dbVocabulary = vocabularyRepository.findById(id).orElse(null);
        if (dbVocabulary != null) {
            if (practic.getIsEnglish() && dbVocabulary.getWordEng().equalsIgnoreCase(practic.getEntryWord()) ||
                !practic.getIsEnglish() && dbVocabulary.getWord().equalsIgnoreCase(practic.getEntryWord()) ) {

                dbVocabulary.setCount(dbVocabulary.getCount() + 1);
                vocabularyRepository.save(dbVocabulary);
                return Boolean.TRUE;
            }
            else {
                return Boolean.FALSE;
            }
        }
        else {
            return Boolean.FALSE;
        }
    }
}

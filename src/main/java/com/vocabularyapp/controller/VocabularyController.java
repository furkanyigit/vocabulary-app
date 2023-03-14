package com.vocabularyapp.controller;

import com.vocabularyapp.entitiy.Vocabulary;
import com.vocabularyapp.service.dto.Practic;
import com.vocabularyapp.service.VocabularyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vocabulary")
@CrossOrigin(origins = "http://localhost:3000")
public class VocabularyController {
    @Autowired
    VocabularyServiceImpl vocabularyService;

    @GetMapping("")
    public List<Vocabulary> getVocabulary(){
        return  vocabularyService.getAll();
    }
    @PostMapping("")
    public ResponseEntity<Vocabulary> create(@RequestBody Vocabulary newVocabulary){
        Vocabulary vocabulary = vocabularyService.save(newVocabulary);
        return  new ResponseEntity<>(vocabulary, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public Boolean update(@RequestBody Vocabulary newVocabulary, @PathVariable Long id){
        return vocabularyService.update(newVocabulary, id);
    }
    @PutMapping("/practic/{id}")
    public Boolean counter(@RequestBody Practic practic, @PathVariable Long id){
        return vocabularyService.counter(id,practic);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        vocabularyService.deleteById(id);
    }
}

package com.vocabularyapp.controller;

import com.vocabularyapp.entitiy.Vocabulary;
import com.vocabularyapp.repository.VocabularyRepository;
import com.vocabularyapp.service.VocabularyServiceImpl;
import com.vocabularyapp.service.dto.Practic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    @Autowired
    private VocabularyRepository vocabularyRepository;


    @GetMapping()
    public List<Vocabulary> getVocabulary(){
        return  vocabularyService.getAll();
    }
    @GetMapping("/pageable")
    public Page<Vocabulary> getVocabulary(@RequestParam int page, @RequestParam int size, @RequestParam int count1, @RequestParam int count2 ){
        return vocabularyService.getVocabulary(page,size,count1,count2);
    }

    @PostMapping()
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

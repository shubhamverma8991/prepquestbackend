package com.prepquest.prepquest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prepquest.prepquest.model.Language;
import com.prepquest.prepquest.repository.LanguageRepository;

@Service
public class LanguageService {
    @Autowired
    public LanguageRepository languagerepository;

    // Save Indiviual Language
    public Language saveLang(Language lang) {
        return languagerepository.save(lang);
    }

    // Get All Language
    public List<Language> getAllLang() {
        return languagerepository.findAll();
    }
    
}

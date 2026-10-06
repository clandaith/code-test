package com.troydavidson.rest_service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface NoteRepository extends JpaRepository<Note, Long> {
    
    static final Logger logger = LoggerFactory.getLogger(NoteRepository.class);
}

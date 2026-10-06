package com.troydavidson.rest_service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class Note {
    
    private static final Logger logger = LoggerFactory.getLogger(Note.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private String content;

    public Note() {
        logger.info("DEBUG MSG: Creating empty Note entity");
    }

    public Note(Long id, String name, String content) {
        logger.info("DEBUG MSG: Creating Note entity with id: {}, name: {}, and content: {}", id, name, content);
        this.id = id;
        this.name = name;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        logger.info("DEBUG MSG: Setting Note id to: {}", id);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        logger.info("DEBUG MSG: Setting Note name to: {}", name);
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        logger.info("DEBUG MSG: Setting Note content to: {}", content);
        this.content = content;
    }
}

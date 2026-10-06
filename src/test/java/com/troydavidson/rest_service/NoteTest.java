package com.troydavidson.rest_service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

class NoteTest {

    private static final Logger logger = LoggerFactory.getLogger(NoteTest.class);

    @Test
    void testNoteCreation() {
        logger.info("DEBUG MSG: Starting testNoteCreation");
        Note note = new Note(1L, "TestUser", "Test content");
        
        assertThat(note.getId()).isEqualTo(1L);
        assertThat(note.getName()).isEqualTo("TestUser");
        assertThat(note.getContent()).isEqualTo("Test content");
        logger.info("DEBUG MSG: Completed testNoteCreation successfully");
    }

    @Test
    void testNoteSettersAndGetters() {
        logger.info("DEBUG MSG: Starting testNoteSettersAndGetters");
        Note note = new Note();
        
        note.setId(2L);
        note.setName("UpdatedUser");
        note.setContent("Updated content");
        
        assertThat(note.getId()).isEqualTo(2L);
        assertThat(note.getName()).isEqualTo("UpdatedUser");
        assertThat(note.getContent()).isEqualTo("Updated content");
        logger.info("DEBUG MSG: Completed testNoteSettersAndGetters successfully");
    }

    @Test
    void testDefaultConstructor() {
        logger.info("DEBUG MSG: Starting testDefaultConstructor");
        Note note = new Note();
        
        assertThat(note.getId()).isNull();
        assertThat(note.getName()).isNull();
        assertThat(note.getContent()).isNull();
        logger.info("DEBUG MSG: Completed testDefaultConstructor successfully");
    }
}

package com.troydavidson.rest_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class NoteRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(NoteRepositoryTest.class);

    @Autowired
    private NoteRepository noteRepository;

    @Test
    void testSaveAndFindNote() {
        logger.info("DEBUG MSG: Starting testSaveAndFindNote");
        Note note = new Note(null, "TestUser", "Test content");
        Note savedNote = noteRepository.save(note);
        
        assertThat(savedNote.getId()).isNotNull();
        assertThat(savedNote.getName()).isEqualTo("TestUser");
        assertThat(savedNote.getContent()).isEqualTo("Test content");
        
        Note foundNote = noteRepository.findById(savedNote.getId()).orElse(null);
        assertThat(foundNote).isNotNull();
        assertThat(foundNote.getName()).isEqualTo("TestUser");
        assertThat(foundNote.getContent()).isEqualTo("Test content");
        logger.info("DEBUG MSG: Completed testSaveAndFindNote successfully");
    }

    @Test
    void testFindAllNotes() {
        logger.info("DEBUG MSG: Starting testFindAllNotes");
        noteRepository.save(new Note(null, "User1", "First note"));
        noteRepository.save(new Note(null, "User2", "Second note"));
        
        var notes = noteRepository.findAll();
        assertThat(notes).hasSizeGreaterThanOrEqualTo(2);
        logger.info("DEBUG MSG: Completed testFindAllNotes successfully");
    }

    @Test
    void testDeleteNote() {
        logger.info("DEBUG MSG: Starting testDeleteNote");
        Note note = noteRepository.save(new Note(null, "TestUser", "To be deleted"));
        Long noteId = note.getId();
        
        noteRepository.deleteById(noteId);
        
        assertThat(noteRepository.findById(noteId)).isEmpty();
        logger.info("DEBUG MSG: Completed testDeleteNote successfully");
    }
}

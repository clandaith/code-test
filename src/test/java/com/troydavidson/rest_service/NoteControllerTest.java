package com.troydavidson.rest_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class NoteControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(NoteControllerTest.class);

    @Autowired
    private NoteController noteController;

    @Test
    void testGetNote() {
        logger.info("DEBUG MSG: Starting testGetNote");
        Note noteRequest = new Note(null, "Troy", "Hello, Troy!");
        Note createdNote = noteController.notePost(noteRequest);
        Long noteId = createdNote.getId();
        
        Note retrievedNote = noteController.note(noteId);
        
        assertThat(retrievedNote).isNotNull();
        assertThat(retrievedNote.getId()).isEqualTo(noteId);
        assertThat(retrievedNote.getName()).isEqualTo("Troy");
        assertThat(retrievedNote.getContent()).isEqualTo("Hello, Troy!");
        logger.info("DEBUG MSG: Completed testGetNote successfully");
    }

    @Test
    void testGetNotes() {
        logger.info("DEBUG MSG: Starting testGetNotes");
        var notes = noteController.notes();
        
        assertThat(notes).isNotNull();
        logger.info("DEBUG MSG: Completed testGetNotes successfully");
    }

    @Test
    void testPostNote() {
        logger.info("DEBUG MSG: Starting testPostNote");
        Note noteRequest = new Note(null, "Troy", "Hello, Troy!");
        Note note = noteController.notePost(noteRequest);
        
        assertThat(note).isNotNull();
        assertThat(note.getName()).isEqualTo("Troy");
        assertThat(note.getContent()).isEqualTo("Hello, Troy!");
        assertThat(note.getId()).isNotNull();
        logger.info("DEBUG MSG: Completed testPostNote successfully");
    }
}

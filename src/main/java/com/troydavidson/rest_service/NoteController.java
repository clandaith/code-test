package com.troydavidson.rest_service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

  private static final Logger logger = LoggerFactory.getLogger(NoteController.class);

  @Autowired
  private NoteRepository noteRepository;

  @GetMapping("/note")
  public Note note(@RequestParam() Long id) {
    logger.info("DEBUG MSG: Retrieving note with id: {}", id);
    return noteRepository.findById(id).orElse(null);
  }

    @GetMapping("/notes")
  public List<Note> notes() {
    logger.info("DEBUG MSG: Retrieving all notes");
    return noteRepository.findAll();
  }

    @PostMapping ("/note")
  public Note notePost(@RequestBody Note note) {
    logger.info("DEBUG MSG: Creating note via POST with name: {} and content: {}", note.getName(), note.getContent());
    Note noteToSave = new Note(null, note.getName(), note.getContent());
    Note savedNote = noteRepository.save(noteToSave);
    logger.info("DEBUG MSG: Saved note via POST with id: {}", savedNote.getId());
    return savedNote;
  }

    @DeleteMapping("/note")
  public void deleteNote(@RequestParam() Long id) {
    logger.info("DEBUG MSG: Deleting note with id: {}", id);
    noteRepository.deleteById(id);
    logger.info("DEBUG MSG: Deleted note with id: {}", id);
  }
}
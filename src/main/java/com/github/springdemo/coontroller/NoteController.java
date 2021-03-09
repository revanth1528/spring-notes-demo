package com.github.springdemo.coontroller;


import com.github.springdemo.exception.NotesNotFoundException;
import com.github.springdemo.model.Notes;
import com.github.springdemo.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class NoteController {

    @Autowired
    NoteRepository noteRepository;

    @GetMapping("/notes")
    public List<Notes> getAllNotes() {
        return noteRepository.findAll();
    }

    @PostMapping("/note")
    public Notes createNote(@Valid @RequestBody Notes note) {
        return noteRepository.save(note);
    }

    @GetMapping("/notes/{id}")
    public Notes getNoteById(@PathVariable(value = "id") Long noteId) {
        return noteRepository.findById(noteId)
                .orElseThrow(() -> new NotesNotFoundException("id", noteId));
    }

    @PutMapping("/notes/{id}")
    public Notes updateNote(@PathVariable(value = "id") Long noteId,
                            @Valid @RequestBody Notes noteDetails) {

        Notes note = noteRepository.findById(noteId)
                .orElseThrow(() -> new NotesNotFoundException("id", noteId));

        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

        return noteRepository.save(note);
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        Notes note = noteRepository.findById(noteId)
                .orElseThrow(() -> new NotesNotFoundException("id", noteId));

        noteRepository.delete(note);

        return ResponseEntity.ok().build();
    }
}

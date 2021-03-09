package com.github.springdemo.repository;

import com.github.springdemo.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Notes, Long> {
}

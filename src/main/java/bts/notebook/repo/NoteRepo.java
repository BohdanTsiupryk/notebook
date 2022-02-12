package bts.notebook.repo;

import bts.notebook.model.Note;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface NoteRepo extends R2dbcRepository<Note, Long> {
}

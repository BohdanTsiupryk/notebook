package bts.notebook.service;

import bts.notebook.model.Note;
import bts.notebook.repo.NoteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepo repo;

    public Flux<Note> getAll(Boolean checked) {
        Flux<Note> all = repo.findAll();

        if (!checked) {
            return all.filter(note -> !note.isChecked());
        }
        return all;
    }

    public Mono<Note> getOne(Long id) {
        return repo.findById(id);
    }

    public Mono<Note> add(Note note) {

        note.setId(null);

        return repo.save(note);
    }

    public void remove(Long id) {
        repo.deleteById(id).subscribe();
    }

    public Mono<Note> edit(Long id, Note note) {
        note.setId(id);
        return repo.save(note);
    }
}

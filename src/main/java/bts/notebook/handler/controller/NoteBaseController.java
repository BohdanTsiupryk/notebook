package bts.notebook.handler.controller;

import bts.notebook.model.Note;
import bts.notebook.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteBaseController {

    private final NoteService noteService;

    @GetMapping
    public Flux<Note> getAll() {
        return noteService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Note> getOne(@PathVariable Long id) {
        return noteService.getOne(id);
    }

    @PostMapping
    public Mono<Note> add(@RequestBody Note note) {
        return noteService.add(note);
    }
}

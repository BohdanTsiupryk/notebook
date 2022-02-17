package bts.notebook.handler.controller;

import bts.notebook.model.Note;
import bts.notebook.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;

@CrossOrigin("*")
@RestController
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteBaseController {

    private final NoteService noteService;

    @GetMapping
    public Flux<Note> getAll(@RequestParam(required = false, defaultValue = "false") Boolean checked) {
        return noteService.getAll(checked)
            .sort(Comparator.comparingLong(Note::getId));
    }

    @GetMapping("/{id}")
    public Mono<Note> getOne(@PathVariable Long id) {
        return noteService.getOne(id);
    }

    @PostMapping
    public Mono<Note> add(@RequestBody Note note) {
        return noteService.add(note);
    }

    @PostMapping("/{id}")
    public Mono<Note> save(@PathVariable Long id, @RequestBody Note note) {
        return noteService.edit(id, note);
    }

    @DeleteMapping("/{id}")
    public Mono<HttpStatus> remove(@PathVariable Long id) {
        noteService.remove(id);

        return Mono.just(HttpStatus.NO_CONTENT);
    }
}

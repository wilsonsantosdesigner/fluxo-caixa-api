package com.developer.controllers;

import com.developer.data.models.ContaReceber;
import com.developer.services.ContaReceberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/conta_receber/v1")
public class ContaReceberController {

    @Autowired
    private ContaReceberService cbService;


    // CREATE
    @PostMapping
    public ResponseEntity<ContaReceber> create(@RequestBody ContaReceber cb) {
        ContaReceber created = cbService.create(cb);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();

        // opcional: retornar Location header
        return ResponseEntity.created(location).body(created);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<ContaReceber>> findAll() {
        List<ContaReceber> list = cbService.findAll();
        return ResponseEntity.ok(list);
    }

    // READ by ID
    @GetMapping("/{id}")
    public ResponseEntity<ContaReceber> findById(@PathVariable Long id) {
        ContaReceber cb = cbService.findById(id);
        if (cb == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cb);
    }

    // READ by descricao
    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<ContaReceber> findByDescricao(@PathVariable String descricao) {
        ContaReceber cb = cbService.findByDescricao(descricao);
        if (cb == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cb);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ContaReceber> update(@PathVariable Long id, @RequestBody ContaReceber cb) {
        // assegura que o id do body é o id do path
        cb.setId(id);
        ContaReceber updated = cbService.update(cb);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cbService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

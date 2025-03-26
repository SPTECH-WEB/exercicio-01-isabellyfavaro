package com.example.apiFaturas.controller;

import com.example.apiFaturas.model.Fatura;
import com.example.apiFaturas.service.FaturaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/faturas")
public class FaturaController {
    private final FaturaService faturaService;
    public FaturaController(FaturaService faturaService) {
        this.faturaService = faturaService;
    }

    @GetMapping
    public List<Fatura> listarFaturas() {
        return faturaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fatura> buscarFatura(@PathVariable Long id) {
        Optional<Fatura> fatura = faturaService.buscarPorId(id);
        return fatura.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Fatura>criarFatura(@Valid @RequestBody Fatura fatura) {
        Fatura novaFatura = faturaService.salvar(fatura);
        return ResponseEntity.ok(novaFatura);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFatura(@PathVariable Long id) {
        if (faturaService.buscarPorId(id).isPresent()) {
            faturaService.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}

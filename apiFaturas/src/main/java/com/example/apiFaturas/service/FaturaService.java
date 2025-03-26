package com.example.apiFaturas.service;

import com.example.apiFaturas.model.Fatura;
import com.example.apiFaturas.repository.FaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaturaService {
    private final FaturaRepository faturaRepository;
    public FaturaService(FaturaRepository faturaRepository) {
        this.faturaRepository = faturaRepository;
    }

    public List<Fatura> listarTodos() {
        return faturaRepository.findAll();
    }

    public Optional<Fatura> buscarPorId(Long id) {
        return faturaRepository.findById(id);
    }

    public Fatura salvar (Fatura boleto) {
        return faturaRepository.save(boleto);
    }

    public void deletar (Long id) {
        faturaRepository.deleteById(id);
    }
}

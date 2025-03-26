package com.example.apiFaturas.repository;

import com.example.apiFaturas.model.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaturaRepository extends JpaRepository<Fatura, Long> {

}

package com.developer.repository;

import com.developer.data.models.ContaReceber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaReceberRepository extends JpaRepository<ContaReceber, Long> {
    ContaReceber findByDescricao(String descricao);
}

package com.manutencaoerp.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manutencaoerp.dev.entity.ServicoLocal;

public interface ServicoLocalRepository extends JpaRepository <ServicoLocal, Long> {
    
}

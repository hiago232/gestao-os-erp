package com.crmoperacional.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crmoperacional.dev.entity.ServicoLocal;

public interface ServicoLocalRepository extends JpaRepository <ServicoLocal, Long> {
    
}

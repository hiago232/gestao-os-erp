package com.gestaooserp.dev.repository;

import com.gestaooserp.dev.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository  extends JpaRepository <Cliente,Long> {
}

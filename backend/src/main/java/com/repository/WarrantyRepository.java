package com.repository;

import com.model.Warranty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarrantyRepository extends JpaRepository<Warranty, Long> {
}

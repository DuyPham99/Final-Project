package com.repository;

import com.model.WarrantyHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarrantyHistoryRepository extends JpaRepository<WarrantyHistory, Long> {
}

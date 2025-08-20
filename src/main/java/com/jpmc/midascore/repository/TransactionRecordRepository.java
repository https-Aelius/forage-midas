package com.jpmc.midascore.repository;

import com.jpmc.midascore.entity.TransactionRecord;
import org.springframework.data.repository.CrudRepository;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRecordRepository extends CrudRepository<TransactionRecord, Long> {
}

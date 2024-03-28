package com.assessment.assessment.History;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository  extends JpaRepository<HistoryEntity, UUID> {

}

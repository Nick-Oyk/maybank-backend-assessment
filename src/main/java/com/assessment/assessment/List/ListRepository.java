package com.assessment.assessment.List;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository  extends JpaRepository<ListEntity, UUID> {

}

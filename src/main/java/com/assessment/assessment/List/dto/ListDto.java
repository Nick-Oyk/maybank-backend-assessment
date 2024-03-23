package com.assessment.assessment.List.dto;

import java.sql.Timestamp;
import java.util.UUID;
import lombok.Data;

@Data
public class ListDto {

  private UUID id;
  private String task;
  private Boolean isCompleted;
  private Timestamp createdAt;
  
}

package com.assessment.assessment.History.dto;

import java.sql.Timestamp;
import java.util.UUID;

import lombok.Data;

@Data
public class HistoryDto {

  private UUID id;
  private String description;
  private Boolean isFavourite;
  private Timestamp createdAt; 
  private Boolean isDeleted;

  
}

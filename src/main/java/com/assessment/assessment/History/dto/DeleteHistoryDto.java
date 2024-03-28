package com.assessment.assessment.History.dto;

import lombok.Data;

@Data
public class DeleteHistoryDto {

  private String description;
  private Boolean isFavourite;
  private Boolean isDeleted;
  
}

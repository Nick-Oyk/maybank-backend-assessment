package com.assessment.assessment.History.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateHistoryDto {

  @NotBlank(message = "description must not be blank")
  private String description;
  private Boolean isFavourite;
  private Boolean isDeleted;
  
}
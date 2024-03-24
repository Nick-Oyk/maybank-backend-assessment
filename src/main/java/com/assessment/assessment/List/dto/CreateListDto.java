package com.assessment.assessment.List.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateListDto {

  @NotBlank(message = "task must not be blank")
  private String task;
  private Boolean isCompleted;
  
}
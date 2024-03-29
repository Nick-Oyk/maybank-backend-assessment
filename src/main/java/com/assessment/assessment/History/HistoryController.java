package com.assessment.assessment.History;

import com.assessment.assessment.History.dto.CreateHistoryDto;
import com.assessment.assessment.History.dto.HistoryDto;
import com.assessment.assessment.History.dto.UpdateHistoryDto;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/history")
@EnableTransactionManagement
public class HistoryController {

  @Autowired
  private HistoryService historyService;

  @GetMapping("")
  @Operation(summary = "get history items")
  public ResponseEntity<List<HistoryDto>> getHistoryItems() {
    return historyService.getHistoryItems();
  }

  @PostMapping("")
  @Operation(summary = "create a history item")
  public ResponseEntity<HistoryEntity> createHistoryItem(
    @Valid @RequestBody CreateHistoryDto input
  ) {
    return historyService.createHistoryItem(input);
  }

  @PatchMapping("/{id}")
  @Operation(summary = "update a list item")
  public ResponseEntity<HistoryEntity> updateListItem(
    @PathVariable UUID id,
    @Valid @RequestBody UpdateHistoryDto input
  ) {
    return historyService.updateHistoryItem(id, input);
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "delete a history item")
  public ResponseEntity<HistoryEntity> deleteHistoryItem(@PathVariable UUID id) {
    return historyService.deleteHistoryItem(id);
  }
}

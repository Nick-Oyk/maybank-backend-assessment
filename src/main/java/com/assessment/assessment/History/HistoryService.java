package com.assessment.assessment.History;

import com.assessment.assessment.History.dto.CreateHistoryDto;
import com.assessment.assessment.History.dto.DeleteHistoryDto;
import com.assessment.assessment.History.dto.HistoryDto;
import com.assessment.assessment.History.dto.UpdateHistoryDto;
import com.assessment.assessment.History.mapper.HistoryMapper;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {

  @Autowired
  private HistoryRepository historyRepository;

  @Autowired
  private HistoryMapper historyMapper;

  @SneakyThrows
  @Transactional
  public ResponseEntity<List<HistoryDto>> getHistoryItems() {
    try {
      List<HistoryDto> result = historyMapper.entitiesToDtos(
        historyRepository.findAll()
      );
      return new ResponseEntity<>(result, HttpStatus.OK);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @SneakyThrows
  @Transactional
  @SuppressWarnings("null")
  public ResponseEntity<HistoryEntity> createHistoryItem(
    CreateHistoryDto input
  ) {
    try {
      HistoryEntity history = new HistoryEntity();
      HistoryEntity itemsToSave = historyMapper.createHistoryFromDto(
        input,
        history
      );
      HistoryEntity result = historyRepository.save(itemsToSave);
      return new ResponseEntity<>(result, HttpStatus.CREATED);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @SneakyThrows
  @Transactional
  @SuppressWarnings("null")
  public ResponseEntity<HistoryEntity> updateHistoryItem(
    @NonNull UUID id,
    UpdateHistoryDto input
  ) {
    Optional<HistoryEntity> result = historyRepository.findById(id);
    if (!result.isPresent()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    try {
      HistoryEntity history = result.get();
      historyMapper.updateHistoryFromDto(input, history);
      HistoryEntity finalResult = historyRepository.save(history);
      return new ResponseEntity<>(finalResult, HttpStatus.OK);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @SneakyThrows
  @Transactional
  @SuppressWarnings("null")
  public ResponseEntity<HistoryEntity> deleteHistoryItem(@NonNull UUID id) {
    Optional<HistoryEntity> result = historyRepository.findById(id);
    if (!result.isPresent()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    try {
      HistoryEntity history = result.get();
      DeleteHistoryDto input = new DeleteHistoryDto();
      input.setIsDeleted(true);
      historyMapper.deleteHistoryFromDto(input, history);
      HistoryEntity finalResult = historyRepository.save(history);
      return new ResponseEntity<>(finalResult, HttpStatus.OK);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }
}

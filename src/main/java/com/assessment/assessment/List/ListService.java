package com.assessment.assessment.List;

import com.assessment.assessment.List.dto.CreateListDto;
import com.assessment.assessment.List.dto.ListDto;
import com.assessment.assessment.List.dto.UpdateListDto;
import com.assessment.assessment.List.mapper.ListMapper;
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
public class ListService {

  @Autowired
  private ListRepository listRepository;

  @Autowired
  private ListMapper listMapper;

  @SneakyThrows
  @Transactional
  public ResponseEntity<List<ListDto>> getListItems() {
    try {
      List<ListEntity> result = listRepository.findAll();
      return new ResponseEntity<>(
        listMapper.entitiesToDtos(result),
        HttpStatus.OK
      );
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @SneakyThrows
  @Transactional
  public ResponseEntity<ListEntity> createListItem(CreateListDto input) {
    try {
      ListEntity list = new ListEntity();
      ListEntity itemsToSave = listMapper.createListFromDto(input, list);
      ListEntity result = listRepository.save(itemsToSave);
      return new ResponseEntity<>(result, HttpStatus.CREATED);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @SneakyThrows
  @Transactional
  public ResponseEntity<ListEntity> updateListItem(
    @NonNull UUID id,
    UpdateListDto input
  ) {
    Optional<ListEntity> result = listRepository.findById(id);
    if (!result.isPresent()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    try {
      ListEntity list = result.get();
      listMapper.updateListFromDto(input, list);
      ListEntity finalResult = listRepository.save(list);
      return new ResponseEntity<>(finalResult, HttpStatus.OK);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }
}

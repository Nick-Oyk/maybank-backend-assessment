package com.assessment.assessment.List;

import com.assessment.assessment.List.dto.CreateListDto;
import com.assessment.assessment.List.dto.ListDto;
import com.assessment.assessment.List.dto.UpdateListDto;
import jakarta.validation.Valid;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/list")
@EnableTransactionManagement
public class ListController {

  @Autowired
  private ListService listService;

  @GetMapping("")
  public ResponseEntity<Page<ListDto>> getListItems(
    @RequestParam(name = "page", defaultValue = "0") Integer page,
    @RequestParam(name = "perPage", defaultValue = "10") Integer perPage
  ) {
    PageRequest pageRequest = PageRequest.of(page, perPage);
    return listService.getListItems(pageRequest);
  }

  @PostMapping("")
  public ResponseEntity<ListEntity> createListItem(
    @Valid @RequestBody CreateListDto input
  ) {
    return listService.createListItem(input);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<ListEntity> updateListItem(
    @PathVariable UUID id,
    @Valid @RequestBody UpdateListDto input
  ) {
    return listService.updateListItem(id, input);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ListEntity> deleteListItem(@PathVariable UUID id) {
    return listService.deleteListItem(id);
  }
}

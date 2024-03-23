package com.assessment.assessment.List;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.assessment.List.dto.ListDto;
import com.assessment.assessment.List.dto.UpdateListDto;

import lombok.SneakyThrows;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("api/v1/list")
public class ListController {

    @Autowired
    private ListService listService;
    
    @GetMapping("")
    public ResponseEntity<List<ListDto>> getListItems() {
       return listService.getListItems();
    }

    @SneakyThrows
    @PostMapping("")
    public ResponseEntity<ListEntity> createListItem(@RequestBody ListDto input) {
        return listService.createListItem(input);
    }
   
    
    @PutMapping("/{id}")
    public ResponseEntity<ListEntity> updateListItem(@PathVariable UUID id, @RequestBody UpdateListDto input) {
        return listService.updateListItem(id, input);
    }
}
 

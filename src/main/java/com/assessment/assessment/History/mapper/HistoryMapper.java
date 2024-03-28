package com.assessment.assessment.History.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.assessment.assessment.History.HistoryEntity;
import com.assessment.assessment.History.dto.CreateHistoryDto;
import com.assessment.assessment.History.dto.DeleteHistoryDto;
import com.assessment.assessment.History.dto.HistoryDto;
import com.assessment.assessment.History.dto.UpdateHistoryDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface HistoryMapper {

    HistoryDto entityToDto(HistoryEntity historyEntity);

    HistoryEntity dtoToEntity(HistoryDto historyDto);
    
    List<HistoryDto> entitiesToDtos(List<HistoryEntity> historyEntity);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isFavourite", source = "isFavourite", defaultValue = "false")
    @Mapping(target = "isDeleted", source = "isDeleted", defaultValue = "false")
    HistoryEntity createHistoryFromDto(CreateHistoryDto createHistoryDto, @MappingTarget HistoryEntity historyEntity);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateHistoryFromDto(UpdateHistoryDto updateHistoryDto, @MappingTarget HistoryEntity historyEntity);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void deleteHistoryFromDto(DeleteHistoryDto deleteHistoryDto, @MappingTarget HistoryEntity historyEntity);

}

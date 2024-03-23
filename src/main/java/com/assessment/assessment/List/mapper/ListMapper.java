package com.assessment.assessment.List.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.assessment.assessment.List.ListEntity;
import com.assessment.assessment.List.dto.CreateListDto;
import com.assessment.assessment.List.dto.ListDto;
import com.assessment.assessment.List.dto.UpdateListDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ListMapper {

    ListDto entityToDto(ListEntity listEntity);

    ListEntity dtoToEntity(ListDto listDto);
    
    List<ListDto> entitiesToDtos(List<ListEntity> listEntity);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateListFromDto(UpdateListDto updateListDto, @MappingTarget ListEntity listEntity);


    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isCompleted", source = "isCompleted", defaultValue = "false")
    ListEntity createListFromDto(CreateListDto createListDto, @MappingTarget ListEntity listEntity);
}

package com.assessment.assessment.Country.dto;

import lombok.Data;

@Data
public class CountryDto {
    private Name name;

    @Data
    public static class Name {
        private String common;
        private String official;
    }
}
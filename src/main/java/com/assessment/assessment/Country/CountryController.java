package com.assessment.assessment.Country;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.assessment.Country.dto.CountryDto;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("api/v1/country")
@EnableTransactionManagement
public class CountryController {

    @Autowired
    CountryService countryService;


    @GetMapping("")
    public  ResponseEntity<List<CountryDto>> getCountries() {
        return countryService.getCountries();
    }
    

}
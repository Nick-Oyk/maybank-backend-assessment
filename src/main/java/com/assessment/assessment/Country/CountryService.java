package com.assessment.assessment.Country;

import com.assessment.assessment.Country.dto.CountryDto;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.SneakyThrows;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CountryService {

  //   @Autowired
  //   private CountryMapper countryMapper;

  @SneakyThrows
  @Transactional
  @SuppressWarnings("null")
  public ResponseEntity<List<CountryDto>> getCountries() {
    try {
      RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<List<CountryDto>> responseEntity = restTemplate.exchange(
        "https://restcountries.com/v3.1/all?fields=name",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<CountryDto>>() {}
      );
      List<CountryDto> response = responseEntity.getBody();

      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }
}

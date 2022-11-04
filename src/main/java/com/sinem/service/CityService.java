package com.sinem.service;

import com.sinem.dto.request.SaveRequestDto;
import com.sinem.exception.CityServiceException;
import com.sinem.exception.ErrorType;
import com.sinem.mapper.ICityMapper;
import com.sinem.repository.ICityRepository;
import com.sinem.repository.entity.City;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityService {
    private final ICityRepository cityRepository;

   public City save(SaveRequestDto dto) {
       City city = ICityMapper.INSTANCE.toCity(dto);
       if (isExistCityAndDistrict(dto.getCity(), dto.getDistrict(), dto.getRegion())) {
           city.setCity(city.getCity().toUpperCase());
          return cityRepository.save(city);
       } else {
           throw new CityServiceException(ErrorType.CITY_NOT_CREATED);
       }
   }
    public List<City> findAll() {
       return cityRepository.findAll();
    }
    public Boolean isExistCityAndDistrict(String city,String district,String region) {
    if(cityRepository.findOptionalByCityAndDistrictAndRegion(city,district,region).isPresent()) {
       return false;
    } else {
        return true;
    }
   }

   public Optional<City> findOptionalById(Long id){

        return cityRepository.findOptionalById(id);
    }
}

package com.sinem.mvc;

import com.sinem.dto.request.SaveRequestDto;
import com.sinem.exception.CityServiceException;
import com.sinem.repository.entity.City;
import com.sinem.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class CityController {
    //localhost:8095/citypage
private final CityService cityService;

    @GetMapping("/citypage")
    public ModelAndView cityEntry() {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("girissayfasi");
        return modelAndView;
    }
    @GetMapping("/citypage2")
    public ModelAndView saveCity(String error,boolean isError) {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("error", error);
        modelAndView.addObject("isError", isError);

        modelAndView.setViewName("citydistrict");
        return modelAndView;
    }

    @PostMapping("/docity")
    public ModelAndView saveCity(SaveRequestDto dto) {
        ModelAndView modelAndView=new ModelAndView();
        boolean isError = false;
        try {
        cityService.save(dto);
        isError = false;

        } catch (CityServiceException e) {
            isError = true;
            modelAndView.addObject("error",e.getMessage());
        }
        modelAndView.addObject("isError",isError);
        modelAndView.setViewName("redirect:citypage2");
        return modelAndView;
    }

    @GetMapping("/cityListPage")
    public ModelAndView cityList() {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("cities",cityService.findAll());
        modelAndView.setViewName("cityList");
        return modelAndView;
    }

}

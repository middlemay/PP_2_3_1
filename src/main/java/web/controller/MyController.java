package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.List;

@Controller
public class MyController {

    private CarService carService;

    @Autowired
    public MyController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getCars(ModelMap model, @RequestParam(value = "count", defaultValue = "5") int count) {
        model.addAttribute("cars", carService.getCarsList(count));
        return "cars";
    }
}

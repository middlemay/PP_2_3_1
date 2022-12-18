package web.service;
import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImpl implements CarService {
    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("BMW", 666, "Ivan P."));
        cars.add(new Car("Infinity", 1004, "Ksenia C."));
        cars.add(new Car("Lada", 2104, "Petr Ivanov"));
        cars.add(new Car("Volvo", 56, "Konstantin F"));
        cars.add(new Car("Reno", 78, "Anna D."));
    }

    @Override
    public List<Car> getCarsList(int count) {
        return cars.stream().limit(count).collect(Collectors.toCollection(ArrayList::new));
    }
}

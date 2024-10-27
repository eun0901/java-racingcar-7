package racingcar.domain;

import static racingcar.service.ValidationService.validateCarNameDuplicate;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        validateCarNameDuplicate(carNames);

        this.cars = carNames.stream()
                .map(Car::new)
                .toList();
    }

    public Integer size() {
        return cars.size();
    }

    public void carMove(int index) {
        Car car = cars.get(index);
        car.move();
    }

    public boolean checkCarMove(int index, int carMoveCount) {
        Car car = cars.get(index);
        return car.compareCarGoCnt(carMoveCount);
    }
}

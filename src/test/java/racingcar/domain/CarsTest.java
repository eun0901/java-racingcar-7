package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.TestConstants.CAR_MOVE_COUNT;
import static racingcar.TestConstants.CAR_NAME_JUN;
import static racingcar.TestConstants.CAR_NAME_POBI;
import static racingcar.TestConstants.CAR_NAME_WONI;
import static racingcar.TestConstants.MOVED_CAR_INDEX;
import static racingcar.TestConstants.START_LOCATION;
import static racingcar.TestConstants.STOP_CAR_INDEX;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    @DisplayName("자동차 이름들을 넣을 경우 자동차들이 잘 생성된다.")
    void createCars () {
        // given
        List<String> carNames = new ArrayList<>();
        carNames.add(CAR_NAME_POBI);
        carNames.add(CAR_NAME_WONI);
        carNames.add(CAR_NAME_JUN);

        // when
        Cars cars = new Cars(carNames);

        // then
        assertThat(cars.size()).isEqualTo(carNames.size());
    }

    @Test
    @DisplayName("움직이도록 요청한 차가 잘 움직인다.")
    void moveCar () {
        // given
        List<String> carNames = new ArrayList<>();
        carNames.add(CAR_NAME_POBI);
        carNames.add(CAR_NAME_WONI);
        carNames.add(CAR_NAME_JUN);

        Cars cars = new Cars(carNames);

        // when
        cars.carMove(MOVED_CAR_INDEX);

        // then
        assertThat(cars.checkCarMove(MOVED_CAR_INDEX, CAR_MOVE_COUNT)).isTrue();
    }

    @Test
    @DisplayName("움직이도록 요청하지 않은 차는 움직이지 않는다.")
    void dontMoveCar () {
        // given
        List<String> carNames = new ArrayList<>();
        carNames.add(CAR_NAME_POBI);
        carNames.add(CAR_NAME_WONI);
        carNames.add(CAR_NAME_JUN);

        Cars cars = new Cars(carNames);

        // when
        cars.carMove(MOVED_CAR_INDEX);

        // then
        assertThat(cars.checkCarMove(STOP_CAR_INDEX, START_LOCATION)).isTrue();
    }
}
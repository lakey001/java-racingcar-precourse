package racingcar.utils;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

public class ValidationUtilsTest {
    @Test
    void 차_이름_검증(){
        assertThat(ValidationUtils.validateCarNamesInput("car1,car2")).isTrue();
        assertThat(ValidationUtils.validateCarNamesInput("car1,car234")).isFalse();
        assertThat(ValidationUtils.validateCarNamesInput("car,,car2")).isFalse();
    }

}

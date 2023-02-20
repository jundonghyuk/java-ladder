package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderPropertyTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1001, 10000})
    @DisplayName("높이가 1 미만이거나 1000 초과이면 예외를 던진다.")
    void heightRangeTest(int height) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () ->  new LadderSize(3, height));
    }

}

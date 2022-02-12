package stringcalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperationTest {

    @Test
    @DisplayName("더하기 테스트")
    void testPlus() {
        int result = Operation.PLUS.operate(4, 5);
        assertThat(result).isEqualTo(9);
    }
}

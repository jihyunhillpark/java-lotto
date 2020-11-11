import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionTest {

    String sentence;

    @BeforeEach
    void setUp() {
        sentence = "1,2";
    }

    @Test
    @DisplayName(",를 기준으로 sentence를 숫자로 나누기")
    void createExpression() {
        Expression expression = new Expression(sentence, new Splitters());

        Numbers expected = new Numbers(Arrays.asList(new Number(1), new Number(2)));
        assertThat(expression.getNumbers()).isEqualTo(expected);
    }

    @Test
    @DisplayName("sum 구하기")
    void sum() {
        Expression expression = new Expression(sentence, new Splitters());

        Number sum = expression.sum();

        assertThat(sum).isEqualTo(new Number(3));
    }
}
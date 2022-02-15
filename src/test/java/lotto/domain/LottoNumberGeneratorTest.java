package lotto.domain;

import static lotto.util.Constant.LOTTO_SIZE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

    @Test
    void 로또숫자들은_1부터45까지의_중복되지_않은_6개의_수들이다() {
        List<LottoNumber> lottoNumbers = LottoNumberGenerator.generateRandomLottoNumber();
        long given = lottoNumbers.stream().distinct().count();
        assertThat(given).isEqualTo(LOTTO_SIZE);
    }
}

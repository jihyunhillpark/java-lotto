package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoStatistic;
import lotto.domain.RandomNumberStrategy;
import lotto.domain.WinningNumbers;
import lotto.util.InputSpliter;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {

    public static void main(String[] args) {
        int userMoney = InputView.getUserMoney();
        RandomNumberStrategy randomGenerateStrategy = new RandomNumberStrategy();
        Lotto lotto = new Lotto(userMoney, randomGenerateStrategy);
        ResultView.printBuyingInformation(lotto.getLottoTickets());

        String winnings = InputView.getWinningNumbers();
        int bonusBall = InputView.getBonusBall();
        List<Integer> pickedNumbers = InputSpliter.split(winnings);
        WinningNumbers winningNumbers = new WinningNumbers(pickedNumbers, bonusBall);

        LottoResult lottoResult = new LottoResult(lotto.getLottoTickets(), winningNumbers);
        LottoStatistic lottoStatistic = LottoStatistic.createLottoStatistic(lottoResult);
        ResultView.printStatistic(lottoStatistic, lottoStatistic.getProfit(userMoney));

    }
}

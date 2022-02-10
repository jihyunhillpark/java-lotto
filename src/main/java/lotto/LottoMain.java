package lotto;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoStatistic;
import lotto.domain.WinningNumbers;
import lotto.util.InputSpliter;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {

    public static void main(String[] args) {
        int userMoney = InputView.getUserMoney();
        Lotto lotto = new Lotto(userMoney);
        ResultView.printNumOfLottoTickets(lotto.getNumOfTickets());

        String winnings = InputView.getWinningNumbers();
        int bonusBall = InputView.getBonusBall();
        List<Integer> pickedNumbers = InputSpliter.split(winnings);
        WinningNumbers winningNumbers = new WinningNumbers(pickedNumbers, bonusBall);

        LottoStatistic lottoResult = lotto.getWinningResult(winningNumbers);
        ResultView.printStatistic(lottoResult);
        ResultView.printProfit(lottoResult.getProfit(userMoney));

    }
}

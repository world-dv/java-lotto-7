package lotto;

import lotto.controller.BonusController;
import lotto.controller.LottoController;
import lotto.controller.PaymentController;
import lotto.controller.ResultController;
import lotto.controller.WinningController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();

        PaymentController paymentController = new PaymentController(inputView, outputView);

        LottoController lottoController = new LottoController(outputView, paymentController.getPayment());
        lottoController.showTicket();

        WinningController winningController = new WinningController(inputView, outputView);
        BonusController bonusController = new BonusController(inputView, outputView,
                winningController.getWinningGenerator().getWinning());

        ResultController resultController = new ResultController(outputView, lottoController.getLottoTicket(), paymentController.getPayment());
        resultController.showWinning(
                winningController.getWinningGenerator().getWinning(),
                bonusController.getBonusGenerator().getBonus());
    }
}

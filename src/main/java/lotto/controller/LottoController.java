package lotto.controller;

import lotto.Checking;
import lotto.domain.*;
import lotto.view.InPut;
import lotto.view.OutPut;

import java.util.List;

public class LottoController {

    Money money = new Money();

    InPut input = new InPut();
    OutPut outPut = new OutPut();
    WinningLotto winningLotto;

    Result result = new Result();

    List<Integer> lotto;
    List<Lotto> lottoList;

    Checking checking = new Checking();
    Lottos lottos = new Lottos();
    public void Start(){
        try {
            int price = input.inputPurchaseAmount();

            int count = money.returnCount(price);
            lottoList = lottos.makeLottos(count);

            lotto = input.inputWinNumber();
            int bonus = input.inputBonus();

            winningLotto = new WinningLotto(lotto,bonus);
            checking.compareLottos(lottoList, winningLotto);
            printResult(result, count);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    public void printResult(Result result, int count){
        outPut.printRank(result);
        outPut.printReturnRate(result,count);
    }
}
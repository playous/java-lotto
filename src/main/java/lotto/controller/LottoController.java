package lotto.controller;

import lotto.Checking;
import lotto.domain.*;
import lotto.view.InPut;
import lotto.view.OutPut;

import java.util.List;

public class LottoController {

    Money money = new Money();

    InPut input = new InPut();
    WinningLotto winningLotto;

    Result result = new Result();
    List<Lotto> lottoList;

    Checking checking = new Checking();
    Lottos lottos = new Lottos();
    private int count;

    public void Start(){
        try {
            count = money.returnCount(input.inputPurchaseAmount());
            lottoList = lottos.makeLottos(count);
            winningLotto = new WinningLotto(input.inputWinNumber(),input.inputBonus());
            checking.compareLottos(lottoList, winningLotto);
            printResult(result);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    public void printResult(Result result){
        OutPut.printRank(result);
        OutPut.printReturnRate((double)result.getWinningAmount()/(count*1000)*100);
    }

}
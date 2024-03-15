package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Checking;
import lotto.domain.*;
import lotto.view.InPut;
import lotto.view.OutPut;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    static Money money = new Money();
    static OutPut outPut = new OutPut();
    static InPut inPut = new InPut();

    private static WinningLotto winningLotto = new WinningLotto();
    Lotto lotto;
    Lotto winlotto;
    Result result = new Result();
    private static List<Lotto> lottoList;

    private static Checking checking = new Checking();
    private static Lottos lottos = new Lottos();

    int count;
    public void Start(){
        count = money.inputMoney();
        lottoList = lottos.makeLottos(count);
        winningLotto.MakeWinningLotto();
        checking.compareLottos(lottoList,winningLotto);
        printResult(result,count);
    }

    public void UpdateResult(int count){
        result.addRank(count);
    }

    public void printResult(Result result, int count){
        outPut.printRank(result);
        outPut.printReturnRate(result,count);
    }
}
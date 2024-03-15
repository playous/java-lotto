package lotto.domain;

import lotto.view.InPut;
import lotto.view.OutPut;

public class Money {
    InPut input = new InPut();
    private static int money;
    private static int count;
    public int inputMoney(){
        money = input.inputPurchaseAmount();
        count = money / 1000;
        OutPut.printTicketCount(count);
        return count;
    }
    public int getCount(){
        money = input.inputPurchaseAmount();
        count = money / 1000;
        // 예외 처리
        return count;
    }
}

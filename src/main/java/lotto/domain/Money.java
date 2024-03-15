package lotto.domain;

import lotto.view.OutPut;

public class Money {
    private int money;
    private int count;
    public int returnCount(int money){
        validateMoney(money);
        this.money = money;
        count = getCount();
        OutPut.printTicketCount(count);
        return count;
    }
    private void validateMoney(int money) {
        if (money <= 0 || money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로만 받을 수 있습니다.");
        }
    }
    public int getCount(){
        return money/1000;
    }

    public int getMoney(){
        return this.money;
    }
}

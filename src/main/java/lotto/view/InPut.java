package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InPut {
    public int inputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public String inputWinNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }
    public int inputBonus(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}

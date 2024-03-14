package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InPut {
    public static List<Integer> WinNumber;

    public static String inputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static List<Integer> inputWinNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return makeList(Console.readLine());
    }

    public static List<Integer> makeList(String lotto){
        List<Integer> lottoNumbers = new ArrayList<>();
        String[] tokens = lotto.split(",");
        for (String token : tokens) {
            int num = Integer.parseInt(token.trim());
            lottoNumbers.add(num);
        }
        return lottoNumbers;
    }
}

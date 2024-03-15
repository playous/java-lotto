package lotto.domain;

import lotto.view.InPut;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    InPut input = new InPut();
    private Lotto winningnumbers;
    private int bonus;

    public List<Integer> getWinningnumbers(){
        return winningnumbers.getNumbers();
    }

    public int getBonus(){
        return bonus;
    }
    public void MakeWinningLotto(){
        String lotto1 = input.inputWinNumber();
        winningnumbers = new Lotto(makeList(lotto1));
        bonus = input.inputBonus();
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

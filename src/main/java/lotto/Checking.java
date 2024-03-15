package lotto;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.WinningLotto;

import java.util.List;

public class Checking {
    Result result = new Result();
    public void compareLottos(List<Lotto> lottos, WinningLotto winningLotto){
        int hitNumber;
        for (int i = 0 ; i < lottos.size(); i++){
            hitNumber = compareLotto(lottos.get(i),winningLotto);
            UpdateResult(hitNumber);
        }
    }

    public int compareLotto(Lotto lotto, WinningLotto winningLotto){
        int count = (int) lotto.getNumbers().stream()
                .filter(winningLotto.getWinningnumbers()::contains)
                .count();
        boolean checkBonus = lotto.getNumbers().stream().anyMatch(number -> number == winningLotto.getBonus());
        if(count == 5 && checkBonus) return 7;
        else return count;
    }

    public void UpdateResult(int count){
        result.addRank(count);
    }

}

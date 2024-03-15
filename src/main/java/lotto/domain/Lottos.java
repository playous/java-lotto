package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.OutPut;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottoList;
    Lotto lotto;

    public Lotto MakeLotto(){
        List<Integer> lotto1 = Randoms.pickUniqueNumbersInRange(1,45,6);
        lotto = new Lotto(lotto1);
        return lotto;
    }
    public List<Lotto> makeLottos(int count){
        lottoList = new ArrayList<>();
        for (int i = 0 ; i < count ; i ++){
            lottoList.add(MakeLotto());
        }
        OutPut.printLottos(lottoList);
        return lottoList;
    }
}

package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.OutPut;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private static List<Lotto> lottoList;
    static Lotto lotto;

    public Lotto MakeLotto(int start, int end, int count){
        List<Integer> lotto1 = Randoms.pickUniqueNumbersInRange(start,end,count);
        lotto = new Lotto(lotto1);
        return lotto;
    }
    public List<Lotto> makeLottos(int count){
        lottoList = new ArrayList<>();
        for (int i = 0 ; i < count ; i ++){
            lottoList.add(MakeLotto(1,45,6));
        }
        OutPut.printLottos(lottoList);
        return getLottos();
    }
    public List<Lotto> getLottos(){
        return lottoList;
    }
}

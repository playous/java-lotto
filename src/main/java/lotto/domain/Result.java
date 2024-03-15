package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private static Map<String, Integer> rank = new HashMap<>();

    private static int winningAmount;
    public Result(){
        winningAmount = 0;
        rank.put("3개",0);
        rank.put("4개",0);
        rank.put("5개",0);
        rank.put("5개+보너스",0);
        rank.put("6개",0);
    }
    public void addRank(int cnt){
        if(cnt == 3) {
            rank.put("3개",rank.get("3개")+1);
            winningAmount += 5000;
        }
        if(cnt == 4) {
            rank.put("4개",rank.get("4개")+1);
            winningAmount += 50000;
        }
        if(cnt == 5) {
            rank.put("5개",rank.get("5개")+1);
            winningAmount += 1500000;
        }
        if(cnt == 6) {
            rank.put("6개",rank.get("6개")+1);
            winningAmount += 2000000000;
        }
        if(cnt == 7) {
            rank.put("5개+보너스",rank.get("5개+보너스")+1);
            winningAmount += 30000000;
        }
    }
    public Map<String,Integer> getRank(){
        return rank;
    }
    public int getWinningAmount(){
        return winningAmount;
    }

}

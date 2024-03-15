package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutPut {

    private static Map<String,Integer> ranking;
    public  static void printTicketCount(int count){
        System.out.println("\n"+count+"개를 구입했습니다.");
    }
    public static void printLottos(List<Lotto> lottoList){
        for (Lotto lotto : lottoList){
            System.out.println(lotto);
        }
    }

    public static void printRank(Result result){
        ranking = result.getRank();
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println(String.format("3개 일치 (5000원) - %d개",ranking.get("3개")));
        System.out.println(String.format("4개 일치 (50000원) - %d개",ranking.get("4개")));
        System.out.println(String.format("5개 일치 (1500000원) - %d개",ranking.get("5개")));
        System.out.println(String.format("5개 일치, 보너스 볼 일치 (30000000원) - %d개",ranking.get("5개+보너스")));
        System.out.println(String.format("6개 일치 (2000000000원) - %d개",ranking.get("6개")));
    }

    public static void printReturnRate(Result result, int count){
        System.out.println(String.format("총 수익률은 %.1f%%입니다.",(double)result.getWinningAmount()/(count*10)));
    }
}

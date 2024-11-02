package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.strategy.FifthPlace;
import lotto.strategy.FirstPlace;
import lotto.strategy.FourthPlace;
import lotto.strategy.PlaceAuction;
import lotto.strategy.SecondPlace;

public class ResultCalculator {

    private final Map<Integer, Integer> placeMap = new HashMap<>();
    private final Map<Integer, PlaceAuction> placeAuctionMap = new HashMap<>();

    public ResultCalculator(List<Integer> winningResult, List<Integer> bonusResult) {
        init(bonusResult);
        calculate(winningResult, bonusResult);
    }

    private void init(List<Integer> bonusResult) {
        for (int place = 1; place <= 5; place++) {
            placeMap.put(place, 0);
        }
        placeAuctionMap.put(6, new FirstPlace(placeMap));
        placeAuctionMap.put(5, new SecondPlace(placeMap, bonusResult));
        placeAuctionMap.put(4, new FourthPlace(placeMap));
        placeAuctionMap.put(3, new FifthPlace(placeMap));
    }

    private void calculate(List<Integer> winningResult, List<Integer> bonusResult) {
        int totalCount = winningResult.size();
        for (int count = 0; count < totalCount; count++) {
            int winning = winningResult.get(count);
            update(winning, count);
        }
    }

    private void update(Integer winning, Integer count) {
        if (placeAuctionMap.containsKey(winning)) {
            PlaceAuction placeAuction = placeAuctionMap.get(winning);
            placeAuction.add(count);
        }
    }
}

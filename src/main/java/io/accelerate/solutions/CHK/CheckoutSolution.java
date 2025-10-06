package io.accelerate.solutions.CHK;

import io.accelerate.solutions.CHK.offers.FreeItemOffer;
import io.accelerate.solutions.CHK.offers.Offer;
import io.accelerate.solutions.CHK.offers.PercentageOffer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        final boolean containsValidSkus = skus.matches("[ABCDEF]*");

        if(!containsValidSkus)  {
            return -1;
        }

        final HashMap<Character, Integer> checkOutMap = getSkuMap(skus);

        final HashMap<Character, Offer> freeItemsToApply = new HashMap<>();

        char currentItem = 'E';
        char currentFreeItem = 'B';
        freeItemsToApply.put(currentItem, new FreeItemOffer(currentItem, 2, currentFreeItem, 1));
        currentItem = 'F';
        currentFreeItem = 'F';
        freeItemsToApply.put(currentItem, new FreeItemOffer(currentItem, 3, currentFreeItem, 1));
        currentItem = 'N';
        currentFreeItem = 'M';
        freeItemsToApply.put(currentItem, new FreeItemOffer(currentItem, 3, currentFreeItem, 1));
        currentItem = 'R';
        currentFreeItem = 'Q';
        freeItemsToApply.put(currentItem, new FreeItemOffer(currentItem, 3, currentFreeItem, 1));
        currentItem = 'U';
        currentFreeItem = 'U';
        freeItemsToApply.put(currentItem, new FreeItemOffer(currentItem, 3, currentFreeItem, 1));

        final HashMap<Character, List<Offer>> offersToApply = new HashMap<>();

        currentItem = 'A';
        offersToApply.put(currentItem, List.of(
                new PercentageOffer(currentItem, 5, 200),
                new PercentageOffer(currentItem, 3, 130),
                new PercentageOffer(currentItem, 1, 50)
        ));
        currentItem = 'B';
        offersToApply.put(currentItem, List.of(
                new PercentageOffer(currentItem, 2, 45),
                new PercentageOffer(currentItem, 1, 30)
        ));
        currentItem = 'C';
        offersToApply.put(currentItem, List.of(
                new PercentageOffer(currentItem, 1, 20)
        ));
        currentItem = 'D';
        offersToApply.put(currentItem, List.of(
                new PercentageOffer(currentItem, 1, 15)
        ));
        currentItem = 'E';
        offersToApply.put(currentItem, List.of(
                new PercentageOffer(currentItem, 1, 40)
        ));
        currentItem = 'F';
        offersToApply.put(currentItem, List.of(
                new PercentageOffer(currentItem, 1, 10)
        ));
        currentItem = 'G';
        offersToApply.put(currentItem, List.of(
                new PercentageOffer(currentItem, 1, 20)
        ));
        currentItem = 'H';
        offersToApply.put(currentItem, List.of(
                new PercentageOffer(currentItem, 10, 80),
                new PercentageOffer(currentItem, 5, 45),
                new PercentageOffer(currentItem, 1, 10)
        ));
        currentItem = 'I';
        offersToApply.put(currentItem, List.of(
                new PercentageOffer(currentItem, 1, 35)
        ));
        currentItem = 'J';
        offersToApply.put(currentItem, List.of(
                new PercentageOffer(currentItem, 1, 60)
        ));
        currentItem = 'K';
        offersToApply.put(currentItem, List.of(
                new PercentageOffer(currentItem, 2, 150),
                new PercentageOffer(currentItem, 1, 80)
        ));
        currentItem = 'L';
        offersToApply.put(currentItem, List.of(
                new PercentageOffer(currentItem, 1, 90)
        ));
        currentItem = 'M';
        offersToApply.put(currentItem, List.of(
                new PercentageOffer(currentItem, 1, 15)
        ));
        currentItem = 'N';
        offersToApply.put(currentItem, List.of(
                new PercentageOffer(currentItem, 1, 40)
        ));
        currentItem = 'O';
        offersToApply.put(currentItem, List.of(
                new PercentageOffer(currentItem, 1, 10)
        ));
        currentItem = 'P';
        offersToApply.put(currentItem, List.of(
                new PercentageOffer(currentItem, 5, 200),
                new PercentageOffer(currentItem, 1, 10)
        ));
        currentItem = 'Q';
        offersToApply.put(currentItem, List.of(
                new PercentageOffer(currentItem, 3, 80),
                new PercentageOffer(currentItem, 1, 30)
        ));


        this.computeFreeItems(checkOutMap);

        return this.computeFinalValue(checkOutMap);
    }

    private static HashMap<Character, Integer> getSkuMap(String skus) {
        final HashMap<Character, Integer> checkOutMap = new HashMap<>();

        for (char currentSku : skus.toCharArray()) {
            if (checkOutMap.containsKey(currentSku)) {
                 checkOutMap.put(currentSku, checkOutMap.get(currentSku) + 1);
                 continue;
            }
            checkOutMap.put(currentSku, 1);
        };

        return checkOutMap;
    }

    private static HashMap<Character, Integer> computeFreeItems(HashMap<Character, Integer> checkOutMap) {
        int amountOfFreeBs = checkOutMap.getOrDefault('E',0) / 2;

        if (amountOfFreeBs > 0 && checkOutMap.containsKey('B')) {
            checkOutMap.put('B', checkOutMap.getOrDefault('B',0) - amountOfFreeBs);
        }

        int amountOfFreeFs = checkOutMap.getOrDefault('F',0) / 3;

        if (amountOfFreeFs > 0 && checkOutMap.containsKey('F')) {
            checkOutMap.put('F', checkOutMap.getOrDefault('F',0) - amountOfFreeFs);
        }

        return checkOutMap;
    }

    private static int computeFinalValue(HashMap<Character, Integer> checkOutMap) {
        int checkOutValue = 0;

        for (Map.Entry<Character, Integer> currentSkus: checkOutMap.entrySet()) {
            switch (currentSkus.getKey()) {
                case 'A':
                    checkOutValue = checkOutValue + ((currentSkus.getValue() / 5) * 200);
                    checkOutValue = checkOutValue + ((currentSkus.getValue() % 5) / 3 * 130);
                    checkOutValue = checkOutValue + ((currentSkus.getValue() % 5) % 3 * 50);
                    break;
                case 'B':
                    checkOutValue = checkOutValue + ((currentSkus.getValue() / 2) * 45) + (currentSkus.getValue() % 2 * 30);
                    break;
                case 'C':
                    checkOutValue = checkOutValue + (20 * currentSkus.getValue());
                    break;
                case 'D':
                    checkOutValue = checkOutValue + (15 * currentSkus.getValue());
                    break;
                case 'E':
                    checkOutValue = checkOutValue + (40 * currentSkus.getValue());
                    break;
                case 'F':
                    checkOutValue = checkOutValue + (10 * currentSkus.getValue());
                    break;
            }
        }
        return checkOutValue;
    }
}




package io.accelerate.solutions.CHK;

import io.accelerate.solutions.CHK.offers.FreeItemOffer;
import io.accelerate.solutions.CHK.offers.Offer;
import io.accelerate.solutions.CHK.offers.PercentageOffer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        final boolean containsValidSkus = skus.matches("[ABCDEFGHIJKLMNOPQRSTUVWXYZ]*");

        if(!containsValidSkus)  {
            return -1;
        }

        final HashMap<Character, Integer> checkOutMap = getSkuMap(skus);

        final HashMap<Character, Offer> freeItemsToApply = populateFreeOffers();

        final HashMap<Character, List<Offer>> offersToApply = populatePercentageBasedOffers();

        this.computeFreeItems(checkOutMap,freeItemsToApply);

        return this.computeFinalValue(checkOutMap, offersToApply);
    }

    private static HashMap<Character, Offer> populateFreeOffers() {
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
        freeItemsToApply.put(currentItem, new FreeItemOffer(currentItem, 4, currentFreeItem, 1));

        return freeItemsToApply;
    }

    private static HashMap<Character, List<Offer>> populatePercentageBasedOffers() {
        char currentItem;
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
                new PercentageOffer(currentItem, 1, 50)
        ));
        currentItem = 'Q';
        offersToApply.put(currentItem, List.of(
                new PercentageOffer(currentItem, 3, 80),
                new PercentageOffer(currentItem, 1, 30)
        ));
        currentItem = 'R';
        offersToApply.put(currentItem, List.of(
                new PercentageOffer(currentItem, 1, 50)
        ));
        currentItem = 'S';
        offersToApply.put(currentItem, List.of(
                new PercentageOffer(currentItem, 1, 30)
        ));
        currentItem = 'T';
        offersToApply.put(currentItem, List.of(
                new PercentageOffer(currentItem, 1, 20)
        ));
        currentItem = 'U';
        offersToApply.put(currentItem, List.of(
                new PercentageOffer(currentItem, 1, 40)
        ));
        currentItem = 'V';
        offersToApply.put(currentItem, List.of(
                new PercentageOffer(currentItem, 3, 130),
                new PercentageOffer(currentItem, 2, 90),
                new PercentageOffer(currentItem, 1, 50)
        ));
        currentItem = 'W';
        offersToApply.put(currentItem, List.of(
                new PercentageOffer(currentItem, 1, 20)
        ));
        currentItem = 'X';
        offersToApply.put(currentItem, List.of(
                new PercentageOffer(currentItem, 1, 90)
        ));
        currentItem = 'Y';
        offersToApply.put(currentItem, List.of(
                new PercentageOffer(currentItem, 1, 10)
        ));
        currentItem = 'Z';
        offersToApply.put(currentItem, List.of(
                new PercentageOffer(currentItem, 1, 50)
        ));
        return offersToApply;
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

    private static HashMap<Character, Integer> computeFreeItems(HashMap<Character, Integer> checkOutMap, HashMap<Character, Offer> offers) {

        for (Offer freeItem : offers.values()){
            freeItem.apply(checkOutMap);
        }

        return checkOutMap;
    }

    private static int computeFinalValue(HashMap<Character, Integer> checkOutMap, HashMap<Character, List<Offer>> percentageBasedOffers) {
        int totalAmount = 0;

        for (Map.Entry<Character, Integer> currentSkus : checkOutMap.entrySet()) {

            if(percentageBasedOffers.containsKey(currentSkus.getKey())) {
                for (Offer offer: percentageBasedOffers.get(currentSkus.getKey())) {
                    totalAmount += offer.apply(checkOutMap);
                }
            }
        }
        return totalAmount;
    }
}

package io.accelerate.solutions.CHK.offers;

import java.util.Map;

public class PercentageOffer implements Offer{

    private final char sku;

    private final int minQuantity;

    private final int finalOfferPrice;

    public PercentageOffer(char sku, int minQuantity, int finalOfferPrice) {
        this.sku = sku;
        this.minQuantity = minQuantity;
        this.finalOfferPrice = finalOfferPrice;
    }

    @Override
    public int apply(Map<Character, Integer> offers) {

        int count = offers.getOrDefault(sku, 0);

        if (minQuantity > count) {
            return 0;
        }

        int numberOfOfferToApply = count / minQuantity;
        int remainingItems = count / minQuantity;

        offers.put(sku, remainingItems);

        return numberOfOfferToApply * finalOfferPrice;
    }
}


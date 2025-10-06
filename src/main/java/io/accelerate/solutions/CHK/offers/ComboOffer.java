package io.accelerate.solutions.CHK.offers;

import java.util.Map;

public class ComboOffer implements Offer{

    private final int size;

    private final String elegibleSkus;

    private final int finalOfferPrice;

    public ComboOffer(char sku, int minQuantity, int finalOfferPrice) {
        this.sku = sku;
        this.minQuantity = minQuantity;
        this.finalOfferPrice = finalOfferPrice;
    }

    @Override
    public int apply(Map<Character, Integer> items) {

        int count = items.getOrDefault(sku, 0);

        if (minQuantity > count) {
            return 0;
        }

        int numberOfOfferToApply = count / minQuantity;
        int remainingItems = count % minQuantity;

        items.put(sku, remainingItems);

        return numberOfOfferToApply * finalOfferPrice;
    }
}

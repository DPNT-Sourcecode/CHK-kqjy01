package io.accelerate.solutions.CHK.offers;

import java.util.Map;

public class FreeItemOffer implements Offer {

    private final char mainSku;

    private final int minQuantity;

    private final char freeSku;


    private final int freeQuantity;

    public FreeItemOffer(char mainSku, int minQuantity, char freeSku, int freeQuantity) {
        this.mainSku = mainSku;
        this.minQuantity = minQuantity;
        this.freeSku = freeSku;
        this.freeQuantity = freeQuantity;
    }

    @Override
    public int apply(Map<Character, Integer> items) {

        int mainCount = items.getOrDefault(mainSku, 0);

        if (minQuantity > mainCount) {
            return 0;
        }

        int freeItemCount = (mainCount / minQuantity) * freeQuantity;
        int currentFreeItemCount = items.getOrDefault(freeSku, 0);
        items.put(freeSku,currentFreeItemCount - freeItemCount );
        return 0;

    }


}

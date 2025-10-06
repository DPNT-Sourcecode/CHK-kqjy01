package io.accelerate.solutions.CHK.offers;

import java.util.Map;

public class ComboOffer implements Offer{

    private final int size;

    private final String elegibleSkus;

    private final int comboPrice;

    public ComboOffer(int size, String elegibleSkus, int comboPrice) {
        this.size = size;
        this.elegibleSkus = elegibleSkus;
        this.comboPrice = comboPrice;
    }

    @Override
    public int apply(Map<Character, Integer> items) {
        int totalElegibleItems

        for (char sku : elegibleSkus.toCharArray()){

        }
    }
}


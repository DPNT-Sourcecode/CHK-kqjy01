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

        int totalElegibleItems = 0;

        for (char sku : elegibleSkus.toCharArray()){
            totalElegibleItems += items.getOrDefault(sku, 0);
        }

        int comboCount = totalElegibleItems / size;

        if (comboCount == 0) {
            return 0;
        }

        int totalComboValue = comboCount * comboPrice;
        int itemsToRemove = comboCount * size;

        for (char sku : elegibleSkus.toCharArray()) {
            if (itemsToRemove == 0){
                return totalComboValue;
            }

            int currentItemCount = items.getOrDefault(sku, 0);

            if (currentItemCount == 0){
                continue;
            }

            int remove = Math.min(currentItemCount, itemsToRemove);
            items.put(sku, currentItemCount - remove);
            itemsToRemove -= remove;
        }
        return totalComboValue;
    }
}

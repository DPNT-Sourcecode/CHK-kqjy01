package io.accelerate.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        final boolean containsValidSkus = skus.matches("[ABCDEF]*");

        if(!containsValidSkus)  {
            return -1;
        }

        final HashMap<Character, Integer> checkOutMap = getSkuMap(skus);

        final HashMap<Character, Integer> freeItemsToApply = new HashMap<>();


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


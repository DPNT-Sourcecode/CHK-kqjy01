package io.accelerate.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        final boolean containsValidSkus = skus.matches("[ABCDE]*");

        if(!containsValidSkus)  {
            return -1;
        }

        final HashMap<Character, Integer> checkOutMap = getSkuMap(skus); ;

        int checkOutValue = 0;

        for (Map.Entry<Character, Integer> currentSkus: checkOutMap.entrySet()) {
            checkOutValue = computValue(currentSkus, checkOutValue);
        }

        return checkOutValue;
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

    private static int computValue(Map.Entry<Character, Integer> currentSkus, int checkOutValue) {
        switch (currentSkus.getKey()){
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
                checkOutValue = checkOutValue + ((currentSkus.getValue() / 3) * 80);
                checkOutValue = checkOutValue +  ((currentSkus.getValue() % 3) * 40);
                break;
        }
        return checkOutValue;
    }
}


package io.accelerate.solutions.CHK;

import io.accelerate.runner.SolutionNotImplementedException;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        final boolean containsValidSkus = skus.matches("[ABCD]*");

        if(!containsValidSkus)  {
            return -1;
        }

        final HashMap<Character, Integer> checkOutMap = new HashMap<>();

        for (char currentSku :skus.toCharArray()) {
            if (checkOutMap.containsKey(currentSku)) {
                 checkOutMap.put(currentSku, checkOutMap.get(currentSku) + 1);
                 continue;
            }

            checkOutMap.put(currentSku, 1);
        };

        int checkOutValue = 0;

        for (Map.Entry<Character, Integer> currentSkus: checkOutMap.entrySet()) {
            switch (currentSkus.getKey()){
                case 'A':
                    break;
                case 'B':

                    if (currentSkus.getValue() / 2){

                    }

                    checkOutValue = checkOutValue + (currentSkus.getValue() / 2) *  (currentSkus.getValue() % 2 + (30 * currentSkus.getValue());

                    break;
                case 'C':
                    checkOutValue = checkOutValue + (20 * currentSkus.getValue());
                    break;
                case 'D':
                    checkOutValue = checkOutValue + (15 * currentSkus.getValue());
                    break;

            }
        }

        return null;
    }
}



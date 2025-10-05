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

        for (Map.Entry<Character, Integer> currentSkus: checkOutMap.entrySet()) {
            if (){

            }
        }

        return null;
    }
}





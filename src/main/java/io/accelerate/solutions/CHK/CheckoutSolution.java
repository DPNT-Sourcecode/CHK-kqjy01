package io.accelerate.solutions.CHK;

import io.accelerate.runner.SolutionNotImplementedException;

public class CheckoutSolution {
    public Integer checkout(String skus) {


        boolean containsValidSkus = skus.matches("[ABCD]*");

        if(!containsValidSkus)  {
            return -1;
        }

        skus.toCharArray();


    }
}




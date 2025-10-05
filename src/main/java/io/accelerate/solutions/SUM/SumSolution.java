package io.accelerate.solutions.SUM;

import io.accelerate.runner.SolutionNotImplementedException;

@SuppressWarnings("unused")
public class SumSolution {

    public int compute(int x, int y) {

        if (x < 0 ) {
            throw new SolutionNotImplementedException();
        }

        return x + y;
    }

}



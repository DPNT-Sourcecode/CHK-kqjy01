package io.accelerate.solutions.HLO;

import io.accelerate.runner.SolutionNotImplementedException;

public class HelloSolution {
    public String hello(String friendName) {
        final StringBuilder helloWorld = new StringBuilder();
        helloWorld.append("Hello, World!");
        return helloWorld.toString();
    }
}

package io.accelerate.solutions.HLO;

import io.accelerate.runner.SolutionNotImplementedException;

public class HelloSolution {
    public String hello(String friendName) {

        final StringBuilder helloWorld = new StringBuilder();

        if (friendName == null || friendName.isEmpty()) {
            helloWorld.append("Hello, World!");
            return helloWorld.toString();
        }

        helloWorld.append("Hello, ");
        helloWorld.append(friendName);
        helloWorld.append("!");

        return helloWorld.toString();
    }
}


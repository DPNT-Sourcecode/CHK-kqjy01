package io.accelerate.runner;

public class OutOfBoundsException extends RuntimeException {
    public OutOfBoundsException() {
        super("Value is out of bounds");
    }

}


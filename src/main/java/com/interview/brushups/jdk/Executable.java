package com.interview.brushups.jdk;

/**
 * Functional Interface is used, so that the interface do not add more methods by accident.
 * If we add up more methods, it will give compilation error.
 */
@FunctionalInterface
public interface Executable {
    void execute();
}

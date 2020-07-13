package edu.ahs.robotics.java;

public interface Clock {
    /**
     * Returns time in milliseconds since last call to reset
     * */
    long getCurrentTime();
    void reset();
}

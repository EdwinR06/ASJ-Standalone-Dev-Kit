package edu.ahs.robotics.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GridLoggerTest {

    @Test
    public void writeLn() {
        TestWriter writer = new TestWriter();
        TestClock clock = new TestClock();
        clock.setTime(1);
        GridLogger gridLogger = new GridLogger(writer, clock);
        gridLogger.add("RobotX", "2.4");
        gridLogger.add("RobotY", "1.8");
        gridLogger.writeLn();

        gridLogger.add("RobotX", "3.6");
        gridLogger.add("UnknownCategory", "x");
        //Not adding RobotY
        gridLogger.writeLn();

        gridLogger.add("RobotY", "2.1");
        gridLogger.add("RobotY", "4.2");
        clock.setTime(2);
        gridLogger.writeLn();


        List lines = writer.getLines();
        // check the lines

        assertEquals("Time,RobotX,RobotY", lines.get(0));
        assertEquals("1,2.4,1.8", lines.get(1));
        assertEquals("1,3.6,", lines.get(2));
        assertEquals("2,,4.2", lines.get(3));
        assertTrue(clock.resetCalled);
    }

    private class TestWriter implements LogWriter {

        List lines = new ArrayList();

        @Override
        public void writeLine(String line) {
            lines.add(line);
        }

        public List getLines() {
            return lines;
        }
    }

    private class TestClock implements Clock {
        private long startTime;
        private long currentTime;
        private boolean resetCalled = false;

        @Override
        public long getCurrentTime(){
            return currentTime;
        }

        @Override
        public void reset() {
            resetCalled = true;
        }

        public boolean isResetCalled() {
            return resetCalled;
        }

        public void setTime(long time){
            currentTime = time;
        }
    }
}


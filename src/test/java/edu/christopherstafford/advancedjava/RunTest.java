package edu.christopherstafford.advancedjava;

import java.time.LocalDate;
import java.time.LocalTime;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * JUnit tests for Run class
 * 
 * @author Christopher Stafford
 */
public class RunTest {
    
    private LocalDate date;
    private LocalTime startOfRun;
    private LocalTime endOfRun;
    private RunTime time;
    private long distance;
    
    // create known state for each test
    @Before 
    public void setup() {
        date = LocalDate.now();
        startOfRun = LocalTime.now();
        endOfRun = LocalTime.now();
        endOfRun.plusMinutes(30);
        distance = 3;
        time = new RunTime(startOfRun, endOfRun);
    }
    
    @Test
    public void testRunConstruction() {
        Run run = new Run(date, time, distance);
        
        assertEquals("The date is correct", run.getDate(), date);
        assertEquals("The time is correct", run.getTime(), time);
        assertEquals("The distance is correct", run.getDistance(), distance);
    }
    
    @Test
    public void testAvgPace() {
        Run run = new Run(date, time, distance);
        
        long avgPace;
        avgPace = run.getTime().getTime() / run.getDistance();
        assertEquals("Average pace is correct", run.getAvgPace(), avgPace);
    }
    
}

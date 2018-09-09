/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.christopherstafford.advancedjava;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;

import static junit.framework.Assert.assertEquals;


/**
 * JUnit test for RunTime class
 * 
 * @author Christopher Stafford
 */
public class RunTimeTest {
    
    private LocalTime now;
    private LocalTime thirtyMinutesFromNow;
    
    /**
     * Setup a know state before each test
     */
    
    @Before
    public void setup() {
        // create know state
        now = LocalTime.now();
        thirtyMinutesFromNow = LocalTime.now();
        thirtyMinutesFromNow.plusMinutes(30);
    }
    
    @Test
    public void testConstruction() {
        RunTime runTime = new RunTime(now, thirtyMinutesFromNow);
        
        assertEquals("start time", now, runTime.getStartTime());
        assertEquals("end time", thirtyMinutesFromNow, runTime.getEndTime());
    }
    
    @Test
    public void testTotalTime() {
        RunTime runTime = new RunTime(now, thirtyMinutesFromNow);
        long totalTime = runTime.getTime();
        long differenceInMinutes = (thirtyMinutesFromNow.getMinute() - now.getMinute());
        assertEquals(totalTime, differenceInMinutes);       
    }
}

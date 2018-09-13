package edu.christopherstafford.advancedjava;

import java.time.Duration;
import java.time.LocalTime;

/**
 * A simple time tracker class for a run workout
 * 
 * @author Christopher Stafford
 */
public class RunTime {
    
    private LocalTime startTime;
    private LocalTime endTime;
    
    /**
     * Creates a RunTime instance
     * 
     * @param startTime the starting time for the run
     * @param endTime   the ending time for the run
     */
    public RunTime(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    /**
     * Returns the start time of the run
     * 
     * @return the starting time of the run
     */
    public LocalTime getStartTime() {
        return startTime;
    }
    
    /**
     * @return the ending time of the run
     */
    public LocalTime getEndTime() {
        return endTime;
    }
    
    /**
     * @return the total time in minutes 
     */
    public long getTime() {
        Duration duration = Duration.between(this.startTime, this.endTime);        
        return (long) Math.abs(duration.toMinutes());
    }
    
}

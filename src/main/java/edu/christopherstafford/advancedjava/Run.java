package edu.christopherstafford.advancedjava;

import java.time.LocalDate;

/**
 *A simple class that models a run workout
 * 
 * @author Christopher Stafford
 */
public class Run {
    
    private LocalDate date;
    private RunTime time;
    private long distance;
    
    /**
     * Creates a new Run instance.
     * 
     * @param date  The date in which the run was completed
     * @param time  The total time it took to complete the run
     * @param distance  The distance in miles as a <CODE> </CODE>float </CODE>
     */
    public Run(LocalDate date, RunTime time, long distance) {
        this.date = date;
        this.time = time;
        this.distance = distance;
    }
    
    /**
     * @return the date of the run
     */
    public LocalDate getDate() {
        return date;
    }
    
    /**
     * @return the total time of the run
     */
    public RunTime getTime() {
        return time;
    }
    
    /**
     * @return total distance of run
     */
    public long getDistance() {
        return distance;
    }
    
    /**
     * @return average pace of run in minutes per mile
     */
    
    public long getAvgPace() {
        return time.getTime() / distance;
    }
}

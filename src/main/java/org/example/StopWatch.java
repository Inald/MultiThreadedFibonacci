package org.example;

public class StopWatch {

    /**
     * The startTime variable represents the starting time of an event or operation.
     * It is a private field that stores the value of the system time in milliseconds
     * when the event or operation starts.
     *
     * Example usage:
     *
     * StopWatch stopWatch = new StopWatch();
     * stopWatch.start();
     *
     * long startTime = stopWatch.getStartTime();
     *
     * The startTime variable should be accessed through a getter method, such as
     * getStartTime(), to retrieve its value.
     */
    private long startTime;

    /**
     * The ending time of the stopwatch.
     *
     * @since 1.0
     */
    private long endTime;

    /**
     * Starts the stopwatch and sets the start time to the current system time in milliseconds.
     */
    public void start() {
        startTime = System.currentTimeMillis();
    }

    /**
     * Stops the stopwatch by recording the end time.
     */
    public void stop() {
        endTime = System.currentTimeMillis();
    }

    /**
     * Calculates the elapsed time between the start and stop time.
     *
     * @return the elapsed time in milliseconds
     */
    public long getElapsedTime() {
        return endTime - startTime;
    }

    /**
     * Prints the elapsed time between the start and stop time of the stopwatch.
     * The elapsed time is displayed in milliseconds.
     * The output format is as follows:
     *
     * ---------------------
     * Execution time: <elapsedTime> milliseconds
     * ---------------------
     *
     * Example usage:
     *
     * StopWatch stopWatch = new StopWatch();
     * stopWatch.start();
     * // Some code here
     * stopWatch.stop();
     * stopWatch.printElapsedTime();
     *
     * This method retrieves the start and stop times previously recorded and
     * calculates the elapsed time by subtracting the start time from the stop time.
     * The elapsed time is then printed to the console.
     *
     * This method does not return any value and does not modify any data.
     */
    public void printElapsedTime() {
        System.out.println("\n---------------------");
        System.out.println("Execution time: " + getElapsedTime() + " milliseconds");
        System.out.println("---------------------");
    }
}

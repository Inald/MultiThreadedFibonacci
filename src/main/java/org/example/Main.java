package org.example;

import java.util.*;
import java.util.concurrent.*;

public class Main {

    /**
     * Entry point of the program.
     * Calculates and prints the Fibonacci sequence.
     * Uses a threaded approach for faster computation.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int input = 0;
        boolean isValid = false;
        final Scanner scanner = new Scanner(System.in);
        FibonacciCalculator fc = new FibonacciCalculator();
        StopWatch stopWatch = new StopWatch();
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        // Initialize the thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        input = getInput(isValid, input, scanner);

        System.out.println("Fibonacci Sequence: ");
        stopWatch.start(); //entering critical section

        retrieveFibonacciValues(input, executorService, concurrentHashMap, fc);

        // Shutdown executor service
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS); // Wait for all tasks to complete
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        printFibonacciSequence(concurrentHashMap);

        stopWatch.stop();
        stopWatch.printElapsedTime();


    }

    /**
     * Prints the Fibonacci sequence stored in the given ConcurrentHashMap.
     * The sequence is printed in the console.
     *
     * @param concurrentHashMap the ConcurrentHashMap containing the Fibonacci sequence
     */
    private static void printFibonacciSequence(ConcurrentHashMap<Integer, Integer> concurrentHashMap) {
        for(int i = 1; i <= concurrentHashMap.size(); i++) {
            System.out.print(concurrentHashMap.get(i) + " ");
        }
    }

    /**
     * Retrieves the Fibonacci values up to a given input using a threaded approach for faster computation.
     *
     * @param input               the number of Fibonacci values to generate
     * @param executorService     the executor service for executing the computation task on separate threads
     * @param concurrentHashMap   the concurrent hash map for storing the Fibonacci values
     * @param fc                  the Fibonacci calculator for calculating the Fibonacci values
     */
    private static void retrieveFibonacciValues(int input, ExecutorService executorService, ConcurrentHashMap<Integer, Integer> concurrentHashMap, FibonacciCalculator fc) {
        for(int i = 1; i <= input; i++){
            final int index = i;
            // Execute the computation task on a separate thread
            executorService.submit(() -> {
                concurrentHashMap.put(index, fc.calculateFibonacci(index));
            });
        }
    }

    /**
     * Retrieves the user input for the number of Fibonacci values to generate.
     *
     * @param isValid  a boolean indicating if the input is valid or not
     * @param input    the current input value
     * @param scanner  the Scanner object used for input
     * @return the user input for the number of Fibonacci values
     */
    private static int getInput(boolean isValid, int input, Scanner scanner) {
        while(!isValid) {
            try {
                System.out.println("Enter the number of fibonacci values that you would like to generate?\n");
                input = scanner.nextInt();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("That is not a valid Integer, please try again");
                scanner.nextLine(); //clears the scanner
            }
        }
        return input;
    }
}
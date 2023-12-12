package org.example;

public class FibonacciCalculator {

    /**
     * Calculates the Fibonacci value for a given input.
     *
     * @param n the input for which the Fibonacci value needs to be calculated
     * @return the Fibonacci value for the given input
     */
    public int calculateFibonacci(int n) {
        int fibonacciValue = 0;
        int previousValue = 0;
        if (n <= 1) {
            return n;
        } else {
            for (int i = 0; i < n; i++) {
                if(i == 0) {
                    fibonacciValue++;
                } else if (i == 1) {
                    fibonacciValue++;
                    previousValue = 1;
                } else {
                    fibonacciValue = fibonacciValue + previousValue;
                    previousValue = fibonacciValue;
                }
            }
        }

        return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
    }
}

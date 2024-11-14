/******************************************************************************
 * @file: Proj3.java
 * @description: This program runs a variety of sorting algorithms on a list of values.
 *               It compares the performance of these sorting algorithms based on how long they take and number of comparisons made.
 * @author: Max Finegan
 * @date: November 12, 2024
 ******************************************************************************/

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import java.io.FileOutputStream;

public class Proj3 {
    // Sorting Method declarations
    // Merge Sort
    public static <T extends Comparable> void mergeSort(ArrayList<T> a, int left, int right) {
        // Finish Me
        if (left < right) {
            int mid = (left + right) / 2; // Find the middle point
            // Recursively sort the first and second halves
            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);
            merge(a, left, mid, right); // Merge both halves
        }
    }

    public static <T extends Comparable> void merge(ArrayList<T> a, int left, int mid, int right) {
        // Finish Me
        // Temporary ArrayList to store merged results initialized with the same contents as 'a'
        ArrayList<T> temp = new ArrayList<>(a);

        // Set pointers to traverse the two halves
        int i = left;
        int j = mid + 1;
        int k = left;

        // Merge elements from the two halves into 'temp' in sorted order.
        while (i <= mid && j <= right) {
            // Compare elements from the left and right halves.
            // If the element in the left half is smaller, add it to 'temp' and move the left pointer 'i' forward.
            if (a.get(i).compareTo(a.get(j)) <= 0) {
                temp.set(k++, a.get(i++));
            } else {
                // If the element in the right half is smaller, add it to 'temp' and move the right pointer 'j' forward.
                temp.set(k++, a.get(j++));
            }
        }

        // Copy any remaining elements from the left half into 'temp'.
        while (i <= mid) {
            temp.set(k++, a.get(i++));
        }

        // Copy any remaining elements from the right half into 'temp'.
        while (j <= right) {
            temp.set(k++, a.get(j++));
        }

        // Copy the sorted elements from 'temp' back to the original list 'a'.
        for (i = left; i <= right; i++) {
            a.set(i, temp.get(i));
        }
    }

    // Quick Sort
    public static <T extends Comparable> void quickSort(ArrayList<T> a, int left, int right) {
        // Finish Me

        if (left < right) {
            // Partition the array and get the pivot index where elements are sorted around the pivot
            int pivotIndex = partition(a, left, right);

            // Recursively apply quickSort to the left of the pivot
            quickSort(a, left, pivotIndex - 1);

            // Recursively apply quickSort to the right of the pivot
            quickSort(a, pivotIndex + 1, right);
        }
    }

    public static <T extends Comparable> int partition (ArrayList<T> a, int left, int right) {
        // Finish Me

        // Make the rightmost element the pivot
        T pivot = a.get(right);

        // Initialize the smaller element index
        int i = left - 1;

        // Iterate through the list from left to right - 1
        for (int j = left; j < right; j++) {
            // If current element is less than or equal to pivot
            if (a.get(j).compareTo(pivot) <= 0) {
                // Increment the smaller element index and swap elements
                i++;
                swap(a, i, j);
            }
        }

        // Place the pivot element in its correct sorted position by swapping it with the element at i + 1, which is the first element larger than the pivot
        swap(a, i + 1, right);

        // Return the pivot index, so the list can be divided around this point
        return i + 1;
    }

    static <T> void swap(ArrayList<T> a, int i, int j) {
        T temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }

    // Heap Sort
    public static <T extends Comparable> void heapSort(ArrayList<T> a, int left, int right) {
        // Finish Me

        // Build a max heap from the input array
        for (int i = (right / 2) - 1; i >= left; i--) {
            heapify(a, i, right);
        }

        // Extract elements from the heap one by one
        for (int i = right; i > left; i--) {
            // Move the current root (largest element) to the end of the array
            swap(a, left, i);

            // Restore the max heap property on the reduced heap
            heapify(a, left, i - 1);
        }
    }

    public static <T extends Comparable> void heapify (ArrayList<T> a, int left, int right) {
        // Finish Me

        // Initialize largest as root
        int largest = left;

        // This is for 0-based indexing system

        // Calculate the index of the left child
        int leftChild = 2 * left + 1;

        // Calculate the index of the right child
        int rightChild = 2 * left + 2;

        // Check if the left child exists and is greater than the root
        if (leftChild <= right && a.get(leftChild).compareTo(a.get(largest)) > 0) {
            largest = leftChild;
        }

        // Check if the right child exists and is greater than the largest so far
        if (rightChild <= right && a.get(rightChild).compareTo(a.get(largest)) > 0) {
            largest = rightChild;
        }

        // If the largest element is not the root, swap and continue heapifying
        if (largest != left) {
            swap(a, left, largest);

            // Recursively heapify the affected subtree
            heapify(a, largest, right);
        }

    }

    // Bubble Sort
    public static <T extends Comparable> int bubbleSort(ArrayList<T> a, int size) {
        // Finish Me

        //int swaps = 0;
        int comparisons = 0;

        // Outer loop: iterates over the entire array
        for (int i = 0; i < size - 1; i++) {
            boolean swapped = false; // Flag to check if any swap happened in this pass

            // Inner loop: compares each pair of adjacent elements
            for (int j = 0; j < size - 1 - i; j++) {
                // Compare adjacent elements and swap them if they are out of order
                comparisons++;
                if (a.get(j).compareTo(a.get(j + 1)) > 0) {
                    // Swap elements if the current element is greater than the next
                    swap(a, j, j + 1);
                    //swaps++; // Increment the swap counter each time a swap occurs
                    swapped = true; // Mark that a swap happened
                }
            }

            // If no elements were swapped, the array is sorted, so break out of the loop
            if (!swapped) {
                break;
            }
        }

        // Return the number of swaps that occurred during the sort
        return comparisons;
    }


    // Odd-Even Transposition Sort
    public static <T extends Comparable> int transpositionSort(ArrayList<T> a, int size) {
        // Finish Me

        //int swaps = 0;
        int comparisons = 0;
        boolean sorted = false;

        // Continue sorting until no swaps are made
        while (!sorted) {
            sorted = true; // Assume the list is sorted until proven otherwise

            // Odd-index pass: compares and swaps elements at odd indices with their next element
            //comparisons++; // All comparisons that could be made in parallel are counted as a single comparison.
            for (int i = 1; i < size - 1; i += 2) {
                // If the current element is greater than the next, swap them
                comparisons++; // This is comparisons that are not made in parallel
                if (a.get(i).compareTo(a.get(i + 1)) > 0) {
                    swap(a, i, i + 1); // Swap the elements at indices i and i + 1
                    //swaps++;
                    sorted = false; // Set sorted to false, since a swap occurred
                }
            }
            // Even-index pass: compares and swaps elements at even indices with their next element
            //comparisons++; // All comparisons that could be made in parallel are counted as a single comparison.
            for (int i = 0; i < size - 1; i += 2) {
                // If the current element is greater than the next, swap them
                comparisons++; // This is comparisons that are not made in parallel
                if (a.get(i).compareTo(a.get(i + 1)) > 0) {
                    swap(a, i, i + 1); // Swap the elements at indices i and i + 1
                    //swaps++;
                    sorted = false; // Set sorted to false, since a swap occurred
                }
            }
        }

        // Return the number of swaps performed during the sorting process
        return comparisons;
    }

    public static void main(String[] args) throws IOException {
        //...
        // Finish Me
        //...

        //Command line arguments
        // 1) filename
        // 2) the sorting algorithm type to be executed (bubble, merge, quick, heap, transposition)
        // 3) the number of lines of the dataset to read.
        if(args.length != 3){
            System.out.println("Usage: java Main <filename> <algorithm> <number of lines>");
            return;
        }

        String inputFileName = args[0];
        String sortingAlgorithm = args[1];
        int numLines = Integer.parseInt(args[2]);

        // For file input
        FileInputStream inputFileNameStream = null;
        Scanner inputFileNameScanner = null;

        // Open the input file
        inputFileNameStream = new FileInputStream(inputFileName);
        inputFileNameScanner = new Scanner(inputFileNameStream);

        // ignore first line
        inputFileNameScanner.nextLine();


        ArrayList<Job> jobs = new ArrayList<>();

        // All variables for a job object
        Integer workYear;
        String jobTitle;
        String jobCategory;
        String salaryCurrency;
        Integer salary;
        Integer salaryInUSD;
        String employeeResidence;
        String experienceLevel;
        String employmentType;
        String workSetting;
        String companyLocation;
        String companySize;

        String currLine;
        String[] parts;

        // Loop through the csv and make a new Job object out of each line
        for (int i = 0; i < numLines; i++) {
            currLine = inputFileNameScanner.nextLine(); // Get the current line

            parts = currLine.split(","); // Split the current line by commas

            // Create a new Job object with parsed data
            workYear = Integer.parseInt(parts[0]);
            jobTitle = parts[1];
            jobCategory = parts[2];
            salaryCurrency = parts[3];
            salary = Integer.parseInt(parts[4]);
            salaryInUSD = Integer.parseInt(parts[5]);
            employeeResidence = parts[6];
            experienceLevel = parts[7];
            employmentType = parts[8];
            workSetting = parts[9];
            companyLocation = parts[10];
            companySize = parts[11];

            // Add the Job to the ArrayList
            jobs.add(new Job(workYear, jobTitle, jobCategory, salaryCurrency, salary, salaryInUSD,
                    employeeResidence, experienceLevel, employmentType, workSetting, companyLocation, companySize));

        }

        // Sort the ArrayList
        ArrayList<Job> sortedJobs = new ArrayList<>(jobs);
        Collections.sort(sortedJobs);


        // Shuffle the ArrayList
        ArrayList<Job> shuffledJobs = new ArrayList<>(jobs);
        Collections.shuffle(shuffledJobs);


        // Reverse the ArrayList
        ArrayList<Job> reversedJobs = new ArrayList<>(jobs);
        Collections.sort(reversedJobs, Collections.reverseOrder());


        // Write the arrays to sorted.txt
        writeToFile("Sorted Array, Shuffled Array, Reversed Array,\n", "./src/sorted.txt", false);
        // Write the contents of the arrays in a csv format
        for (int i = 0; i < sortedJobs.size() - 1; i++){
            writeToFile(sortedJobs.get(i) + ", //////// " + shuffledJobs.get(i) + ", //////// " + reversedJobs.get(i) + "\n",
                    "./src/sorted.txt", true);
        }


        double timeSorted = 0;
        double timeShuffled = 0;
        double timeReversed = 0;

        int comparisonsSorted = 0;
        int comparisonsShuffled = 0;
        int comparisonsReversed = 0;

        long startTime = System.nanoTime();

        // For sorted list
        switch (sortingAlgorithm) {
            case "bubble":
                comparisonsSorted = bubbleSort(sortedJobs, sortedJobs.size());
                break;
            case "merge":
                mergeSort(sortedJobs, 0, sortedJobs.size() - 1);
                break;
            case "quick":
                quickSort(sortedJobs, 0, sortedJobs.size() - 1);
                break;
            case "heap":
                heapSort(sortedJobs, 0, sortedJobs.size() - 1);
                break;
            case "transposition":
                comparisonsSorted = transpositionSort(sortedJobs, sortedJobs.size());
                break;
            default:
                System.err.println("Unknown sorting algorithm: " + sortingAlgorithm);
                System.exit(1);
        }
        timeSorted = (System.nanoTime() - startTime) / 1e9;

        // For shuffled list
        startTime = System.nanoTime();
        switch (sortingAlgorithm) {
            case "bubble":
                comparisonsShuffled = bubbleSort(shuffledJobs, shuffledJobs.size());
                break;
            case "merge":
                mergeSort(shuffledJobs, 0, shuffledJobs.size() - 1);
                break;
            case "quick":
                quickSort(shuffledJobs, 0, shuffledJobs.size() - 1);
                break;
            case "heap":
                heapSort(shuffledJobs, 0, shuffledJobs.size() - 1);
                break;
            case "transposition":
                comparisonsShuffled = transpositionSort(shuffledJobs, shuffledJobs.size());
                break;
        }
        timeShuffled = (System.nanoTime() - startTime) / 1e9;

        // For reversed list
        startTime = System.nanoTime();
        switch (sortingAlgorithm) {
            case "bubble":
                comparisonsReversed = bubbleSort(reversedJobs, reversedJobs.size());
                break;
            case "merge":
                mergeSort(reversedJobs, 0, reversedJobs.size() - 1);
                break;
            case "quick":
                quickSort(reversedJobs, 0, reversedJobs.size() - 1);
                break;
            case "heap":
                heapSort(reversedJobs, 0, reversedJobs.size() - 1);
                break;
            case "transposition":
                comparisonsReversed = transpositionSort(reversedJobs, reversedJobs.size());
                break;
        }
        timeReversed = (System.nanoTime() - startTime) / 1e9;

        // Print out in human-readable format
        System.out.printf("\nResults for %s Sort on %d lines:\n", sortingAlgorithm, numLines);
        System.out.println("--------------------------------------------------");
        System.out.printf("Sorted List - Time Taken: %.4f seconds", timeSorted);
        if (sortingAlgorithm.equals("bubble") || sortingAlgorithm.equals("transposition")) {
            System.out.printf(", Comparisons Made: %d\n", comparisonsSorted);
        } else {
            System.out.println();
        }
        System.out.printf("Shuffled List - Time Taken: %.4f seconds", timeShuffled);
        if (sortingAlgorithm.equals("bubble") || sortingAlgorithm.equals("transposition")) {
            System.out.printf(", Comparisons Made: %d\n", comparisonsShuffled);
        } else {
            System.out.println();
        }
        System.out.printf("Reversed List - Time Taken: %.4f seconds", timeReversed);
        if (sortingAlgorithm.equals("bubble") || sortingAlgorithm.equals("transposition")) {
            System.out.printf(", Comparisons Made: %d\n", comparisonsReversed);
        } else {
            System.out.println();
        }
        System.out.println("--------------------------------------------------");

        // Put data into analysis.txt
        try (FileOutputStream output = new FileOutputStream("analysis.txt", true)) {
            String result = String.format("%s,%d,%.4f,%d,%.4f,%d,%.4f,%d\n",
                    sortingAlgorithm, numLines, timeSorted, comparisonsSorted, timeShuffled,
                    comparisonsShuffled, timeReversed, comparisonsReversed);
            output.write(result.getBytes());
        }




    }

    // Generate the analysis file
    public static void writeToFile(String content, String filePath, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, append))){
            writer.write(content);
        }
        catch (IOException e) { // Error handling
            e.printStackTrace();
        }
    }


}

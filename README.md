# Project 3 @ CSC 201 Fall 2024: Sorting Algorithms

## Pledged Work Policy

This is a ___Pledged Work___ assignment.  This means that the work you submit for grading ___must___ be your work product.  
You may not submit the work of others outside of your team, or the modification of work of others outside of your team.
You are encouraged to talk with each other about general problems.  For example, you may talk to someone about "What does 
it mean when the compiler says there is a semicolon missing on line 20", or "I can not get my assignment template to 
download from GitHub, what did you do?".  However, you may not engage in "Could you send me a copy of your work so I can 
see how to get started?".  You may get full and detailed assistance from me, the Teaching Assistant (TA), and the TAs in 
the Computer Science Center.  If you have any question about the appropriateness of assistance, do not hesitate to 
consult with me.

If I believe you have violated our ___Pledge Work___ agreement, I will pursue this matter through the college Honor Council.

## Overview

Sorting algorithms are fundamental techniques in computer science that organize data in a specific order, optimized for 
data handling, retrieval, and analyses. Key algorithms, including Bubble Sort, Merge Sort, Quick Sort, Heap Sort, and 
Odd-Even Transposition Sort, each employ different strategies with varied efficiency in terms of space and time 
often evaluated with Big-O notation. 

In this project, you will: 

1. Implement the Bubble Sort, Merge Sort, Quick Sort, Heap Sort, and Odd-Even Transposition Sort algorithms.
2. Perform the sorting algorithms using already-sorted, shuffled, and reversed datasets lists as input.
3. Time the sorting algorithm performance for the different set of inputs.
4. Graph and analyze the performance of the sorting algorithms.

## Invocation and I/O Files:

The name of the program is `Proj3` ( provided with a `main` method in`Proj2.java` ).

You are encouraged to run and debug code in __IntelliJ IDEA__. Also, the program can be invoked from the command-line as:

```shell
java Proj3 {dataset-file} {sorting-algorithm-type} {number-of-lines}
```
## 1. **Implement Sorting Algorithms**

I have enclosed one starter code:
1. `Proj3.java` 
2. There are no other starter code files, but you can add more classes as needed (e.g., your dataset class). 

The `Proj3.java` file contains the main class that reads the input file and calls the sorting algorithms, as well as 
several unfinished sorting algorithm methods and helper methods that you will need to implement where it is indicated 
(Search for `// FINISH ME`).

The program takes in three command line arguments: 1) the filename if your dataset, 2) the sorting algorithm type to be 
executed (bubble, merge, quick, heap, transposition) and 3) the number of lines of your dataset to read.

For the Bubble Sort and Odd-Even Transposition Sort Algorithms, the return value is an integer corresponding to the 
number of comparisons made during the sorting processes. For the Odd-Even Transposition Sort Algorithm, all comparisons that 
could be made in parallel are counted as a single comparison.

The following is a pseudocode for the Odd-Even Transposition Sort Algorithm:

```
    while !isSorted
        begin 
            isSorted=true
            A loop to perform Bubble sort on odd indexed element
            A loop to perform Bubble sort on even indexed element
        end 
```

## 2. **Perform Sorting Algorithms on Already-Sorted, Shuffled, and Reversed Lists**

You will read your dataset and store the data in an ArrayList. To sort and randomize your ArrayList, you will use the 
`Collections.sort()`, `Collections.shuffle()`, and `Collections.sort(al, Collections.reverseOrder())` commands, 
respectively.

## 3. **Time Sorting Algorithm Performance**

For the Bubble Sort, Merge Sort, Quick Sort, and Heap Sort algorithms, you will use `System.nanoTime()` to calculate 
the time it takes to run them on already-sorted, shuffled, and reversed lists. 

For the Bubble Sort and Odd-Even Transposition Sort algorithms, you will count the number of comparisons made during 
the sorting processes.

Your program will print out the number of lines evaluated and the times and/or comparisons to sort the already-sorted, 
shuffled, and reversed lists to the screen in a human-readable format (i.e., nice to look at) and also separately to a 
file named `analysis.txt` in CSV format. Each time the program runs, it will append the timing results to 
`analysis.txt`. 

In addition, your program will print out the sorted lists to a file named `sorted.txt`. Each time the program runs, it 
will overwrite the previous sorted lists in `sorted.txt`.

## 4. **Graph and Analyze the Performance of the Sorting Algorithms**

Run your program several times for different number of lines of your dataset, N, by choosing different values of the 
second command line argument. After several runs, your `analysis.txt` file will be filled with timing and comparison data.

Using your favorite graphing software (e.g., MS Excel or Google Sheets), plot the running time (in seconds) or number of 
vs. N for each case. Take a screenshot of your graph and put them here by modifying this file, committing, and pushing 
it to this repository.

Bubble Sort, Merge Sort, Quick Sort, and Heap Sort running time (already sorted):
![image](https://github.com/user-attachments/assets/76f103c8-8c02-4bec-9966-99568f2effb6)


<img width="601" alt="Screenshot 2024-11-13 at 11 26 37 PM" src="https://github.com/user-attachments/assets/d9f36561-9921-42b3-ab0a-f620fd7ece66">


Bubble Sort, Merge Sort, Quick Sort, and Heap Sort running time (shuffled):


<img width="601" alt="Screenshot 2024-11-13 at 11 28 53 PM" src="https://github.com/user-attachments/assets/375ff95c-6e4a-4dc3-ae33-d47c4618d35a">




Bubble Sort, Merge Sort, Quick Sort, and Heap Sort running time (reversed):


<img width="601" alt="Screenshot 2024-11-13 at 11 31 47 PM" src="https://github.com/user-attachments/assets/d81d8d67-1948-4d12-abdc-be9e98053c7b">




Bubble Sort and Odd-Even Transposition Sort comparison (already sorted):


<img width="601" alt="Screenshot 2024-11-13 at 11 40 03 PM" src="https://github.com/user-attachments/assets/a08273f9-a498-4adc-88ca-3fb2b89fb11b">



Bubble Sort and Odd-Even Transposition Sort comparison (shuffled):


<img width="601" alt="Screenshot 2024-11-13 at 11 40 52 PM" src="https://github.com/user-attachments/assets/6e35177a-bc79-4884-9d7a-855b51ddadc7">



Bubble Sort and Odd-Even Transposition Sort comparison (reversed):


<img width="601" alt="Screenshot 2024-11-13 at 11 41 37 PM" src="https://github.com/user-attachments/assets/55139a1e-5ec1-47cf-ba7b-24cdee5d9ecc">




## Submission:

Your project will be developed and graded via GitHub. Your final "push" is your final submission, and it must occur 
before it is due. On Canvas, enter the url to your Github repository. Your project will not be graded without it.

## Recommendations:

I ___strongly suggest___ that you carefully think through your strategy before just jumping into the code.  Once that 
is working, start adding in new features individually.  A good place to start is building your class.

*In order to get full points of Commenting and Code Style, you need to add comments to every method and head comments 
for each file (providing file description, author, date, and acknowledgement).

```
/∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗*
∗ @file: filename.java
∗ @description: This program implements . . .
∗ @author: Your Name
∗ @date: November 14, 2024
∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗/
```

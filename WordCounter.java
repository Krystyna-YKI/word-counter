/**
 * title: WordCounter.java
 * description: Assignment 3 - Problem 1
 * date: June 10, 2024
 * @author Krystyna Chernykh
 * @version 1.0
 * @copyright 2001-2024 Krystyna Chernykh
 */
/**
 * DOCUMENTATION...
 */
/**                                                                               
 
 <H1>WordCounter</H1>
 
 <H3>Purpose and Description</H3>
 
 <P>
 This program counts the number of whitespace-separated words in a text file. 
 The user provides the name of the input file via a prompt when running the program. 
 The program reads the content of the file, counts the words, and outputs the total word count to the console.
 </P>

 <H3>
 Special instructions to compile and execute the program:
 </H3>
 <P>
 Save the code in a file named 'WordCounter.java'.
 Open a terminal or command prompt.
 Navigate to the directory where 'WordCounter.java' is saved.
 Compile the program using the command: 'javac WordCounter.java'
 Execute the program using the command: 'java WordCounter'
 </P>

<H3>Class</H3>

<P>
public class WordCounter {<BR>
This is the main class containing the program logic to read a file and count the number of words.
</P>


<H3>WordCounter Methods</H3>

<P>
public static void main(String[] args)
The entry point of the program. It handles user input for the file name, reads the file, counts the words, and outputs the total word count.
</P>


<H3>WordCounter Instance Variables</H3>

<P>
Scanner scanner: An instance of the Scanner class used to read user input from the console.

String fileName: A string variable to store the file name entered by the user.

int wordCount: An integer variable to keep track of the total number of words in the file.

BufferedReader reader: An instance of the BufferedReader class used to read text from the input file.

String line: A string variable to hold each line read from the file.

String[] words: An array of strings to store the words split from each line based on whitespace.

</P>

<H3>WordCounter Constructors</H3>

<P>
The WordCounter class uses the default constructor provided by Java, there are no explicitly defined constructors in the code.
</P>

/**
<H3>Test Plan</H3>

1. Basic Functionality Test:

INPUT:
A text file with a known number of words (sample1.txt containing "Hello world this is a test").
EXPECTED:
The program should count the words and output Total number of words: 6.
ACTUAL:
The console prints the results as expected, Total number of words: 6.


2. Empty File Test:

INPUT:
An empty text file (empty.txt).
EXPECTED:
The program should output Total number of words: 0.
ACTUAL:
The console prints the expected result, Total number of words: 0.


3. File with Multiple Lines Test:

INPUT:
A text file with multiple lines (sample2.txt).
EXPECTED:
The program should count the words and output Total number of words: 9.
ACTUAL:
The console prints the result as expected, Total number of words: 9.


4. File with Various Whitespace Characters Test:

INPUT:
A text file with spaces, tabs, and newlines (sample3.txt).
EXPECTED:
The program should count the words and output Total number of words: 19.
ACTUAL:
The console prints the result as expetced, Total number of words: 19.


5. Large File Test:

INPUT:
A large text file with many words (excerpt.txt).
EXPECTED:
The program should count the words and output Total number of words: 342.
ACTUAL:
The console prints the result as expetced, Total number of words: 342.


6. Non-existent File Test:

INPUT:
A file name that does not exist (nonexistent.txt).
EXPECTED:
The program should handle the error gracefully and output an error message like: An error occurred while reading the file: nonexistent.txt (The system cannot find the file specified).
Total number of words: 0
ACTUAL:
The console prints the result as expected.

7. File with Punctuation Test:

INPUT:
A text file with words separated by punctuation (sample4.txt containing "Hello,world! This;is.a").
EXPECTED:
The program should count the words and output Total number of words: 2.
ACTUAL:
The console prints the result as expected.

/**
 * CODE...
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WordCounter {

    public static void main(String[] args) {
        // Create a Scanner object to read user input from the console
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter the name of the input file
        System.out.print("Enter the name of the input file: ");
        String fileName = scanner.nextLine();  // Read the file name entered by the user

        int wordCount = 0;  // Initialize a variable to keep track of the word count

        // Try-with-resources to ensure the BufferedReader is closed automatically
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;  // Variable to hold each line read from the file
            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Split the line into words based on whitespace (spaces, tabs, newlines)
                String[] words = line.split("\\s+");
                // Add the number of words in this line to the total word count
                wordCount += words.length;
            }
        } catch (IOException e) {
            // Handle any IO exceptions that occur while reading the file
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        // Print the total number of words in the file
        System.out.println("Total number of words: " + wordCount);
    }
}


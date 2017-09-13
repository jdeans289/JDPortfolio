/*
 * Written as a personal project in March 2016
 * Author: Jacqueline Deans
 */

import java.util.Scanner;
import java.io.*;
import java.util.*;
public class Boggle {
    public static void main (String[] args) throws Exception
    {
        Scanner scan = new Scanner(new File("boggle-dictionary.txt"));
        Scanner scanBoard = new Scanner (System.in);        
        
        char[][] board = new char[4][4];
        System.out.println("Enter 16 letters for a 4x4 board (press enter between each letter):");
        for (int i = 0; i < 4; i++) // scan boggle board from user input
        {
            for (int j = 0; j < 4; j++)
            {
                board[i][j] = scanBoard.next().charAt(0);
            }
        }
        
        scanBoard.close();
        
        for (int i = 0; i < 4; i++) 	// print board
        {
            for (int j = 0; j < 4; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        
        
        String[] words = new String[173071];  // length of dictionary in use
        for (int i = 0; i < words.length; i++)	// scan entire dictionary into array
        {
            words[i] = scan.next().toLowerCase();
        }
        scan.close();
        
        int count = 0;
        ArrayList<String> foundWords= new ArrayList<>();
        for (String word : words)  // go through entire dictionary, search for each word on board
        {
            if (word.length() > 2) // we don't want 1 or 2 letter words
            {
                if (containsLetters(word, board))  // check if all letters in word are on the board (helps efficiency i think)
                {
                    char[][] copy = makeCopyArray(board);

                    if (containsWord(word, copy))  // goes to big scary algorithm
                    {
                        count++;
                        foundWords.add(word);
                        
                    }
                }
            }
        }
        ArrayList<String> sorted = sortList(foundWords); // sorts by length, then alphabetical
        System.out.println("Word count: " + count);
        System.out.print("Length: " + sorted.get(0).length() + " - " + sorted.get(0) + " ");
        for (int m = 1; m < sorted.size(); m++)
        {
            if (sorted.get(m).length() != sorted.get(m-1).length())
            {
                System.out.println();
                System.out.print("Length: " + sorted.get(m).length() + " - " + sorted.get(m) + " ");
            }
            else
            {
                System.out.print(sorted.get(m) + " ");
            }
        }

    }
    
    static ArrayList<String> sortList (ArrayList<String> words) // sorts words by length, then alphabetical
    {
        ArrayList<String> sortedList = new ArrayList<>();
        
        while (!words.isEmpty())
        {
            int index = 0;
            for (int i = 0; i < words.size(); i++)
            {
                if (words.get(i).length() > words.get(index).length())
                    index = i;
            }
            sortedList.add(words.get(index));
            words.remove(index);
        }
        
        return sortedList;
    }
    
    static char[][] makeCopyArray (char[][] board)
    {   // makes a copy of the array to avoid messing up the original
        char[][] copy = new char[4][4];
        
        for (int i = 0; i < 4; i++)
        {
            System.arraycopy(board[i], 0, copy[i], 0, 4);
        }
        
        return copy;
            
    }
    
    static boolean containsLetters(String word, char[][] board)  // check to see if all letters in word are on the board
    {
        word = word.toLowerCase();
        boolean allThere = true;
        for (int i = 0; i < word.length(); i++)
        {
            boolean found = false;
            for (char[] row : board)
            {
                for (char ch : row)
                {
                    if (word.charAt(i) == ch)
                        found = true;
                }
            }
            if (!found)
                allThere = false;
        }
        
        return allThere;
    }
    
    
    static boolean containsWord (String word, char[][] board)  // finds possible starting index for a word, passes to recursive version
    {  
        word = word.toLowerCase();
        boolean found = false;
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board.length; j++)
            {
                if (word.charAt(0) == board[i][j])
                {
                    if (containsWord(word, makeCopyArray(board), i, j)) // moves to big scary recursive algorithm below
                        found = true;
                }
            }
        }
        
        return found;
    }
    
    static boolean containsWord (String word, char[][] board, int x, int y) // the big scary recursive algorithm, given starting index for word/partial word
    {  
        if (word.length() == 1) // base case
            return true;
        
        board[x][y] = '0';	// keep track of which spaces have been used
        boolean found = false;
        
        if (validSpace(x+1,y) && board[x+1][y] == word.charAt(1)) // check right
        {
            if (!found)
                found = containsWord(word.substring(1), makeCopyArray(board), x+1,y);
        }
        if (validSpace(x-1,y) && board[x-1][y] == word.charAt(1)) // check left
        {
            if (!found)
                found = containsWord(word.substring(1), makeCopyArray(board), x-1,y);
        }
        if (validSpace(x,y+1) && board[x][y+1] == word.charAt(1)) // check up
        {
            if (!found)
                found = containsWord(word.substring(1), makeCopyArray(board), x, y+1);
        }
        if (validSpace(x,y-1) && board[x][y-1] == word.charAt(1)) // check down
        {
            if (!found)
                found = containsWord(word.substring(1), makeCopyArray(board), x, y-1);
        }
        
        // diagonal time
        if (validSpace(x+1,y+1) && board[x+1][y+1] == word.charAt(1)) // check up right
        {
            if (!found)
                found = containsWord(word.substring(1), makeCopyArray(board), x+1,y+1);
        }
        if (validSpace(x-1,y+1) && board[x-1][y+1] == word.charAt(1)) // check up left
        {
            if (!found)
                found = containsWord(word.substring(1), makeCopyArray(board), x-1,y+1);
        }
        if (validSpace(x+1,y-1) && board[x+1][y-1] == word.charAt(1)) // check down right
        {
            if (!found)
                found = containsWord(word.substring(1), makeCopyArray(board), x+1,y-1);
        }
        if (validSpace(x-1,y-1) && board[x-1][y-1] == word.charAt(1)) // check down left
        {
            if (!found)
                found = containsWord(word.substring(1), makeCopyArray(board), x-1,y-1);
        }
        //System.out.println("WORD REJECTED: not touching " + word);
        return found;
    }
    
    static boolean validSpace(int x, int y) // make sure x and y value point to spot within the board
    {
        return (x < 4 && x >= 0 && y < 4 && y >= 0);
    }
    
}
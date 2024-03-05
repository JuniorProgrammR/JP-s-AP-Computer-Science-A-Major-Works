

import java.util.ArrayList;
public class bogoSort{
    public static void main(String[] args) {
        //arraySize is a variable that can be adjusted to create an array to be sorted within a certain range using Math.random()
        //It may also be set to a constant (as in this example of 48 cards in a deck)
        int arraySize=48;

        ArrayList<Integer> array=new ArrayList<Integer>();
        long iterations=1; // Counts the number of times that the array  has been resorted until it is sorted

        //Randomly initializes the array according to the given parameter arraySize.
        for(int index=0;index<arraySize;index++)
        {
            array.add((int)(Math.random()*40%40));
        }
        arrayToString(array); // Outputs the initial generation of numbers

        // The following code encased in curly bracelets repeats until the condition inside the pranthesis is not achieved/
        // i.e. unsorted=true(repeated), NOT unsorted=false(not repeated)
        while(unSorted(array))
        {
            array=shuffleArray(array);
            arrayToString(array);
            iterations++; // Counts the number of times that the array  has been resorted until it is sorted
        }
        System.out.print("Sorted in "+iterations+" iterations"); // This line is only executed after the has been completely sorted, which will inform the user how many iterations it took to do so.
        // There may be a long overflow error that occurs due to the high time-complexity of this algorithm, in which the values of iterations exceeds Long.MAX_VALUE
    }
    
    // Defines whether or not a given array is sorted or unsorted in ascending order
    // an unsorted array will return true, while a sorted array will return false
    public static boolean unSorted(ArrayList<Integer> array)
    {
        for(int index=0;index<array.size()-1;index++)
        {
            if((array.get(index).compareTo(array.get(index+1)))>0)
            {
                return true;
            }
        }
        return false;
    }
    
    // An out-of-place method for changing the order of a given array.
    // Although less efficient than an in-place method, the negative impacts are neglible because this program will not recursively call itself
    // It instead uses a while loop to limit the space-complexity to 2*array.size() 
    public static ArrayList<Integer> shuffleArray(ArrayList<Integer> array)
    {
        ArrayList<Integer> output=new ArrayList<Integer>();
        while(array.size()>0)
        {
            output.add(array.remove((int)(Math.random()*array.size())));
        }
        return output;
    }

    // Prints an ArrayList of Integers using the format "1st_element "+" 2nd_element " etc
    public static void arrayToString(ArrayList<Integer> array)
    {
        for(int index=0;index<array.size();index++)
        {
            System.out.print(array.get(index)+" ");
        }
        System.out.println();
    }
}
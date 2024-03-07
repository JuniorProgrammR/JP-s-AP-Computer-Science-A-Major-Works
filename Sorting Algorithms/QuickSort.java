package Sorting;
import java.util.ArrayList;

class QuickSort
{
    public static int comparisons=0;
    public static void main(String[] args) {
        int arraySize=3;
        ArrayList<Integer> array=generateArray(arraySize);
        arrayToString(array);
        pivot(array);
    }

    public static ArrayList<Integer> generateArray(int arraySize)
    {
        ArrayList<Integer> array=new ArrayList<Integer>();
        for(int index=0;index<arraySize;index++)
        {
            array.add((int)(Math.random()*40%40));
        }
        return array;
    }
    
    public static void pivot(ArrayList<Integer> array)
    {
        int iterations=1;
        while(unSorted(array))
        {
            int pivotIndex=(array.size()-1)/iterations;
            for(int index=1;index<=iterations;index++)  // The number of subsections is defined by the iteration
            {
                for(int index2=0;index2<pivotIndex*index;index2++)
                {
                    comparisons++;
                    if(array.get(index2).compareTo(array.get(pivotIndex*index))>=0)
                    {
                        array.add(pivotIndex*index, array.remove(index2));
                    }
                }
            }
            iterations++;
            if(iterations>=array.size())
            break;
        }
        arrayToString(array);
        System.out.println("Sorted in "+iterations+" iterations using "+comparisons+" comparisons.");
     
    }

    public static boolean unSorted(ArrayList<Integer> array)
    {
        for(int index=0;index<array.size()-1;index++)
        {
            comparisons++;
            if((array.get(index).compareTo(array.get(index+1)))>0)
            {
                return true;
            }
        }
        return false;
    }
    
    public static void arrayToString(ArrayList<Integer> array)
    {
        for(int index=0;index<array.size();index++)
        {
            System.out.print(array.get(index)+" ");
        }
        System.out.println();
    }
}
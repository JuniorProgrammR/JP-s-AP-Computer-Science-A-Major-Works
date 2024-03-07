package Sorting;
import java.util.ArrayList;

public class MergeSort {
  public static int comparisons;
    public static void main(String[] args)
    {
        int arraySize=3;
        ArrayList<Integer> array=generateArray(arraySize);
        arrayToString(array);

        array=mergeSort(array);

        arrayToString(array);

        System.out.println("Sorted using "+comparisons+" comparisons");
        
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
    
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> array)
    {
      ArrayList<ArrayList<Integer>> subList=new ArrayList<ArrayList<Integer>>();
      subList=singularity(array);
      array=merge(subList);
      return array;
    }

    private static ArrayList<ArrayList<Integer>> singularity(ArrayList<Integer> array)
      {
        ArrayList<ArrayList<Integer>> output=new ArrayList<ArrayList<Integer>>();
        for(int index=0;index<array.size();index++)
        {
          ArrayList<Integer> container=new ArrayList<Integer>();
          container.add(array.get(index));
          output.add(container);
        }
        return output;
      }

    private static ArrayList<Integer> merge(ArrayList<ArrayList<Integer>> input)
    {
      if(input.size()<=1)
      {
        return input.get(0);
      }
      //index is used to references 2 arrays from input
      for(int index=0;index<input.size();index++)
      {
        //index2 is used to reference a element from the first array and compares it with the first element of the second array.
        //the element from the second array will be added to the first array(sorted) and removed from the second array
        //repeat until the second array has no elements, then delete the second array.
        for(int index2=0;index2<input.get(index).size();index2++)
        {
          comparisons++;
          if(index+1>=input.size()||input.get(index+1).size()==0)
          {
            comparisons++;
            break;
          }
          else if(input.get(index).get(index2).compareTo(input.get(index+1).get(0))>0)
          {
            comparisons++;
            input.get(index).add(index2, input.get(index+1).remove(0));
          }
          else if(index2==input.get(index).size()-1)
          {
            comparisons+=2;
            input.get(index).add(input.get(index+1).remove(0));
          }
          else
          {
            comparisons+=3;
          }
        }
        if(index+1>=input.size())
        {
          break;
        }
        input.remove(index+1);
      }
      return merge(input);
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

import java.util.ArrayList;

public class Assignment10_AnagramList
{
  private ArrayList<String> anagrams;

  public AnagramList(String word)
  {
    anagrams = new ArrayList<String>();
    completeAnagrams(word, "");
    mergeSort();
    //selectionSort();
  }

  private void completeAnagrams(String start, String end)
  {
    if(start.length()<=1)
    {
      anagrams.add(end+start);
    }
    else
    {
      ArrayList<String> used=new ArrayList<String>();
      used.add("");
      for(int index=0;index<start.length();index++)
      {
        
        boolean exists=false;
        for(String check:used)
        {
          if(check.equals(start.substring(index,index+1)))
          {
            exists=true;
            break;
          }
        }
        if(!exists)
        {
          //Append a letter from start to end
          completeAnagrams(start.substring(0,index)+start.substring(index+1),end+start.substring(index,index+1));
          used.add(start.substring(index,index+1));
        }
      }
    }
  }
  
  // Selection Sort (deprecated)
  private void selectionSort(){
    ArrayList<String> output=new ArrayList<String>();
    while(anagrams.size()>=1)
    {
      String maxString=anagrams.get(0);
      int maxIndex=0;
      for(int index=1;index<anagrams.size();index++)
      {
        if(anagrams.get(index).compareTo(maxString)<0)
        {
          maxString=anagrams.get(index);
          maxIndex=index;
        }
        
      }
      output.add(anagrams.remove(maxIndex));
    }
    anagrams=output;
  }
  
  // Merge Sort
  private void mergeSort(){
    ArrayList<ArrayList<String>> subList=new ArrayList<ArrayList<String>>();
    subList=singularity(anagrams);
    anagrams=merge(subList);
  }
  private ArrayList<ArrayList<String>> singularity(ArrayList<String> input)
  {
    ArrayList<ArrayList<String>> output=new ArrayList<ArrayList<String>>();
    for(int index=0;index<anagrams.size();index++)
    {
      ArrayList<String> container=new ArrayList<String>();
      container.add(anagrams.get(index));
      output.add(container);
    }
    return output;
  }
  private ArrayList<String> merge(ArrayList<ArrayList<String>> input)
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
        if(index+1>=input.size()||input.get(index+1).size()==0)
        {
          break;
        }
        else if(input.get(index).get(index2).compareTo(input.get(index+1).get(0))>0)
        {
          input.get(index).add(index2, input.get(index+1).remove(0));
        }
        else if(index2==input.get(index).size()-1)
        {
          input.get(index).add(input.get(index+1).remove(0));
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

  // Binary Search
  // searchAnagrams completes the first iteration for searching target
  public int searchAnagrams(String target){
    String midElement=anagrams.get(anagrams.size()/2);
    if(target.equals(midElement))
    {
      return anagrams.size()/2;
    }
    else if(target.compareTo(midElement)<0) // 1st half(below half)
    {
      int nextMid=anagrams.size()*3/4; // =mid+=anagrams.size()/4
      return subSearch(target, nextMid, 8);
    }
    else//if (target.compareTo(midElement)>0) // 2nd half(above half)
    {
      
      int nextMid=anagrams.size()/4; // =mid-=anagrams.size()/4
      return subSearch(target, nextMid, 8);
    }
  }
  // subSearch performs non-first iterations using a sequence to find the middle defined by array.size()/(2^(n+2))
  private int subSearch(String target, int midIndex, int sequence)
  {
    int stepSize; // Determines the increments for splitting the array in half
    if(sequence>anagrams.size()) // Prevents a divide by 0 error/integer overflow
    {
      stepSize=1; 
      sequence=anagrams.size()+1;
    }
    else
    {
      stepSize=anagrams.size()/sequence; // Halves the step size each time
    }
    
    if(midIndex>=anagrams.size()||midIndex<0) // Prevents IndexOutOfBounds error
    {
      return -1;
    }
    String midElement=anagrams.get(midIndex);
    
    // This if-else chain compares the mid with the target and determines whether it needs to go higher, lower, or if it does not exist
    if(target.equals(midElement))
    {
      return midIndex;
    }
    else if(target.compareTo(midElement)<0) //1st half
    {
      int nextMid=midIndex-stepSize;
      if (midIndex-1>=0&&target.compareTo(anagrams.get(midIndex-1))>0)
      {
        return -1;
      }
      return subSearch(target, nextMid, sequence*2);
    }
    else//if (target.compareTo(midElement)>0) // 2nd half
    {
      
      int nextMid=midIndex+stepSize;
      if (midIndex+1<anagrams.size()&&target.compareTo(anagrams.get(midIndex+1))<0)
      {
        return -1;
      }
      return subSearch(target, nextMid, sequence*2);
    }
  }

  // Used to get list of anagrams externally, do not remove (provided by Project STEM)
  public ArrayList<String> getAnagrams()
  {
    return anagrams;
  }
}

import java.util.ArrayList;
import java.lang.Math;
// This is all original code
public class GameWheel
{
  private ArrayList<Slice> slices=new ArrayList<Slice>(); // List of slices making up the wheel
  private int currentPos;   // Position of currently selected slice on wheel


  /* Returns string representation of GameWheel with each numbered slice
   * on a new line
   */
  public String toString()
  {
    int pos=0;
    for(Slice slice:slices)
    {
      String color=slice.getColor();
      int prize=slice.getPrizeAmount();
      System.out.println(pos+" - Color: "+color+", Prize Amount: $"+prize);
      pos++;
    }
    return "";
  }


  public ArrayList<ArrayList<Slice>> segregate()
  {
    int pos=0;
    ArrayList<Slice> black=new ArrayList<Slice>(); //multiples of 5 are black
    ArrayList<Slice> red=new ArrayList<Slice>(); //Odds are red
    ArrayList<Slice> blue=new ArrayList<Slice>(); //evens are blue
    for(Slice slice:slices) //Sorts the wheel into 3 arraylists of their respective colors
    {
      if(pos%5==0)
      {
        black.add(slice);
      }
      else if(pos%2==1)
      {
        red.add(slice);
      }
      else if(pos%2==0)
      {
        blue.add(slice);
      }
      pos++;
    }
    ArrayList<ArrayList<Slice>> lists=new ArrayList<ArrayList<Slice>>();
    lists.add(black);
    lists.add(red);
    lists.add(blue);
    return lists;
  }
  /* Randomizes the positions of the slices that are in the wheel, but without
   * changing the pattern of the colors
   */
  public void scramble()
  {
    ArrayList<Slice> black=new ArrayList<Slice>();
    ArrayList<Slice> red=new ArrayList<Slice>();
    ArrayList<Slice> blue=new ArrayList<Slice>();
    {
    ArrayList<ArrayList<Slice>> rainbow=new ArrayList<ArrayList<Slice>>();
    rainbow=segregate();
    black=rainbow.get(0);
    red=rainbow.get(1);
    blue=rainbow.get(2);
    }
    int pos=0;
    int blackCount=0;
    int redCount=0;
    int blueCount=0;
    double order=0;
    double prevOrder=0; //These 2 variables are for randomization
    ArrayList<Slice> mixer=new ArrayList<Slice>(); //This will later be set to slices
    for(int index=0;index<slices.size();index++)
    {
    if(pos%5==0) //If the space is black
    {
      order=Math.random();
      if(order>prevOrder||blackCount<1)
      {
        mixer.add(black.get(blackCount));
      }
      else
      {
        mixer.add(mixer.get(0));
        mixer.set(0,black.get(blackCount));
      }
      blackCount++;
    }
    else if(pos%2==1) //If the space is red
    {
      order=Math.random();
      if(order>prevOrder||redCount<1)
      {
        mixer.add(red.get(redCount));
      }
      else
      {
        mixer.add(mixer.get(1));
        mixer.set(1,red.get(redCount));
      }
      redCount++;
    }
    else if(pos%2==0) //If the space is blue
    {
      
      order=Math.random();
      if(order>prevOrder||blueCount<1)
      {
        mixer.add(blue.get(blueCount));
      }
      else
      {
        mixer.add(mixer.get(2));
        mixer.set(2,blue.get(blueCount));
      }
      blueCount++;
    }
    pos++;
    prevOrder=order;
    }
    slices=mixer; //Takes the randomized wheel and stores it
  }


  /* Sorts the positions of the slices that are in the wheel by prize amount,
   * but without changing the pattern of the colors.
   */
  public void sort(){
    ArrayList<Slice> black=new ArrayList<Slice>();
    ArrayList<Slice> red=new ArrayList<Slice>();
    ArrayList<Slice> blue=new ArrayList<Slice>();
    {
    ArrayList<ArrayList<Slice>> rainbow=new ArrayList<ArrayList<Slice>>();
    rainbow=segregate();
    black=rainbow.get(0);
    red=rainbow.get(1);
    blue=rainbow.get(2);
    }
    
    for(int index=1;index<black.size();index++)
    {
      Slice current=black.get(index);
      for(int index2=index-1;index2>=0;index2--)
      {
        if(current.getPrizeAmount()<black.get(index2).getPrizeAmount())
        {
          black.set(index2+1,black.get(index2));
          black.set(index2,current);
        }
        else
        {
          break;
        }
      }
    }
    for(int index=1;index<red.size();index++)
    {
      Slice current=red.get(index);
      for(int index2=index-1;index2>=0;index2--)
      {
        if(current.getPrizeAmount()<red.get(index2).getPrizeAmount())
        {
          red.set(index2+1,red.get(index2));
          red.set(index2,current);
        }
        else
        {
          break;
        }
      }
    }
    for(int index=1;index<blue.size();index++)
    {
      Slice current=blue.get(index);
      for(int index2=index-1;index2>=0;index2--)
      {
        if(current.getPrizeAmount()<blue.get(index2).getPrizeAmount())
        {
          blue.set(index2+1,blue.get(index2));
          blue.set(index2,current);
        }
        else
        {
          break;
        }
      }
    }
    
    //This code block concatatenates all the colors
    ArrayList<Slice> mixer=new ArrayList<Slice>();
    {
    int blackCount=0;
    int redCount=0;
    int blueCount=0;
    for(int index=0;index<slices.size();index++)
    {
      if(index%5==0)
      {
        mixer.add(black.get(blackCount));
        blackCount++;
      }
      else if(index%2==1)
      {
        mixer.add(red.get(redCount));
        redCount++;
      }
      else
      {
        mixer.add(blue.get(blueCount));
        blueCount++;
      }
    }
    }
    slices=mixer;
  }

  /* COMPLETED METHODS - YOU DO NOT NEED TO CHANGE THESE */

  /* Creates a wheel with 20 preset slices
   */
  public GameWheel()
  {
    this(getStandardPrizes());
  }

  /* Creates a wheel with 20 slices, using values from array parameter
   */
  public GameWheel(int[] prizes)
  {
    currentPos = 0;
    slices = new ArrayList<Slice>();
    for(int i = 0; i < 20; i++){
      int pa = 0;
      String col = "blue";
      if(i < prizes.length)
        pa = prizes[i];
      if (i%5 == 0)
        col = "black";
      else if (i%2 == 1)
        col = "red";
      slices.add(new Slice(col, pa));
    }
  }

  /* Spins the wheel by so that a different slice is selected. Returns that
   * slice (Note: the 10 slices following the current slice are more likely to
   * be returned than the other 10).
   */
  public Slice spinWheel()
  {
    //spin power between range of 1-50 (inclusive)
    int power = (int)(Math.random()*50 + 1);
    int newPos = (currentPos + power) % slices.size();
    currentPos = newPos;
    return slices.get(currentPos);
  }

  public Slice getSlice(int i)
  {
    int sliceNum = i;
    if(i < 0 || i > 19)
      sliceNum = 0;
    return slices.get(sliceNum);
  }

  // Makes an array with a standard list of prizes
  private static int[] getStandardPrizes()
  {
    int[] arr = new int[20];
    for (int i=0; i < 20; i++)
    {
      if (i%5 == 0)
        arr[i] = i*1000;
      else if (i%2 == 1)
        arr[i] = i*100;
      else
        arr[i] = i*200;
    }
    return arr;
  }
}

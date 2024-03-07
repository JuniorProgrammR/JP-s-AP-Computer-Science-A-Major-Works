//Assignment 8
import java.util.ArrayList;
public class Assignment8_Board{

  private String[][] squares;
  private ArrayList<Ship> ships=new ArrayList<Ship>();
  private static int floating=0;

  public Board() //Default Constructor
  {
    this(10,10);
  }
  public Board(int y,int x)
  {
    squares=new String[y][x];
    for(y=0;y<squares.length;y++)//Row Major
    {
      for(x=0;x<squares[y].length;x++)//Column Minor
      {
        squares[y][x]="-";
      }
    }
  }

  public String toString()
  {
    String output="";
    for(int y=0;y<squares.length;y++)//Row Major
    {
      for(int x=0;x<squares[y].length;x++)//Column Minor
      {
        output+=squares[y][x]+" ";
      }
      output=output.substring(0,output.length()-1)+"\n";
    }
    return output;
  }

  public boolean addShip(int row, int col, int len, boolean horizontal){
    if(horizontal)
    {
      if(len+col<=squares[0].length&&row<squares.length&&row>=0&&col>=0)
      {
        boolean placeable=true;
        int rightRie=col+len;
        for(int index=col;index<rightRie;index++)
        {
          if(squares[row][index].equals("b"))
          {
            placeable=false;
            break;
          }
        }
        if(placeable)
        {
          for(int index=col;index<rightRie;index++)
          {
            squares[row][index]="b";
          }
          ships.add(new Ship(len, row, col));
          floating+=len;
          return true;
        }
        else
        {
          return false;
        }
      }
      else
      {
        return false;
      }
    }
    else //if vertical
    {
      if(len+row<=squares.length&&col<squares[0].length&&col>=0&&row>=0)
      {
        boolean placeable=true;
        int bottomRie=row+len;
        for(int index=row;index<bottomRie;index++)
        {
          if(squares[index][col].equals("b"))
          {
            placeable=false;
            break;
          }
        }
        if(placeable)
        {
          for(int index=row;index<bottomRie;index++)
          {
            squares[index][col]="b";
          }
          ships.add(new Ship(len, row, col));
          floating+=len;
          return true;
        }
        else
        {
          return false;
        }
      }
      else
      {
        return false;
      }
    }
  }

  public boolean foundShip(int len){
    for(int index=0;index<ships.size();index++)
    {
      if(ships.get(index).getLen()==len)
      {
        return true;
      }
    }
    return false;
  }

  public int shoot(int row, int col){
    if(row<0||col<0||row>=squares.length||col>=squares[0].length)
    {
      return -1;
    }
    else if(squares[row][col].equals("-"))
    {
      squares[row][col]="m";
      return 0;
    }
    else if(squares[row][col].equals("b"))
    {
      squares[row][col]="x";
      floating--;
      return 1;
    }
    else //(squares[row][col].equals("m")||squares[row][col].equals("x"))
    {
      return 2;
    }
  }

  public boolean gameOver(){
    if(floating==0)
    {
      return true;
    }
    return false;
    /*boolean done=true;
    for(int index=0;index<squares.length;index++)
    {
      for(int index2=0;index2<squares[index].length;index2++)
      {
        if(squares[index][index2].equals("b"))
        {
          done=false;
          break;
        }
      }
    if(!done)
    {
      break;
    }
    }
  return done;*/
  }
private class Ship
{
  private int len;
  private int row;
  private int col;
  public Ship(int len, int row, int col)
  {
    this.len=len;
    this.row=row;
    this.col=col;
  }
  public int getLen()
  {
    return len;
  }
  public int getRow()
  {
    return row;
  }
  public int getCol()
  {
    return col;
  }
}
}

import java.util.Scanner;
class Assignment4 
{
  public static void main(String[] args) 
  {
    Scanner scan=new Scanner(System.in);
    System.out.println("Type the message to be shortened");
    String inp=scan.nextLine();
    inp=inp.toLowerCase();
    
    //ALGORITHM 1
    {
    System.out.println("\nAlgorithm 1");
    String out1="";
    int vow_re=0;
    int reap_re=0;
    for(int i=0;i<inp.length();i++)
    {
     /*if(i==0||inp.substring(i,i+1).equals(" "))
     {
       out1+=inp.substring(i,i+1);
     }*/
     if (i==0)
     {
        if((inp.substring(i,i+1).equals("a")||inp.substring(i,i+1).equals("e")||inp.substring(i,i+1).equals("i")||inp.substring(i,i+1).equals("o")||inp.substring(i,i+1).equals("u")))
        {
          out1+=inp.substring(i,i+1);
        }
        else if(i<inp.length()-1&&inp.substring(i,i+1).equals(inp.substring(i+1,i+2)))
        {
          reap_re++;
        }
        else
        {
          out1+=inp.substring(i,i+1);
        }
     }
     else if(!inp.substring(i-1,i).equals(" ")&&(inp.substring(i,i+1).equals("a")||inp.substring(i,i+1).equals("e")||inp.substring(i,i+1).equals("i")||inp.substring(i,i+1).equals("o")||inp.substring(i,i+1).equals("u")))
     {
       vow_re++;
     }
     else if(i<inp.length()-1&&inp.substring(i,i+1).equals(inp.substring(i+1,i+2)))
     {
       if(!(inp.substring(i,i+1).equals("a")||inp.substring(i,i+1).equals("e")||inp.substring(i,i+1).equals("i")||inp.substring(i,i+1).equals("o")||inp.substring(i,i+1).equals("u")))
       {
       reap_re++;
       }
       else
       {
         out1+=inp.substring(i,i+1);
       }
     }
     else
     {
       out1+=inp.substring(i,i+1);
     }
    }
    System.out.println("Vowels removed: "+vow_re+"\nRepeats removed: "+reap_re+"\nAlgorithm 1 message: "+out1);
    //System.out.println("Algorithm 1 characters saved: "+(inp.length()-out1.length()));
    System.out.println("Algorithm 1 characters saved: "+(vow_re+reap_re));
    }
    
    //ALGORITHM 2
    {
    String create="";
    //int char_re=0;
    int unique=0;
    System.out.println("\nAlgorithm 2");
    for(int i=0;i<inp.length();i++)
    {
      boolean repeat=false;
      boolean space=false;
      if(inp.substring(i,i+1).equals(" "))
      {
        space=true;
        //char_re++;
      }
      else
      {
      for(int ix=i-1;ix>=0;ix--)
        {
          if (ix>=0&&inp.substring(i,i+1).equals(inp.substring(ix,ix+1)))
          {
            repeat=true;
            //char_re++;
            break;
          }
        }
      }
      if(!(repeat||space))
      {
        int times=0;
        for(int ix=i;ix<inp.length();ix++)
        {
          if(inp.substring(i,i+1).equals(inp.substring(ix,ix+1)))
          {
            times++;
          }
        }
        unique++;
        create+=times+inp.substring(i,i+1);
      }
    }
      System.out.println("Unique characters found: "+unique);
      System.out.println("Algorithm 2 message: "+create);
      System.out.println("Algorithm 2 characters saved: "+(inp.length()-create.length()));
    }
  }
}

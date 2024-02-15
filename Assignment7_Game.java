import java.util.ArrayList;

public class Assignment7_Game
{
  public static void play(GameWheel g)
  {
    Slice s1=g.spinWheel();
    Slice s2=g.spinWheel();
    Slice s3=g.spinWheel();
    int sum=s1.getPrizeAmount()+s2.getPrizeAmount()+s3.getPrizeAmount();
    boolean jackpot=false;
    if(s1.getColor().equals(s2.getColor())&&s2.getColor().equals(s3.getColor()))
    {
      sum=2*sum;
      jackpot=true;
    }
    System.out.println("Total prize money: $"+sum+"\n");
    ArrayList<Slice> spins=new ArrayList<Slice>();
    spins.add(s1);
    spins.add(s2);
    spins.add(s3);
    int numb=1;
    for(Slice pie:spins)
    {
      System.out.print("Spin "+numb+" - "+pie);
      if(numb<3)
      System.out.println();
      numb++;
    }
    if(jackpot)
    {
      System.out.print("\nThree "+s1.getColor()+"s = double your money!");
    }
  }
}

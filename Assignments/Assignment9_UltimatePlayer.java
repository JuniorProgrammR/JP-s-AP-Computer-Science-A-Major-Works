public class Assignment9_UltimatePlayer extends Person
{
  private int jerseyNumber;
  private String position;
  private static int seed=1;
  
  public UltimatePlayer(String firstName, String lastName, String position)
  {
    super(firstName,lastName);
    if(position.equals("handler")||position.equals("cutter"))
    this.position=position;
    else//(!(position.equals("handler")||position.equals("cutter")))
    this.position="handler";
    jerseyNumber=seed;
    seed++;
  }
  
  public String getPosition()
  {
    return position;
  }
  
  public int throwDisc(int pow)
  {
    return super.throwDisc(pow)*2;
  }
  
  public String toString()
  {
    return super.toString()+"\n   Jersey #: "+jerseyNumber+"\n   Position: "+position;
  }
}

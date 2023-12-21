public class Assignment9_Captain extends UltimatePlayer
{
  private boolean type;
  
  public Captain(String firstName, String lastName, String position, boolean type)
  {
    super(firstName, lastName, position);
    this.type=type;
  }
  
  public int throwDisc(int pow)
  {
    return super.throwDisc(pow)*5/4;
  }
  
  public String toString()
  {
    String type;
    if(this.type)
    {
      type="offense";
    }
    else//(!this.type)
    {
      type="defense";
    }
    return super.toString()+"\n   Captain: "+type;
  }
}

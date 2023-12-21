public class Person
{
  private String firstName;
  private String lastName;
  
  public Person(String firstName,String lastName)
  {
    this.firstName=firstName;
    this.lastName=lastName;
  }
  
  public int throwDisc(int pow)
  {
    if(pow>1&&pow<10)
    {
      return pow*2;
    }
    else if(pow<1)
    {
      return 1*2;
    }
    else //if(power>10)
    {
      return 10*2;
    }
  }
  
  public String toString()
  {
    return lastName+", "+firstName;
  }
}

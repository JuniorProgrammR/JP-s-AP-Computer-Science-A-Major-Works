public class Assignment9_UltimateTeam
{
  private ArrayList<UltimatePlayer> players;
  private ArrayList<Coach> coaches;
  
  public UltimateTeam(ArrayList<UltimatePlayer> players, ArrayList<Coach> coaches)
  {
    this.players=players;
    this.coaches=coaches;
  }
  
  public String getCutters()
  {
    String output="";
    for(int index=0;index<players.size();index++)
    {
      if(players.get(index).getPosition().equals("cutter"))
      {
        output+=players.get(index).toString()+"\n";
      }
    }
    return output;
  }
  
  public String getHandlers()
  {
    String output="";
    for(int index=0;index<players.size();index++)
    {
      if(players.get(index).getPosition().equals("handler"))
      {
        output+=players.get(index).toString()+"\n";
      }
    }
    return output;
  }
  
  public String toString()
  {
    String output="";
    output+="COACHES\n";
    for(int index=0;index<coaches.size();index++)
    {
      output+=coaches.get(index).toString()+"\n";
    }
    output+="PLAYERS\n";
    for(int index=0;index<players.size();index++)
    {
      output+=players.get(index).toString()+"\n";
    }
    output=output.substring(0,output.length()-1);
    return output;
  }
}

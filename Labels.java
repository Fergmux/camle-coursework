// COMS22201: Register Allocation

public class Labels
{
  static int next = 1;

  public static String nextLab()
  {
    String lab = "L" + next;
    next ++;
    return lab;
  }

}

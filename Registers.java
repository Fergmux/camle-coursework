// COMS22201: Register Allocation

public class Registers
{
  static int next = 1;

  public static String nextReg()
  {
    String reg = "R" + next;
    next ++;
    return reg;
  }

}

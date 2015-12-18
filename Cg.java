// COMS22201: Code generation

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class Cg
{
  public static void program(IRTree irt, PrintStream o)
  {
    emit(o, "XOR R0,R0,R0");   // Initialize R0 to 0
    statement(irt, o);
    emit(o, "HALT");           // Program must end with HALT
    Memory.dumpData(o);        // Dump DATA lines: initial memory contents
  }

  private static void statement(IRTree irt, PrintStream o)
  {
    String result = "";
    // System.out.println(irt.getOp());
    String op = irt.getOp();
    if (op.equals("SEQ")) {
      statement(irt.getSub(0), o);
      statement(irt.getSub(1), o);
    }
    else if (op.equals("WRS") && irt.getSub(0).getOp().equals("MEM") && irt.getSub(0).getSub(0).getOp().equals("CONST")) {
      String a = irt.getSub(0).getSub(0).getSub(0).getOp();
      emit(o, "WRS "+a);
    }
    else if (op.equals("WR")) {
      String b = expression(irt.getSub(0), o);
      emit(o, "WR "+b);
    }
    else if (op.equals("RD")) {
      String b = expression(irt.getSub(0), o);
      emit(o, "RD "+b);
      emit(o, "STORE "+b+",R0,"+irt.getSub(0).getSub(0).getSub(0).getOp());
    }
    else if (op.equals("MOVE")) {
      String c = expression(irt.getSub(1), o); // register that got the value on it
      result = irt.getSub(0).getSub(0).getSub(0).getOp();
      emit(o, "STORE "+c+",R0,"+result);
    }
    else if (op.equals("IF")) {
      // System.out.println(irt.getSub(0).getOp() + " louis");
      // System.out.println(irt.getSub(1).getOp());
      // System.out.println(irt.getSub(2).getOp());
      // System.out.println(irt.getSub(3).getOp());
      expression(irt.getSub(0), o);
      expression(irt.getSub(1), o);
      emit(o, "JMP "+irt.getSub(3).getSub(0).getOp());
      expression(irt.getSub(2), o);
      expression(irt.getSub(3), o);
      // emit(o, "JMP "+irt.getSub(2).getSub(0).getOp());
    }
    else if (op.equals("SKIP")) {
     // emit(o, "JMP "+); 
    }
    else if (op.equals("END")) {
     
    }
    else if(op.equals("WHILE")) {
      expression(irt.getSub(2), o);
      emit(o, "JMP " +irt.getSub(3).getSub(0).getOp());
      expression(irt.getSub(1), o);
      emit(o, "JMP " +irt.getSub(2).getSub(0).getOp());
      expression(irt.getSub(3), o);
    }
    else if(op.equals("LESS")) {
      expression(irt, o);
    }
    else if(op.equals("EQUALS")) {
      expression(irt, o);
    }
    else {
      error(op);
    }
  }

  private static String expression(IRTree irt, PrintStream o)
  {
    String result = "";
    String result1 = "";
    String result2 = "";
    String op = irt.getOp();
    // System.out.println(op + " ballllll");
    if (op.equals("CONST")) {
      String t = irt.getSub(0).getOp(); 
      // System.out.println(t + " const");
      result = Registers.nextReg();
      emit(o, "ADDI "+result+",R0,"+t);
    }
    else if(op.equals("MEM"))
    {
      result = Registers.nextReg();
      result1 = irt.getSub(0).getSub(0).getOp();
      emit(o, "LOAD "+result+",R0,"+result1);
    }
    else if(op.equals("VAL"))
    {
      result = irt.getSub(0).getSub(0).getOp();
    }
    else if(op.equals("SUM")) {
      result = expression(irt.getSub(0), o);
      result1 = expression(irt.getSub(1), o);
      emit(o, "ADD "+result+","+result+","+result1);
    }
    else if(op.equals("MINUS")) {
      // System.out.println("MINUS:");
      result = expression(irt.getSub(0), o);
      result1 = expression(irt.getSub(1), o);
      emit(o, "SUB "+result+","+result+","+result1);
    }
    else if(op.equals("MULT")) {
      result = expression(irt.getSub(0), o);
      result1 = expression(irt.getSub(1), o);
      emit(o, "MUL "+result+","+result+","+result1);
    }
    else if(op.equals("BOOL")) {
      result = Registers.nextReg();
      result1 = irt.getSub(0).getOp();
      // System.out.println(result1 + " fuk");
      emit(o, "ADDI "+result+",R0,"+result1);
    }
    else if(op.equals("NOT")) {
      result = Registers.nextReg();
      result1 = expression(irt.getSub(0), o);
      emit(o, "ADDI "+result+",R0,1");
      emit(o, "SUB "+result+","+result+","+result1);
    }
    else if(op.equals("AND")) {
      result = expression(irt.getSub(0), o);
      result1 = expression(irt.getSub(1), o);
      emit(o, "MUL "+result+","+result+","+result1);
    }
    else if(op.equals("LESS")) {
      result = expression(irt.getSub(0), o);
      emit(o, "BLTZ "+result+","+irt.getSub(1).getOp());
      emit(o, "BEQZ "+result+","+irt.getSub(1).getOp());
      emit(o, "JMP " +irt.getSub(2).getOp());
    }
    else if(op.equals("EQUALS")) {
      result = expression(irt.getSub(0), o);
      emit(o, "BEQZ "+result+","+irt.getSub(1).getOp());
    }
    else if(op.equals("LABEL")) {
      // System.out.println(irt.getSub(0).getOp());
      // System.out.println(irt.getSub(0).getSub(0).getOp());
      // System.out.println(irt.getSub(0).getSub(0).getSub(0).getOp());
      // result = Registers.nextReg();
      // result1 = expression(irt.getSub(0), o);
      emit(o, irt.getSub(0).getOp()+":");
      statement(irt.getSub(1), o);
      // emit(o, "JMP " +irt.getSub(2).getOp());
    }
    else {
      // System.out.println("error here");
      error(op);
    }
    return result;
  }

  private static void emit(PrintStream o, String s)
  {
    o.println(s);
  }

  private static void error(String op)
  {
    System.out.println("CG error: "+op);
    System.exit(1);
  }
}


// COMS22201: IR tree construction

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class Irt
{
// The code below is generated automatically from the ".tokens" file of the
// ANTLR syntax analysis, using the TokenConv program.
//
// CAMLE TOKENS BEGIN
  public static final String[] tokenNames = new String[] {
"NONE", "NONE", "NONE", "NONE", "AND", "ASSIGN", "BOOLEAN", "CLOSEPAREN", "COMMENT", "DO", "ELSE", "EQUALS", "FALSE", "IDENTIFIER", "IF", "INTNUM", "LESS", "MINUS", "MULT", "NOT", "OPENPAREN", "READ", "SEMICOLON", "SKIP", "STRING", "SUM", "THEN", "TRUE", "WHILE", "WRITE", "WRITELN", "WS"};
  public static final int AND=4;
  public static final int ASSIGN=5;
  public static final int BOOLEAN=6;
  public static final int CLOSEPAREN=7;
  public static final int COMMENT=8;
  public static final int DO=9;
  public static final int ELSE=10;
  public static final int EQUALS=11;
  public static final int FALSE=12;
  public static final int IDENTIFIER=13;
  public static final int IF=14;
  public static final int INTNUM=15;
  public static final int LESS=16;
  public static final int MINUS=17;
  public static final int MULT=18;
  public static final int NOT=19;
  public static final int OPENPAREN=20;
  public static final int READ=21;
  public static final int SEMICOLON=22;
  public static final int SKIP=23;
  public static final int STRING=24;
  public static final int SUM=25;
  public static final int THEN=26;
  public static final int TRUE=27;
  public static final int WHILE=28;
  public static final int WRITE=29;
  public static final int WRITELN=30;
  public static final int WS=31;
// CAMLE TOKENS END

  public static IRTree convert(CommonTree ast)
  {
    IRTree irt = new IRTree();
    program(ast, irt);
    return irt;
  }

  public static void program(CommonTree ast, IRTree irt)
  {
    statements(ast, irt);
  }

  public static void statements(CommonTree ast, IRTree irt)
  {
    int i;
    Token t = ast.getToken();
    int tt = t.getType();
    if (tt == SEMICOLON) {
      IRTree irt1 = new IRTree();
      IRTree irt2 = new IRTree();
      CommonTree ast1 = (CommonTree)ast.getChild(0);
      CommonTree ast2 = (CommonTree)ast.getChild(1);
      statements(ast1, irt1);
      statements(ast2, irt2);
      irt.setOp("SEQ");
      irt.addSub(irt1);
      irt.addSub(irt2);
    }
    else {
      statement(ast, irt);
    }
  }

  public static void statement(CommonTree ast, IRTree irt)
  {
    CommonTree ast1, ast2, ast3;
    IRTree irt1 = new IRTree(), irt2 = new IRTree(), irt3 = new IRTree(), irt4 = new IRTree(), irt5 = new IRTree();;
    Token t = ast.getToken();
    int tt = t.getType();

    System.out.println(tokenNames[tt]);
    if (tt == WRITE) {
      ast1 = (CommonTree)ast.getChild(0);
      String type = arg(ast1, irt1);
      if (type.equals("int")) {
        irt.setOp("WR");
        irt.addSub(irt1);
      }
      else {
        irt.setOp("WRS");
        irt.addSub(irt1);
      }
    }
    
    else if (tt == WRITELN) {
      String a = String.valueOf(Memory.allocateString("\n"));
      irt.setOp("WRS");
      irt.addSub(new IRTree("MEM", new IRTree("CONST", new IRTree(a))));
    }
    
    else if (tt == ASSIGN) {
      ast1 = (CommonTree)ast.getChild(0);
      ast2 = (CommonTree)ast.getChild(1);

      expression(ast1, irt1);
      expression(ast2, irt2);

      irt.setOp("MOVE");
      irt.addSub(irt1);
      irt.addSub(irt2);
    }

    else if (tt == READ) {
      expression((CommonTree)ast.getChild(0), irt1);
      irt.setOp("RD");
      irt.addSub(irt1);
    }    
    else if (tt == IF) {
      irt.setOp("IF");
      expression((CommonTree)ast.getChild(0), irt1);
      // expression((CommonTree)ast.getChild(1), irt2);
      expression((CommonTree)ast.getChild(2), irt3);
      statements((CommonTree)ast.getChild(4), irt4);
      statements((CommonTree)ast.getChild(6), irt5);

      String L1 = Labels.nextLab();
      String L2 = Labels.nextLab();
      String L3 = Labels.nextLab();

      irt.addSub(new IRTree(tokenNames[ast.getChild(1).getType()], new IRTree("MINUS", irt1, irt3), new IRTree(L1), new IRTree(L2)));
      irt.addSub(new IRTree("LABEL", new IRTree(L1), irt4));
      irt.addSub(new IRTree("LABEL", new IRTree(L2), irt5));
      irt.addSub(new IRTree("LABEL", new IRTree(L3), new IRTree("END")));
      
    }
    else if (tt == WHILE) {
      irt.setOp("WHILE");
      expression((CommonTree)ast.getChild(0), irt1);
      // expression((CommonTree)ast.getChild(1), irt2);
      expression((CommonTree)ast.getChild(2), irt3);
      statements((CommonTree)ast.getChild(4), irt4);

      String L1 = Labels.nextLab();
      String L2 = Labels.nextLab();
      String L3 = Labels.nextLab();

      irt.addSub(new IRTree("CHEAT"));
      irt.addSub(new IRTree("LABEL", new IRTree(L1), irt4));
      irt.addSub(new IRTree("LABEL", new IRTree(L2), new IRTree(tokenNames[ast.getChild(1).getType()], new IRTree("MINUS", irt1, irt3), new IRTree(L1), new IRTree(L3))));
      irt.addSub(new IRTree("LABEL", new IRTree(L3), new IRTree("END")));
      
    }
    else if (tt == SKIP) {
      irt.setOp("SKIP");
    }
    else {
      // System.out.println("statement");
      error(tt);
    }
  }

  public static String arg(CommonTree ast, IRTree irt)
  {
    Token t = ast.getToken();
    int tt = t.getType();
    
    System.out.println(tokenNames[tt]);
    if (tt == STRING) {
      String tx = t.getText();
      int a = Memory.allocateString(tx);
      String st = String.valueOf(a);
      irt.setOp("MEM");
      irt.addSub(new IRTree("CONST", new IRTree(st)));
      return "string";
    }
    else {
      expression(ast, irt);
      return "int";
    }
  }

  public static void expression(CommonTree ast, IRTree irt)
  {
    IRTree irt1 = new IRTree(), irt2 = new IRTree();
    Token t = ast.getToken();
    int tt = t.getType();
    System.out.println(tokenNames[tt]);
    if (tt == INTNUM) {
      constant(ast, irt1);
      irt.setOp("CONST");
      irt.addSub(irt1);
    }
    else if (tt == IDENTIFIER) {
      String tx = t.getText();
      int a = Memory.allocateVariable(tx);
      String st = String.valueOf(a);
      irt.setOp("MEM");
      irt.addSub(new IRTree("CONST", new IRTree(st)));
    }
    else if (tt == SUM) {
      expression((CommonTree)ast.getChild(0), irt1);
      expression((CommonTree)ast.getChild(1), irt2);
      irt.setOp("SUM");
      irt.addSub(irt1);
      irt.addSub(irt2);
    }
    else if (tt == MINUS) {
      expression((CommonTree)ast.getChild(0), irt1);
      expression((CommonTree)ast.getChild(1), irt2);
      irt.setOp("MINUS");
      irt.addSub(irt1);
      irt.addSub(irt2);
    }

    else if (tt == MULT) {
      expression((CommonTree)ast.getChild(0), irt1);
      expression((CommonTree)ast.getChild(1), irt2);
      irt.setOp("MULT");
      irt.addSub(irt1);
      irt.addSub(irt2);
    }
    else if (tt == NOT) {
      expression((CommonTree)ast.getChild(0), irt1);
      irt.setOp("NOT");
      irt.addSub(irt1);
    }
    else if (tt == AND) {
      expression((CommonTree)ast.getChild(0), irt1);
      expression((CommonTree)ast.getChild(1), irt2);
      irt.setOp("AND");
      irt.addSub(irt1);
      irt.addSub(irt2);
    }
    else if (tt == FALSE || tt == TRUE) {
      constant(ast, irt1);
      irt.setOp("BOOL");
      irt.addSub(irt1);
    }
  }

  public static void constant(CommonTree ast, IRTree irt)
  {
    Token t = ast.getToken();
    int tt = t.getType();
    if (tt == INTNUM) {
      String tx = t.getText();
      // System.out.println(tx + " boo");
      irt.setOp(tx);
    }
    else if (tt == FALSE) {
      irt.setOp("0");
    }
    else if (tt == TRUE) {
      irt.setOp("1");
    }
    else {
      // System.out.println("constant");
      error(tt);
    }
  }

  private static void error(int tt)
  {
    System.out.println("IRT error: "+tokenNames[tt]);
    System.exit(1);
  }
}

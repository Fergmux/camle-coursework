// COMS22201: Memory allocation for strings

import java.util.*;
import java.io.*;
import java.nio.ByteBuffer ;



public class Memory {

  static ArrayList<Byte> memory = new ArrayList<Byte>();
  static HashMap<String, Integer> variable = new HashMap<String, Integer>();

  static public int allocateVariable(String text){
    int addr;
    if(variable.containsKey(text)){
      return variable.get(text);
    }
    else {
      while(memory.size() % 4 != 0){
        memory.add(new Byte("", 0));
      }
      addr = memory.size();
      variable.put(text, addr);

      for (int i=0; i<4; i++) {
        memory.add(new Byte(text, 0));
      }
    }
    return addr;
  }

  static public int allocateString(String text)
  {
    int addr = memory.size();
    int size = text.length();
    for (int i=0; i<size; i++) {
      memory.add(new Byte("", text.charAt(i)));
    }
    memory.add(new Byte("", 0));
    return addr;
  }

  // static public int allocateInt()
  // {
  //   int addr = memory1.size();
  //   for (int i=0; i<4; i++) {
  //     memory1.add(new Byte("", 0));
  //   }
  //   return addr;
  // }

  static public void dumpData(PrintStream o)
  {
    Byte b;
    String s;
    int c;
    int size = memory.size();
    for (int i=0; i<size; i++) {
      b = memory.get(i);
      c = b.getContents();
      if (c >= 32) {
        s = String.valueOf((char)c);
      }
      else {
        s = ""; // "\\"+String.valueOf(c);
      }
      o.println("DATA "+c+" ; "+s+" "+b.getName());
    }
  }
}

class Byte {
  String varname;
  int contents;

  Byte(String n, int c)
  {
    varname = n;
    contents = c;
  }

  String getName()
  {
    return varname;
  }

  int getContents()
  {
    return contents;
  }
}

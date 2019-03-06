import java.util.*;
import java.io.*;

public class USACO{
  private int R;
  private int C;
  private int E;
  private int N;
  public static int bronze(String filename){
return 1;
  }
  public static int silver(String filename){
    return 1;
  }

public USACO(String filename){
  try{
  File text = new File(filename);
  Scanner inf = new Scanner(text);
  String line = inf.nextLine();
  String temp = "";
  for (int i = 0; i < line.length(); i++){
    if (line.charAt(i) != ' '){
      temp+=line.charAt(i);
    }
  }
R = temp.charAt(0);
C = temp.charAt(1);
E = temp.charAt(2);
N = temp.charAt(3);
}
catch (FileNotFoundException e){};
}
}

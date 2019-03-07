import java.util.*;
import java.io.*;

public class USACO{
  private int R;
  private int C;
  private int E;
  private int N;
  private int[][] field;
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
  R = inf.nextInt();
  C = inf.nextInt();
  E = inf.nextInt();
  N = inf.nextInt();
  field = new int[R][C];
for (int r = 0; r < 4; r++){
  for (int c = 0; c < 6; c++){
field[r][c] = inf.nextInt();
  }

}

}
catch (FileNotFoundException e){};
}

public String toString(){
  String str = "";
  for (int r =0; r < R; r++){
    for (int c = 0; c < C; c++){
      str+= field[r][c]+ " ";
    }
    str+="\n";
  }
  return str;
}
public static void main(String[] args) {
  USACO test = new USACO("makelake.in");
System.out.println(test);

}
}

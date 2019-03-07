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
  R = inf.nextInt();
  C = inf.nextInt();
  E = inf.nextInt();
  N = inf.nextInt();

}
catch (FileNotFoundException e){};
}

public static void main(String[] args) {
  USACO test = new USACO("makelake.in");


}
}

import java.util.*;
import java.io.*;

public class USACO{
  public static int bronze(String filename){
    try{
    File text = new File(filename);
    Scanner inf = new Scanner(text);
    int R = inf.nextInt();
    int C = inf.nextInt();
    int E = inf.nextInt();
    int N = inf.nextInt();
    int[][] field = new int[R][C];
  for (int r = 0; r < field.length; r++){
    for (int c = 0; c < field[0].length; c++){
  field[r][c] = inf.nextInt();
    }
  }
  int[][] instructions = new int[N][3];
  for (int r = 0; r < instructions.length; r++){
    for (int c =0; c < instructions[0].length; c++){
      instructions[r][c] = inf.nextInt();
    }
  }
}
catch (FileNotFoundException e){};
return 1;
}





public static void main(String[] args) {
System.out.println(USACO.bronze("makelake.in"));

}
}

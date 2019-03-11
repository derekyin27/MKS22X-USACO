import java.util.*;
import java.io.*;

public class USACO{
  public static int bronze(String filename){
    try{
    File text = new File(filename);//read file
    Scanner inf = new Scanner(text);
    int R = inf.nextInt();// read rows, columns, elevation etc
    int C = inf.nextInt();
    int E = inf.nextInt();
    int N = inf.nextInt();
    int[][] field = new int[R][C];
  for (int r = 0; r < field.length; r++){//read lake
    for (int c = 0; c < field[0].length; c++){
  field[r][c] = inf.nextInt();
    }
  }
  int[][] instructions = new int[N][3];
  for (int r = 0; r < instructions.length; r++){
    for (int c =0; c < instructions[0].length; c++){//array for the instructions
      instructions[r][c] = inf.nextInt();
    }
  }
  int largest;
  for (int ct = 0; ct<instructions.length; ct++){
    largest = field[instructions[ct][0]][instructions[ct][1]];
    for (int r = instructions[ct][0]-1; r<instructions[ct][0]+2; r++){//goes through 3x3 grid to find the largest value
      for (int c = instructions[ct][1]-1; c<instructions[ct][1]+2; c++){
        if (field[r][c] > largest){
          largest = field[r][c];
        }
    }
  }
  int stomp = largest - instructions[ct][2];
  for (int r = instructions[ct][0]-1; r<instructions[ct][0]+2; r++){// stomps according to the largest value
    for (int c = instructions[ct][1]-1; c<instructions[ct][1]+2; c++){
      if (field[r][c] > stomp){
        field[r][c] = stomp;
      }
  }
}
}
int volume = 0;
for (int r = 0; r < R; r++){
  for (int c =0; c< C; c++){// finds volume using method given.
    if (field[r][c] < E){
      volume+=E-field[r][c];
    }
  }
}
return volume *72*72;
}
catch (FileNotFoundException e){System.out.println(e);
return -1;//bad case
}

}
public static int silver(String filename){
  try{
  File text = new File(filename);
  Scanner inf = new Scanner(text);// read file
  int N = inf.nextInt();
  int M = inf.nextInt();//read rows columns etc
  int T = inf.nextInt();
  char[][] field = new char[N][M];
  for (int r =0; r < field.length; r++){
    for (int c = 0; c <field[0].length; c++){
      field[r][c] = inf.nextChar();//read field into array
    }
  }
   int[] instructions = new int[4];
   for (int i = 0; i < 4; i++){
     instructions[i] = inf.nextInt();// place instructions into new array
   }
   int[][] news = new int [N][M];//create an old array and a new array. new array is updated every second for T seconds.
   int[][] old = new int [N][M];

   for (int r =0; r< N; r++){
     for (int c =0; c <M; c++){
       if (field[r][c]=='*'){// setting trees as -1
         news[r][c] = -1;
         old[r][c] = -1;
       }
       if (field[r][c] == '.'){//setting open pasture as 0
         news[r][c] =0;
         old[r][c] =0;
       }
     }
   }

   news[instructions[0]-1][instructions[1]-1] = 1;//setting movement as 1;

}




public static void main(String[] args) {

System.out.println(USACO.bronze("makelake.in"));

}
}

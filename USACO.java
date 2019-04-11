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
      //set up local variables
      File file = new File(filename);
      Scanner scanner = new Scanner(file);
      int N = Integer.parseInt(scanner.next());
      int M = Integer.parseInt(scanner.next());
      int T = Integer.parseInt(scanner.next());
      //initialize pasture.
      String nextline = scanner.nextLine();
      String[][] pasture =  new String[N][M];
      for (int r = 0; r < N; r++){
        nextline = scanner.nextLine();
        for (int c = 0; c < M; c++){
          pasture[r][c] = nextline.substring(c, c + 1);
        }
      }
      //instructions.
      int[] instr = new int[4];
      for (int i = 0; i < instr.length; i++) {
        instr[i] = scanner.nextInt();
      }
      //do instructions.
      int[][] newpasture = new int[N][M];
      int[][] oldpasture = new int[N][M];
      for (int r = 0; r < N; r++){
        for (int c = 0; c < M; c++){
          if (pasture[r][c].equals("*")){
            newpasture[r][c] = -1;
            oldpasture[r][c] = -1;
          }else{
            newpasture[r][c] = 0;
            oldpasture[r][c] = 0;
          }
        }
      }
      //testing purposes
      /*
      for (int x = 0; x < N; x++){
        for (int y = 0; y < M; y++){
          System.out.print(newpasture[x][y]);
        }
        System.out.println();
      }*/
      newpasture[instr[0] - 1][instr[1] - 1] = 1;
      for (int time = 0; time < T; time++){
        setEqual(newpasture, oldpasture);

        for (int r = 0; r < N; r++) {
          for (int c = 0; c < M; c++) {

            if (newpasture[r][c] != -1) {
              newpasture[r][c] = 0;

              if (c + 1 < M && newpasture[r][c + 1] >= 0) {
                newpasture[r][c] += oldpasture[r][c + 1];
              }

              if (c - 1 >= 0 && newpasture[r][c - 1] >= 0) {
                newpasture[r][c] += oldpasture[r][c - 1];
              }

              if (r - 1 >= 0 && newpasture[r - 1][c] >= 0) {
                newpasture[r][c] += oldpasture[r - 1][c];
              }

              if (r + 1 < N && newpasture[r + 1][c] >= 0) {
                newpasture[r][c] += oldpasture[r + 1][c];
              }
            }
          }
        }
      }
      return newpasture[instr[2] - 1][instr[3] - 1];
    }
    catch(FileNotFoundException e) {System.out.println("bad filename");return -100000;}
  }
  private static void setEqual(int[][] one, int[][] two){
      for (int r = 0; r < one.length; r++) {
        for (int c = 0; c < one[0].length; c++) {
          two[r][c] = one[r][c];
        }
      }
    }




public static void main(String[] args) {
System.out.println(USACO.silver("makelake.in"));
}
}

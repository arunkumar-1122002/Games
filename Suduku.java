import java.util.Random;
import java.util.Scanner;  
public class Suduku 
{
    static int boardSize=9;
    static int[][] playingBoard=new int[boardSize][boardSize];
    static int[][] AnswerBoard=new int[boardSize][boardSize];
    public static void main(String[] args)
     {
        Scanner inp=new Scanner(System.in);
        System.out.println("Enter difficulty:\n1.Easy\n2.medium\n3.Hard");
        int n=inp.nextInt();
        setFirstrow();  
        //set random values at top row
     createBoard(playingBoard,1,0);
     //create the solution board
     copyBoard(playingBoard);
     //copy the answer in new answerboard for further usage
     setDifficulty(n);
     //based on difficulty hide the no. of values in playing board
     printBoard(AnswerBoard); 
     System.out.println();
     printBoard(playingBoard);
     int hiddenValue=n*10;
     while(hiddenValue>0)
     {
        System.out.println("Enter row,col,value ...Ex:(1 1 8)");
        int row=inp.nextInt();
        int col=inp.nextInt();
        int value=inp.nextInt();
        if(AnswerBoard[row][col]==value && playingBoard[row][col]==0 )
        {
        playingBoard[row][col]=value;
        hiddenValue--;
        printBoard(playingBoard);
        System.out.println("You need to find "+hiddenValue+" more values.");
        }
        else
        {
            System.out.println("You Entered invalid value");
        }
     }
     System.out.println("Congrates You Won the Game");
    }
    private static void copyBoard(int[][] playingboard2) {
        for (int i = 0; i < boardSize; i++)
         {
            for (int j = 0; j <boardSize; j++) 
            {
                AnswerBoard[i][j]=playingBoard[i][j];
            }
        }
    }
    static void setDifficulty(int n)
    {
        Random rd=new Random();
        for (int i = 0; i < n*10; i++) 
        {
           int row=rd.nextInt(9);
           int col=rd.nextInt(9);
           if(playingBoard[row][col]!=0)
           {
            playingBoard[row][col]=0;
           }
            else
            {
            for (int j = 1; j < boardSize; j++) 
            {
                try{
                    if(playingBoard[row][col+j]!=0)
                    {
                 playingBoard[row][col+j]=0;
                 break; 
                }
                }
                catch(Exception e)
                {
                    row++;
                    col=0;
                }
            }
           }
        }
    }
    static void printBoard(int[][] Board)
    {
        System.out.println("    0   1   2   3   4   5   6   7   8");
        System.out.println("  _____________________________________");
        for (int i = 0; i < Board.length; i++) {
            System.out.print(i+" |");
           for (int j = 0; j < Board.length; j++)
            {
            if((j+1)%3==0)
            {
                System.out.print(" "+Board[i][j]+" |");
            }
            else
            System.out.print(" "+Board[i][j]+"  ");
           }
           if((i+1)%3==0)
           System.out.println("\n  |_____ _____|___________|___________|"); 
           else
           System.out.println();
        } 
    }
    static boolean createBoard(int[][] CurrentBoard,int row,int col)
{
      if(row==boardSize-1 && col==boardSize)
      {
        playingBoard=CurrentBoard;
           return true;
      }
      if(col==boardSize)
      {
      row++;
      col=0;
      }

      if (CurrentBoard[row][col] != 0)
	return createBoard(CurrentBoard, row, col + 1);

for (int i = 1; i < boardSize+1; i++) 
{
    if(isSafe(CurrentBoard,i,row,col))
    {
     CurrentBoard[row][col]=i;

     if(createBoard(CurrentBoard, row, col+1))
     return true;
     
    }
    CurrentBoard[row][col]=0;
          
   }
    return false;
}
public static boolean isSafe(int[][] currentBoard,int n,int row,int col) 
    {
        for (int i = 0; i < boardSize; i++) 
        {
         if(currentBoard[row][i]==n)
         return false;   
        }
        for (int j = 0; j < boardSize; j++)
         {
            if(currentBoard[j][col]==n)
            return false;
        }
        row=row-row%3;
        col=col-col%3;
        for (int i = 0; i < 3; i++)
        for (int j = 0; j < 3; j++)
            if (currentBoard[i + row][j + col] == n)
                return false;
        
        return true;
    }
    static void setFirstrow()
    {
        for (int i = 0; i <boardSize; i++)
         {
            playingBoard[0][i]=i+1;
        }
        Random rd=new Random();
        for(int i=0;i<boardSize;i++)
        {
            int random=rd.nextInt(boardSize-1);
            int temp=playingBoard[0][random];
            playingBoard[0][random]=playingBoard[0][random+1];
           playingBoard[0][random+1]=temp;
        }
    }
}

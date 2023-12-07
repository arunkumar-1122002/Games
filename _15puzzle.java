
package _15puzzle;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class _15puzzle {
 static Stack<String> stack=new Stack<>();  
static int[][] board=new int[4][4];
static int boardsize=board.length;
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        createboard();
        display();
        System.out.println("");
        shuffleboard();
        display();
        int[][] empty=find_empty();
        while(check_answer())
        {
            System.out.println("1.left\n2.right\n3.top\n4.down\n5.hint");
            int n=inp.nextInt();
            switch(n)
            {
                case 1:
                    empty=moveleft(empty);
                    display();
                    break;
                case 2:
                    empty=moveright(empty);
                    display();
                    break;
                case 3:
                    empty=movetop(empty);
                    display();
                    break;
                case 4:
                    empty=movedown(empty);
                    display();
                    break;
                case 5:
                    System.out.println("Go "+stack.peek());
                    break;
            }
        }
    }
    static boolean check_answer()
    {
        int valuegenerator=1;
        for (int i = 0; i < boardsize; i++)
        {
            for (int j = 0; j < boardsize; j++)
            {
                
                if(board[i][j]!=valuegenerator)
                    return true;
                valuegenerator++;
                
                if(valuegenerator==16)
                {
                    System.out.println("CONGRATES YOU WON THE GAME");
                    return false;
                }
                
            }
        }
        return false;
    }
    static void createboard(){
        int valuegenerator=1;
        for (int i = 0; i < boardsize; i++) {
            for (int j = 0; j < boardsize; j++) {
             board[i][j]=valuegenerator;
                valuegenerator++;
            }
            
        }
        board[3][3]=0;
    }
    static void shuffleboard()
    {
        int[][] empty={{3,3}};
        Random rd=new Random();
        for (int i = 0; i <15; i++) {
            int move=rd.nextInt(4);
            switch(move%4)
            {
                case 0:
                    if(empty[0][0]==0)
                    {
                        empty=movedown(empty);
                        stack.push("top");
                    }
                    else{
                    empty=movetop(empty);
                    stack.push("down");
                    }
                    break;
                case 1:
                    if(empty[0][0]==3)
                    {
                        empty=movetop(empty);
                        stack.push("down");
                    }
                    else
                    {
                    empty=movedown(empty);
                    stack.push("top");
                    }
                    break;
                case 2:
                    if(empty[0][1]==0)
                    {
                        empty=moveright(empty);
                        stack.push("left");
                    }
                    else
                    {
                    empty=moveleft(empty);
                    stack.push("right");
                    }
                    break;
                case 3:
                    if(empty[0][1]==3)
                    {
                        empty=moveleft(empty);
                        stack.push("right");
                    }
                    else
                    {
                    empty=moveright(empty);
                    stack.push("left");
                    }break;
            }
        }
    }
    static void display()
    {
        for (int i = 0; i < boardsize; i++) {
            System.out.print("|");
            for (int j = 0; j < boardsize; j++) {
                int value=board[i][j];
                if(value==0)
                {
                    System.out.print(" "+' '+"  |");
                continue;
                }
                if(value<10)
                System.out.print(" "+value+"  |");
                else
                    System.out.print(" "+value+" |");
                
            }
            System.out.println();
            
        }
    }
    static int[][] movetop(int[][] empty)
    {
        int row=empty[0][0];
        int col=empty[0][1];
        if(row==0)
        {
            System.out.println("You cannot move up...invalid move");
        }
        else
        {
            stack.push("down");
         int temp=board[row][col];
         board[row][col]=board[row-1][col];
         board[row-1][col]=temp;
         return new int[][]{{row-1,col}};
         
        }
        return empty;
    }
    static int[][] moveleft(int[][] empty)
    {
        int row=empty[0][0];
        int col=empty[0][1];
        if(col==0)
        {
            System.out.println("You cannot move left...invalid move");
        }
        else
        {
            stack.push("right");
         int temp=board[row][col];
         board[row][col]=board[row][col-1];
         board[row][col-1]=temp;
         return new int[][]{{row,col-1}};
        }
        
        return empty;
    }
    static int[][] moveright(int[][] empty)
    {
        int row=empty[0][0];
        int col=empty[0][1];
        if(col==3)
        {
            System.out.println("You cannot move right...invalid move");
        }
        else
        {
            stack.push("left");
         int temp=board[row][col];
         board[row][col]=board[row][col+1];
         board[row][col+1]=temp;
         return new int[][]{{row,col+1}};
        }
       return empty; 
        
    }
    static int[][] movedown(int[][] empty)
    {
        int row=empty[0][0];
        int col=empty[0][1];
        if(row==3)
        {
            System.out.println("You cannot move down...invalid move");
        }
        else
        {
            stack.push("top");
         int temp=board[row][col];
         board[row][col]=board[row+1][col];
         board[row+1][col]=temp;
         return new int[][]{{row+1,col}};
        }
     return empty;   
    }
    static int[][] find_empty()
    {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j]==0)
                    return new int[][]{{i,j}};
                
            }
            
        }
        return new int[0][0];//This return never work...because our board always have 0
    }
}

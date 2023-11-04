
package tictactoe;

import java.util.Scanner;


public class Tictactoe {
    public boolean check(char[][] arr)
    {
     if(arr[0][0]!='\0' && (arr[0][0]==arr[0][1]) && (arr[0][1]==arr[0][2]))
     {
         System.out.println(arr[0][0]+" WIN THE MATCH");
         return false;
     }
     if(arr[1][0]!='\0' &&(arr[1][0]==arr[1][1]) && (arr[1][1]==arr[1][2]))
     {
         System.out.println(arr[1][0]+" WIN THE MATCH");
         return false;
     }
     if(arr[2][0]!='\0' &&(arr[2][0]==arr[2][1]) && (arr[2][1]==arr[2][2]))
     {
         System.out.println(arr[2][0]+" WIN THE MATCH");
         return false;
     }
     if(arr[0][0]!='\0' &&(arr[0][0]==arr[1][0]) && (arr[0][1]==arr[2][0]))
     {
         System.out.println(arr[0][0]+" WIN THE MATCH");
         return false;
     }
     if(arr[0][1]!='\0' &&(arr[0][1]==arr[1][1]) && (arr[1][1]==arr[2][1]))
     {
         System.out.println(arr[0][1]+" WIN THE MATCH");
         return false;
     }if(arr[0][2]!='\0' &&(arr[0][2]==arr[1][2]) && (arr[1][2]==arr[2][2]))
     {
         System.out.println(arr[0][2]+" WIN THE MATCH");
         return false;
     }
     if(arr[0][0]!='\0' &&(arr[0][0]==arr[1][1]) && (arr[1][1]==arr[2][2]))
     {
         System.out.println(arr[0][0]+" WIN THE MATCH");
         return false;
     }
     if(arr[0][2]!='\0' &&(arr[0][2]==arr[1][1]) && (arr[1][1]==arr[2][0]))
     {
         System.out.println(arr[0][2]+" WIN THE MATCH");
         return false;
     }
     
        return true;
    }
    public void display(char[][] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print("|");
            for(int j=0;j<arr.length;j++)
            {
                if(arr[i][j]=='X' || arr[i][j]=='O')
                {
                    System.out.print(arr[i][j]+"|");
                }
                else
                {
                    System.out.print(" |");
                }
            }
            System.out.println();
            
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Tictactoe zz=new Tictactoe();
        char[][] arr=new char[3][3];
        int count=1;
        
        while(zz.check(arr))
        {
            System.out.println((count%2==0)?"O turn":"X turn");
            int x=in.nextInt();
            int y=in.nextInt();
            if(arr[x][y]=='\0')
            {
            arr[x][y]=(count%2==0)?'O':'X';
            count++;
            }else
                System.out.println("invalid move");
            zz.display(arr);
            if(count==9)
            {
                System.out.println("MATCH DRAW");
                break;
            }
        }
                
            
    }
    
}

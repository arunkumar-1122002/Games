/* console based snake and ladder game

  instructions:
  1.put number of players first
  2.press enter to roll the dice
  3.you get value between 1 to 6
  4.if your current position + dice value is more than 100 it show unable to move
  5.it has ladder to go up and snake to go down functions
  6.in every dice roll it check the posistion,if any one reached destination it announce the winner and stop the loop.
  7.I hope you enjoy the game.
                                     by
                                     Arun Kumar
  */
package snakeand.ladder;
import java.util.Random;
import java.util.Scanner;
public class SnakeandLadder {
    Scanner in=new Scanner(System.in);
    int n=in.nextInt();
   int[] arr=new int[n];
    public boolean check()
    {
        for(int i=0;i<n;i++)
        {
            if(arr[i]==100)
            {
                System.out.println("Player "+(i+1) +" won the game");
                return false;
            }
        }
        return true;
    }
    public void snake()
    {
        System.out.println();
         System.out.println("SUMMARY:");
         System.out.println();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==29)
            {
                arr[i]=9;
                System.out.println("Snake bites player "+(i+1));
            }
            else if(arr[i]==38)
            {
                arr[i]=15;
                System.out.println("Snake bites player "+(i+1));
            }
            else if(arr[i]==47)
            {
                arr[i]=5;
                System.out.println("Snake bites player "+(i+1));
            }
            else if(arr[i]==53)
            {
                arr[i]=33;
                System.out.println("Snake bites player "+(i+1));
            }
            else if(arr[i]==62)
            {
                arr[i]=37;
                System.out.println("Snake bites player "+(i+1));
            }else if(arr[i]==86)
            {
                arr[i]=54;
                System.out.println("Snake bites player "+(i+1));
            }else if(arr[i]==86)
            {
                arr[i]=54;
                System.out.println("Snake bites player "+(i+1));
            }else if(arr[i]==92)
            {
                arr[i]=70;
                System.out.println("Snake bites player "+(i+1));
            }
            else if(arr[i]==97)
            {
                arr[i]=25;
                System.out.println("Snake bites player "+(i+1));
            }
   
    }
    }
    public void ladder()
    {
        
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==2)
            {
                arr[i]=23;
                System.out.println("player "+(i+1)+" picks ladder");
            }
            else if(arr[i]==8)
            {
                arr[i]=34;
                System.out.println("player "+(i+1)+" picks ladder");
            }
            else if(arr[i]==47)
            {
                arr[i]=5;
                System.out.println("player "+(i+1)+" picks ladder");
            }
            else if(arr[i]==20)
            {
                arr[i]=77;
                System.out.println("player "+(i+1)+" picks ladder");
            }
            else if(arr[i]==32)
            {
                arr[i]=68;
                System.out.println("player "+(i+1)+" picks ladder");
            }else if(arr[i]==41)
            {
                arr[i]=79;
                System.out.println("player "+(i+1)+" picks ladder");
            }else if(arr[i]==74)
            {
                arr[i]=88;
                System.out.println("player "+(i+1)+" picks ladder");
            }else if(arr[i]==85)
            {
                arr[i]=95;
                System.out.println("player "+(i+1)+" picks ladder");
            }
            else if(arr[i]==82)
            {
                arr[i]=99;
                System.out.println("player "+(i+1)+" picks ladder");
            }
        }
    }
    public void display()
    {
       
       for(int i=0;i<n;i++)
       {
           System.out.println("player "+(i+1)+" : "+arr[i]);
       }
        System.out.println();
    }
    
    public static void main(String[] args) {
       
        System.out.println("Enter number of players:");
       Scanner inp=new Scanner(System.in);
        Random random=new Random();
        SnakeandLadder sl=new SnakeandLadder();
int player=0;
while(sl.check())
{
    if(player==sl.n)
    {
        sl.snake();
        sl.ladder();
        sl.display();
        player=0;
    }
     int dice=random.nextInt(5);
     System.out.print("press Enter ");
     inp.nextLine();
     System.out.println("PLAYER "+(player+1)+" GOT "+dice);
     if(sl.arr[player]+dice <=100)
     {
   sl.arr[player]+=dice; 
     }
     else{
         System.out.println("you got more than 100.... unable to move");
     }
   player++;
}
   
    }
    
}

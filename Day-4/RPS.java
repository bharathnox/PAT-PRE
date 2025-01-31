// input will be num of times the game played, and a string like 2games-"rockpaperpaperrock"
//should return victories of and A and B

import java.util.Scanner;

public class RPS {

    public static int j = 0;
    public static int start;
    public static int ascore = 0;
    public static int bscore = 0;

    public static String move(String str) {
        start = j;
        char ch = str.charAt(j);
        if(ch == 'r') {
            j+=4;
        }
        if (ch == 'p') {
            j+=5;
        }
        if (ch == 's') {
            j+=7;
        }
        int end = j;
        return str.substring(start, end);
    }

    public static void score(String amove, String bmove) {
        if(amove.equals("rock")) {
            if(bmove.equals("rock")) {
                
            } else if(bmove.equals("paper")) {
                bscore++;
            } else if(bmove.equals("scissor")) {
                ascore++;
            } else {
                System.out.println("Invalid move by B!!");
                return;
            } 
        }
        if(amove.equals("paper")) {
            if(bmove.equals("rock")) {
                ascore++;
            } else if(bmove.equals("paper")) {
                
            } else if(bmove.equals("scissor")) {
                bscore++;
            } else {
                System.out.println("Invalid move by B!!");
                return;
            }
        }
        if(amove.equals("scissor")){
            if(bmove.equals("rock")) {
                bscore++;
            } else if(bmove.equals("paper")) {
                ascore++;
            } else if(bmove.equals("scissor")) {
                
            } else {
                System.out.println("Invalid move by B!!");
                return;
            }
        }
        System.out.println("Invalid move by A!!");
        return;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        str = str.toLowerCase();


        for(int i=1; i<=n; i++) {
            String amove = move(str);
            String bmove = move(str);
            score(amove, bmove);
        }

        if(ascore>bscore) {
            System.out.println("A has won with score: " + ascore);
        } else if (bscore>ascore) {
            System.out.println("B has won with score: " + bscore);
        } else {
            System.out.println("Draw match with score: "+ascore);
        }

    }
}
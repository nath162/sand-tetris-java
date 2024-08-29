import java.util.Scanner;


public class testV2{
    public static void main(String[] args){
        System.out.println(dowanttoplay());
    }

    private static boolean dowanttoplay() {
        Scanner asktoplay = new Scanner(System.in);
        System.err.println("do you want to play ?");
        String answer = asktoplay.nextLine();
        boolean play = !answer.equals("n");
        asktoplay.close();
        return play;
    }
}

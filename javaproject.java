
import java.util.HashMap;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class javaproject {

    public static void main(String[] argument) {// la méthode principale ou on créer toutes les variables
        String[][] grid = {
            {"-", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "-"},
            {"-", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "-"},
            {"-", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "-"},
            {"-", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "-"},
            {"-", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "-"},
            {"-", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "-"},
            {"-", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "-"},
            {"-", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "-"},
            {"-", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "-"},
            {"-", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "-"},
            {"-", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "-"},
            {"-", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "-"},
            {"-", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "-"},
            {"-", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "-"},
            {"-", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "-"},
            {"-", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "-"},
            {"-", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "-"},
            {"-", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "-"},
            {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}};
        //il faut loop dans l'array pour l'imprimer
        HashMap<Integer, String[][]> block = new HashMap<>();
        //the 7 blocks who will be choosen randomly
        block.put(0, new String[][]{{"+", "+", "+", "+"}});
        block.put(1, new String[][]{{"+", "*", "*"}, {"+", "+", "+"}});
        block.put(2, new String[][]{{"*", "*", "+"}, {"+", "+", "+"}});
        block.put(3, new String[][]{{"+", "+"}, {"+", "+"}});
        block.put(4, new String[][]{{"+", "+", "*"}, {"*", "+", "+"}});
        block.put(5, new String[][]{{"*", "+", "*"}, {"+", "+", "+"}});
        block.put(6, new String[][]{{"*", "+", "+"}, {"+", "+", "*"}});
    }

    public static String[][] chooseblock(HashMap<Integer, String[][]> dic) {
        int randomnum = (int) (Math.random() * 8);
        return dic.get(randomnum);
    }

    public static String[][] makeblockappear(String[][] grid, HashMap dic) {//mettre en argument la grid et la fonction chooseblock
        int count = 0;
        String[][] block = chooseblock(dic);//choisi block
        for (int i = 0; i < block.length; i++) {
            for (int j = 0; j < block[i].length; i++) {
                grid[i][3 + count] = block[i][j];
                count += 1;
            }
        }
        return grid;
    }

    public static void Time(String[][] grid) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                updategrid(grid);
            }
        }, 0, 1000);
    }

    public static void displaygrid(String grid[][]) {
        int previous = 0;
        for (int i = 0; i < grid.length; i++) {
            for (String item : grid[i]) {
                if (i != previous) {
                    System.out.println(item);
                } else {
                    System.out.print(item);
                }
            }
            previous = i;
        }
    }

    public static void updategrid(String[][] grid) {
        displaygrid(checkcollision(grid));
    }

    public static String[][] checkcollision(String[][] grid) {
        //check la colision des block et trouve nouvelle pos et return la nouvelle grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; i < grid.length; j++) {
                if (grid[i][j].equals("+")) {
                    if (grid[i + 1][j] != "-" && grid[i + 1][j] != "+") {
                        grid[i][j] = "*";
                        grid[i + 1][j] = "+";
                    }
                }
            }
        }
        return grid;
    }

    public static boolean asktoplay(String[][] grid) {
        boolean play = false;
        Scanner wanttoplay = new Scanner(System.in);
        System.out.println("do you want to play o/n ?");
        String anwser = wanttoplay.nextLine();
        if (anwser.equals("O")) {
            play = true;
            return play;
        }
        wanttoplay.close();
        return play;
    }

    public static void userinput(boolean cangoright, boolean cangoleft, boolean canrotate) {
        //read system input ddes fleche pour rotate c'est la fleche du haut ou du bas 
    }
}

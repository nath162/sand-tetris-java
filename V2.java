
import java.util.HashMap;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class V2 {

    public static void gameloop() {//fonction qui appellra toute les autres fonction et c'est le bordèle
        creategrid();
        System.out.println("to quit press 'n'");
        while (dowanttoplay()) {//il faut créer c'est bool dans want to play
            //if (isblockblocked());
            //{
            //makeblockappear(updategrid(), chooseblock(createblockHashMap())); en commentaire car il faut mettre les valeurs demander dans updategrid
            //posoftheblock(updategrid()); en commentaire car il faut mettre les valeurs demander dans updategrid
            //}
            executeeverysecond();//appel la fonction update grid
        }
    }

    public static String[][] creategrid() {//fini
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
        return grid;
    }

    public static HashMap<Integer, String[][]> createblockHashMap() {//fini 
        HashMap<Integer, String[][]> blocks = new HashMap<>();
        blocks.put(0, new String[][]{{"+", "+", "+", "+"}});
        blocks.put(1, new String[][]{{"+", "*", "*"}, {"+", "+", "+"}});
        blocks.put(2, new String[][]{{"*", "*", "+"}, {"+", "+", "+"}});
        blocks.put(3, new String[][]{{"+", "+"}, {"+", "+"}});
        blocks.put(4, new String[][]{{"+", "+", "*"}, {"*", "+", "+"}});
        blocks.put(5, new String[][]{{"*", "+", "*"}, {"+", "+", "+"}});
        blocks.put(6, new String[][]{{"*", "+", "+"}, {"+", "+", "*"}});
        return blocks;
    }

    public static String[][] chooseblock(HashMap<Integer, String[][]> blockshashmap) {//fini
        String[][] choosenblock = blockshashmap.get((int) (Math.random() * 8));
        return choosenblock;
    }

    public static boolean dowanttoplay() {//fini
        Scanner asktoplay = new Scanner(System.in);
        boolean play = !asktoplay.equals("n");
        return play;
    }

    public static boolean isblockblocked(HashMap posoftheblock) {//pas fini, mais il faut la fonction pos of the block
        boolean blockblocked = false;
        //savoir si il peut aller en bas a droite ou a gauche
        return blockblocked;
    }

    public static String[][] makeblockappear(String[][] grid, String[][] block) {//fini
        for (int i = 0; i < block.length; i++) {
            for (int j = 4; j < block[i].length; j++) {
                grid[i][j] = block[i][j - 4];
            }
        }
        return grid;
    }

    public static HashMap posoftheblock(String[][] grid) {//fini
        HashMap posblock = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].equals("+")) {
                    posblock.put(i, j);
                }
            }
        }
        return posblock; //ne doit etre appeler que a l'apparition du block et puis doit etre update dans les autres fonctions pour pas devoir la rappeler et créer des erreurs
    }

    public static String[][] updategrid(String[][] grid, HashMap posblock, boolean rotate, boolean cangoright, boolean cangoleft) {//pas fini du tout
        switch (userinput()) {
            case 'r':
                if (cangoright) {
                    //faire en sorte qu'il va a droite
                }
                break;
            case 'l':
                if (cangoleft) {
                    //faire en sorte qu'il va a gauche
                }
                break;
            case 'o':
                if (rotate) {
                    //faire en sorte qu'il rotate
                }
                break;
            case 'n':
                //juste passer  
                break;
        }
        return grid;
    }//fonction qui descend le block fonction timer(chaque seconde) + fonction userinput(bouge le block si user clicker ou le fait rotate)

    public static void executeeverysecond() {//pas fini
        Timer timer = new Timer();
        int start_repeat = 1000;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //updategrid(grid, posblock);
            }
        }, start_repeat, start_repeat);
    }

    public static char userinput() {//fini
        Scanner usrinput = new Scanner(System.in);
        char input;
        if (usrinput.equals("d")) {
            input = 'r';
        } else if (usrinput.equals("q")) {
            input = 'l';
        } else if (usrinput.equals("s") || usrinput.equals("z")) {//rotate
            input = 'o';
        } else {
            input = 'n';
        }
        return input;
    }

    public static boolean canrotate(HashMap posoftheblock, String[][] grid) {
        //le code si j'arrive a passer les arguments
        return false;
    }
}

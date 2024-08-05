
import java.util.HashMap;
import java.util.Scanner;

class V2 {

    public static void gameloop() {//fonction qui appellra toute les autres fonction
        creategrid();
        while (dowanttoplay()) {//il faut créer c'est bool dans want to play
            if (isblockblocked());
            {
                //makeblockappear(updategrid(), chooseblock(createblockHashMap())); en commentaire car il faut mettre les valeurs demander dans updategrid
                //posoftheblock(updategrid()); en commentaire car il faut mettre les valeurs demander dans updategrid
            }
        }
    }

    public static String[][] creategrid() {
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

    public static HashMap<Integer, String[][]> createblockHashMap() {
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

    public static String[][] chooseblock(HashMap<Integer, String[][]> blockshashmap) {
        String[][] choosenblock = blockshashmap.get((int) (Math.random() * 8));
        return choosenblock;
    }

    public static boolean dowanttoplay() {
        Scanner usrinput = new Scanner(System.in);
        boolean play = !usrinput.equals("n");
        return play;
    }

    public static boolean isblockblocked() {
        boolean blockblocked = false;
        //faire en sorte de savoir si le block est bloquer
        return blockblocked;
    }

    public static String[][] makeblockappear(String[][] grid, String[][] block) {//faut voir mainteanant comment les faires passer en argument
        for (int i = 0; i < block.length; i++) {
            for (int j = 4; j < block[i].length; j++) {
                grid[i][j] = block[i][j - 4];
            }
        }
        return grid;
    }

    public static HashMap posoftheblock(String[][] grid) {
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

    public static String[][] updategrid(String[][] grid, HashMap posblock) {
        return grid;
    }//fonction qui descend le block fonction timer(chaque seconde) + fonction userinput(bouge le block si user clicker ou le fait rotate)
}

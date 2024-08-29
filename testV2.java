import java.util.HashMap;

public class testV2{
    public static void main(String[] args){
        System.out.println(isblockblocked(posoftheblock(creategrid()), creategrid()));
    }
    public static String[][] creategrid() {//fini
        String[][] grid = {
            {"-", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "-"},
            {"-", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "-"},
            {"-", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "-"},
            {"-", "*", "*", "*", "+", "+", "+", "*", "*", "*", "*", "-"},
            {"-", "*", "*", "*", "+", "*", "*", "*", "*", "*", "*", "-"},
            {"-", "+", "+", "+", "+", "+", "+", "*", "*", "*", "*", "-"},
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
    public static boolean isblockblocked(HashMap posoftheblock, String[][] grid) {//pas fini, mais il faut la fonction pos of the block
        boolean blockblocked = false;
        int[][] posofchar = null;
        for (Object i : posoftheblock.entrySet()) {
            posofchar[0][0] = (int) i - 1;
            posofchar[1][0] = ((int) posoftheblock.get(i));
            if (grid[posofchar[0][0]][posofchar[1][0]] != "*") {
                blockblocked = true;
            }
        }
        return blockblocked;
    }
    public static HashMap posoftheblock(String[][] grid) {//risque de bug
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
}

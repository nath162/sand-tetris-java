import java.util.HashMap;

public class testV2{
    public static void main(String[] args){
        
    }
    public static String[][] makeblockappear(String[][] grid, String[][] block) {//fini
        for (int i = 0; i < block.length; i++) {
            for (int j = 4; j < block[i].length; j++) {
                grid[i][j] = block[i][j - 4];
            }
        }
        return grid;
    }
}

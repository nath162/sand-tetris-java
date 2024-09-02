import java.util.HashMap;

public class testV2{
    public static void main(String[] args){
        displaygid(makeblockappear(creategrid(), chooseblock(createblockHashMap())));
    }
    public static String[][] makeblockappear(String[][] grid, String[][] block) {//fini
        for (int i = 0; i < block.length; i++) {
            for (int j = 4; j < block[i].length; j++) {
                grid[i][j] = "+";
            }
        }
        return grid;
    }
    public static String[][] chooseblock(HashMap<Integer, String[][]> blockshashmap) {//fini
        String[][] choosenblock = blockshashmap.get((int) (Math.random() * 8));
        return choosenblock;
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
    public static void displaygid(String[][] grid) {
        int count = 0;
        int pre = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                if (pre != i || count ==0) {
                    count +=1;
                    System.out.println(" ");
                    System.out.print("-");
                    System.out.print(grid[i][j]);
                } else {
                    System.out.print(grid[i][j]);
                }
                pre = i;
            }
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
}

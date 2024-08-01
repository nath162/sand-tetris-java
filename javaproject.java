
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
    //attention a cette fonction
    public static String[][] checkcollision(String[][] grid) {
        HashMap<String[][],String[][]> modifiedblock = new HashMap()<>;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; i < grid.length; j++) {
                if (grid[i][j].equals("+")) {
                    if (grid[i][j+1] != "-" && grid[i][j+1] != "+" && /* n'est pas dans la hasmap*/) {
                        modifiedblock.put(String[][] grid[i][j+1],String[][] grid[i][j+1]);
                        grid[i][j] = "*";
                        grid[i][j+1] = "+";//attention si le block est compose de plusieur etages alors le block ne va pas bien descendre
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
        goright = false;
        rotate = false;
        goleft = false;
        Scanner inputu = new Scanner(System.in);
        if(inputu.equals("d") && cangoright){
            goright = true;
        }
        if(inputu.equals("q")&& cangoleft){
            goleft = true;
        }
        if(inputu.equals("z") || inputu.equals("s") && canrotate){
            rotate = true;
        }
        if(inputu.equals("e")){
            inuptu.close();//et cree une bool want to play qui sera mit a false   
        }        
    }
    //attention a cette fonction 
    public static void checkrightandleft(String[][] grid){
        cangoright = false;
        cangoleft = false;
        canrotate = false;
         for (int i = 0; i < grid.length; i++) {
            for (int j = 0; i < grid.length; j++) {
                if (grid[i][j].equals("+")) {
                    if(grid[i-1][j] != "-" && grid[i-1][j] != "+"){
                        cangoleft = true;//ca va marcher pour la gauche car la for loop va d'abors s'occuper des premiers elemnt mais pas pour la droite
                    }
                    if(grid[-i+1][j] != "-" && grid[-i+1][j] != "+"){
                        cangoright = true;//les minus sont fait en sorte pour que sa aille de l'autre cote
                    }//la can rotate method est a faire apre car je ne sais pas comment la fair epour l'instant
                }
            }
        }
    }
    public static void movement(String[][] grid,boolean goright,boolean goleft,boolean rotate){
        //deplacer le block
    }
}

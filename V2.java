
import java.util.HashMap;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Map;

class V2 {
    //a debuger
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
        System.err.println("do you want to play ?");
        String answer = asktoplay.nextLine();
        boolean play = !answer.equals("n");
        asktoplay.close();
        return play;
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

    public static String[][] makeblockappear(String[][] grid, String[][] block) {//fini
        for (int i = 0; i < block.length; i++) {
            for (int j = 4; j < block[i].length; j++) {
                grid[i][j] = block[i][j - 4];
            }
        }
        return grid;
    }

    public static HashMap posoftheblock(String[][] grid) {//risque de bug
        int[] listuniquekeys = {0,1,2,3};
        int count = 0;//pointer pour la liste qui sert a avoir des clés unique pour les pos de block
        HashMap posblock = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].equals("+") && count < listuniquekeys.length) {
                    int[] possingleblock = {i,j};// i ou j ne peuvent pas étre une key car plusieur blocke peuvent avoir le meme i ou j
                    posblock.put(listuniquekeys[count],possingleblock);
                    count+=1;
                }
                else{
                    continue;
                }
            }
        }
        return posblock; //ne doit etre appeler que a l'apparition du block et puis doit etre update dans les autres fonctions pour pas devoir la rappeler et créer des erreurs
    }

    public static void updategrid(String[][] grid, HashMap posblock, boolean rotate, HashMap cangoleftorright, HashMap cangoleftright) {//pas fini du tout
        //fonction qui descend le block fonction timer(chaque seconde) + fonction userinput(bouge le block si user clicker ou le fait rotate)
        switch (userinput()) {
            case 'r':
                if (cangoleftright.get("cangoright").equals(true)) {
                    for (Map.Entry<Integer, Integer> entry : posblock.entrySet()) {
                        //pos block n'a pas été passer en argument c'est pour sa que sa retourne faux
                        entry.setValue(entry.getValue() + 1);
                    }
                }
                break;
            case 'l':
                if (cangoleftright.get("cangoleft").equals(true)) {
                    for (Map.Entry<Integer, Integer> entry : posblock.entrySet()) {
                        //pos block n'a pas été passer en argument c'est pour sa que sa retourne faux
                        entry.setValue(entry.getValue() - 1);
                    }
                }
                break;
            case 'o':
                if (canrotate(posblock, grid)) {
                    //faire en sorte qu'il rotate
                }
                break;
            case 'n':
                //juste passer  
                break;
        }
        //puis update la grid
        for (Object i : posblock.entrySet()) {
            grid[(int) i][(int) posblock.get(i)] = "+";
        }
        //et finalement la display
        displaygid(grid);
    }

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
            usrinput.close();
        }
        return input;
    }

    public static boolean canrotate(HashMap posoftheblock, String[][] grid) {//manque plus que checker les alentours du block
        /*
        faire en sorte que le block soit une string 2 dimension pour pouvoir trouver le point du milieu du bloque 3*3 de collision puis
        regarder a partir des positions dans la hasmap pos of the block ou est le milieu et si le block sont dispo
         */
        String[][] block = {{}, {}};
        int temp = 0;
        int count = 0;
        int supcount = 0;
        for (Object i : posoftheblock.entrySet()) {
            if (temp != (int) posoftheblock.get(i) && temp != 0) {
                temp += 1;
                supcount = count;
            }
            block[0 + temp][0 + count - supcount] = "+";
            count += 1;
            temp = (int) posoftheblock.get(i);
        }
        int mid = 0;
        int mid2 = 0;
        if (block.length > 2) {
            mid = block.length / 2;
        } else {
            mid = 0;
        }
        if (block[1].length > 2) {
            mid2 = block[1].length / 2;
        } else {
            mid2 = 0;
        }
        for (Object i : posoftheblock.entrySet()) {
            int posmidy = (int) i + mid2;
            int posmidx = (int) posoftheblock.get(i) + mid;
        }
        if (grid[posmidy + 1][posmidx].equals("*") || posoftheblock.containsKey(posmidy + 1) && posoftheblock.containsValue(posmidx)) {//en haut
            if (grid[posmidy + 1][posmidx + 1].equals("*") || posoftheblock.containsKey(posmidy + 1) && posoftheblock.containsValue(posmidx + 1)) {//haut droite
                if (grid[posmidy][posmidx + 1].equals("*") || posoftheblock.containsKey(posmidy) && posoftheblock.containsValue(posmidx + 1)) {//milieu droite
                    if (grid[posmidy - 1][posmidx + 1].equals("*") || posoftheblock.containsKey(posmidy - 1) && posoftheblock.containsValue(posmidx + 1)) {//bas droite
                        if (grid[posmidy - 1][posmidx].equals("*") || posoftheblock.containsKey(posmidy - 1) && posoftheblock.containsValue(posmidx)) {//bas milieu
                            if (grid[posmidy - 1][posmidx - 1].equals("*") || posoftheblock.containsKey(posmidy - 1) && posoftheblock.containsValue(posmidx - 1)) {
                                ///bas gauche
                                if (grid[posmidy][posmidx - 1].equals("*") || posoftheblock.containsKey(posmidy) && posoftheblock.containsValue(posmidx - 1)) {//milieu gauche
                                    if (grid[posmidy + 1][posmidx - 1].equals("*") || posoftheblock.containsKey(posmidy + 1) && posoftheblock.containsValue(posmidx - 1)) {//haut gauche
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void displaygid(String[][] grid) {
        int pre = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (pre != i) {
                    System.out.println(grid[i][j]);
                } else {
                    System.out.print(grid[i][j]);
                }
                pre = i;
            }
        }
    }

    public HashMap checkleftandright(String[][] grid, HashMap posofblock) {
        HashMap cangowere = new HashMap<>();
        for (Object i : posofblock.entrySet()) {
            if (grid[(int) i][(int) posofblock.get(i) + 1] != "*") {
                cangowere.put("cangoright", false);
            } else {
                cangowere.put("cangoright", true);
            }
            if (grid[(int) i][(int) posofblock.get(i) - 1] != "*") {
                cangowere.put("cangoleft", false);
            } else {
                cangowere.put("cangoleft", true);
            }
        }
        return cangowere;
    }
    //a debuger
    public static void destroylines(String[][] grid) {//probleme les elements en haut ne descende pas ducoup aprés que la ligne soit détruite
        int pre = 0;
        boolean destroyline = true;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; i < grid[i].length; j++) {
                if (pre != i) {
                    pre = i;
                    if (destroyline) {
                        for (int l = 0; l < grid[i].length; l++) {
                            grid[i][l] = "*";
                        }
                    }
                    destroyline = true;
                }
                if (grid[i][j].equals("*")) {
                    destroyline = false;
                }
            }
        }
    }
}

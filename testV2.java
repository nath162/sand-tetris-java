import java.util.HashMap;

public class testV2{
    public static void main(String[] args){
        
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
}

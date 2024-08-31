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
            {"-", "+", "+", "*", "*", "*", "*", "*", "*", "*", "*", "-"},
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
    public static boolean isblockblocked(HashMap<Integer,int[]> posoftheblock, String[][] grid) {//pas fini, mais il faut la fonction pos of the block
        boolean blockblocked = false;
        for(int[] i : posoftheblock.values()){//i est l'objet avec la key,value
            if(grid[i[0]+1][i[1]].equals("+") || grid[i[0]+1][i[1]].equals("-")){
                blockblocked =true;
                for(int[] j : posoftheblock.values()){
                    if((j[0] == i[0]+1) && (j[1] == i[1])){
                        blockblocked = false;
                        break;
                    }
                    else{
                        blockblocked = true;
                    }
                }
            }
        }
        return blockblocked;
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
}

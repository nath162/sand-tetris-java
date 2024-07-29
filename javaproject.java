import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
class javaproject{
    public static void main(String[] argument){// la méthode principale ou on créer toutes les variables
        String[][] grid = {
            {"-","*","*","*","*","*","*","*","*","*","*","-"},
            {"-","*","*","*","*","*","*","*","*","*","*","-"},
            {"-","*","*","*","*","*","*","*","*","*","*","-"},
            {"-","*","*","*","*","*","*","*","*","*","*","-"},
            {"-","*","*","*","*","*","*","*","*","*","*","-"},
            {"-","*","*","*","*","*","*","*","*","*","*","-"},
            {"-","*","*","*","*","*","*","*","*","*","*","-"},
            {"-","*","*","*","*","*","*","*","*","*","*","-"},
            {"-","*","*","*","*","*","*","*","*","*","*","-"},
            {"-","*","*","*","*","*","*","*","*","*","*","-"},
            {"-","*","*","*","*","*","*","*","*","*","*","-"},
            {"-","*","*","*","*","*","*","*","*","*","*","-"},
            {"-","*","*","*","*","*","*","*","*","*","*","-"},
            {"-","*","*","*","*","*","*","*","*","*","*","-"},
            {"-","*","*","*","*","*","*","*","*","*","*","-"},
            {"-","*","*","*","*","*","*","*","*","*","*","-"},
            {"-","*","*","*","*","*","*","*","*","*","*","-"},
            {"-","*","*","*","*","*","*","*","*","*","*","-"},
            {"-","-","-","-","-","-","-","-","-","-","-","-"}};
            //il faut loop dans l'array pour l'imprimer
        HashMap<int,String[][]>block = new HashMap<>();
        //the 7 blocks who will be choosen randomly
        block.put(0,new String{{"+","+","+","+"}});
        block.put(1,new String{{"+","*","*"},{"+","+","+"}});
        block.put(2,new String{{"*","*","+"},{"+","+","+"}});
        block.put(3,new String{{"+","+"},{"+","+"}});
        block.put(4,new String{{"+","+","*"},{"*","+","+"}});
        block.put(5,new String{{"*","+","*"},{"+","+","+"}});
        block.put(6,new String{{"*","+","+"},{"+","+","*"}});
    }
    public static void chooseblock(HashMap dic){
        int randomnum = (int)(Math.Random()*8);
        return dic[randomnum];
    } 
    public static void makeblockappear(String[][] grid,Myfunction blockchoisi,HashMap dic){//mettre en argument la grid et la fonction chooseblock
        //faire apparaitre le block dans la grid
    }
}

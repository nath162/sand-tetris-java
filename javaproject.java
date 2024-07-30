import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.Scanner;

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
        count = 0;
        String[][] block = blockchoisi(dic);//choisi block
        for(int i = 0; i < block.lenght;i++){
            for(int j = 0;j < block[i].lenght;i++){
                grid[i][3+count] = block[i][j];
                count +=1;
            }
        }
        return grid
    }
    public static void Timer(){
        //créer un timer
    }
    public static void displaygrid(String grid[][]){
        for(int i = 0; i < grid.lenght;i++){
            for(int j = 0;j < grid[i].lenght;j++)
            if(i != previous){
                System.out.println(grid[i][j]);
            }
            else{
                System.out.print(grid[i][j]);
            } 
            previous = i;
        }
    }
    public static void updategrid(Myfunction displaygrid,Myfunction asktoplay,String[][]grid){
        //update la grid et le mouvement des block
    }
    public static void checkcollision(String[][] grid){
        //check la colision des block 
    }
    public static void asktoplay(Myfunction timer){
        Scanner wanttoplay = new Scanner(System.in);
        System.out.println("do you want to play o/n ?");
        String anwser = wanttoplay.nextLine();
        if(anwser == "o"){
            timer();
        }
    }
}

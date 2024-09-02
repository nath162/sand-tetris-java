public class testV2{
    public static void main(String[] args){
        displaygid(destroylines(creategrid()));
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
            {"-", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "-"},
            {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}};
        return grid;
    }
    public static String[][] destroylines(String[][] grid) {//probleme les elements en haut ne descende pas ducoup aprés que la ligne soit détruite
        int destroy = 0;
        int pre = 0;
        for(int i=0;i < grid.length;i++){
            for(int j = 0;j < grid[i].length;j++){
                if(pre != i){
                    destroy = 0;
                }
                else{
                    destroy++;
                }
                if(grid[i][j] == "+"){
                    if(destroy == 10){
                            //delete la row qu'on veut pas puis ajouter une row tout en haut neuve
                        }
                    }
                }
                pre = i;
            }
        }
        return grid;
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
}

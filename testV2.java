import java.util.TimerTask;
import java.util.Timer;
public class testV2{
    public static void main(String[] args){
        
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
}

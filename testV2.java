import static org.junit.Assert.assertFalse;

import java.util.Scanner;

import org.junit.*;
public class testV2 {
    @Test
    public void testdowanttoplay(){
        assertFalse(dowanttoplay());
    }

    private boolean dowanttoplay() {
        Scanner asktoplay = new Scanner(System.in);
        System.err.println("do you want to play ?");
        boolean play = !asktoplay.equals("n");
        asktoplay.close();
        return play;
    }
}

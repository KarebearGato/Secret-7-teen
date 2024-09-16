import java.util.*;

public class Dice {
    public static void main(String[] args ) {
		
        Random rand = new Random();
		int random = rand.nextInt(6);
        System.out.println(random); //
    }
}

//returned a reference
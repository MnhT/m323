import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PureVsImpure {

    // Aufgabe 1.1 – impure (verändert globale Liste)
    static List<String> cartItems = new ArrayList<>();

    public static List<String> addToCart(String item) {
        cartItems.add(item);
        return cartItems;
    }

    // Aufgabe 1.2 – pure
    public static int add(int a, int b) {
        return a + b;
    }

    // Aufgabe 1.3 – pure
    public static char firstCharacter(String str) {
        return str.charAt(0);
    }

    // Aufgabe 1.4 – impure (nutzt Random = nicht nur von Parametern abhängig)
    public static double multiplyWithRandom(double number) {
        double randomValue = Math.random();
        return number * randomValue;
    }

    // Aufgabe 1.5 – pure
    public static double divideNumbers(double dividend, double divisor) {
        return dividend / divisor;
    }

    // Aufgabe 1.6 – impure (gibt etwas auf Konsole aus = Seiteneffekt)
    public static String printAndReturnString(String str) {
        System.out.println(str);
        return str;
    }

    public static void main(String[] args) {
        System.out.println("1.1: " + addToCart("Apple"));
        System.out.println("1.2: " + add(5, 3));
        System.out.println("1.3: " + firstCharacter("Hello"));
        System.out.println("1.4: " + multiplyWithRandom(5));
        System.out.println("1.5: " + divideNumbers(10, 2));
        System.out.println("1.6: " + printAndReturnString("Hello"));
    }
}

import java.util.ArrayList;
import java.util.List;

public class ImpureToPure {

    // Aufgabe 1.1 – PURE Version
    // Statt globale Liste → Übergabe und Rückgabe einer neuen Liste
    public static List<String> addToCartPure(List<String> currentCart, String item) {
        List<String> newCart = new ArrayList<>(currentCart);
        newCart.add(item);
        return newCart;
    }

    // Aufgabe 1.4 – PURE Version
    // Statt Random innerhalb der Funktion → Zufallswert als Parameter übergeben
    public static double multiplyWithRandomPure(double number, double randomValue) {
        return number * randomValue;
    }

    // Aufgabe 1.6 – PURE Version
    // Kein println() → Rückgabe nur des Strings, Ausgabe erfolgt extern
    public static String returnStringPure(String str) {
        return str;
    }

    public static void main(String[] args) {
        // --- Test für 1.1 ---
        List<String> cart = new ArrayList<>();
        cart = addToCartPure(cart, "Apple");
        cart = addToCartPure(cart, "Banana");
        System.out.println("Pure Cart: " + cart);  // Erwartet: [Apple, Banana]

        // --- Test für 1.4 ---
        double randomValue = 0.42; // zufälliger Wert extern generiert
        double result = multiplyWithRandomPure(10, randomValue);
        System.out.println("Pure Random Multiply: " + result); // Erwartet: 4.2

        // --- Test für 1.6 ---
        String resultStr = returnStringPure("Hello Pure");
        System.out.println("Pure Return: " + resultStr); // Erwartet: Hello Pure
    }
}

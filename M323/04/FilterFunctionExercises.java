import java.util.List;
import java.util.stream.Collectors;

public class FilterFunctionExercises {

    // Übung 1: Nur gerade Zahlen behalten
    public static List<Integer> filterEven(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

    // Übung 2: Namen mit mehr als 4 Buchstaben
    public static List<String> filterLongNames(List<String> names) {
        return names.stream()
                .filter(name -> name.length() > 4)
                .collect(Collectors.toList());
    }

    // Übung 3: Zahlen > 50
    public static List<Integer> filterGreaterThan50(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n > 50)
                .collect(Collectors.toList());
    }

    // Übung 4: Wörter, die mit "S" beginnen
    public static List<String> filterWordsStartingWithS(List<String> words) {
        return words.stream()
                .filter(word -> word.startsWith("S"))
                .collect(Collectors.toList());
    }

    // Übung 5: Bücher vor 1950 – Titel extrahieren
    public record Buch(String titel, String autor, int jahr) {}

    public static List<String> filterOldBookTitles(List<Buch> buecher) {
        return buecher.stream()
                .filter(b -> b.jahr() < 1950)
                .map(Buch::titel)
                .collect(Collectors.toList());
    }

    // --- Tests ---
    public static void main(String[] args) {
        // Übung 1
        System.out.println("Übung 1: " + filterEven(List.of(1, 2, 3, 4, 5))); // [2, 4]

        // Übung 2
        System.out.println("Übung 2: " + filterLongNames(List.of("Alice", "Bob", "Charlie", "Diana"))); // [Alice, Charlie, Diana]

        // Übung 3
        System.out.println("Übung 3: " + filterGreaterThan50(List.of(12, 45, 68, 100))); // [68, 100]

        // Übung 4
        System.out.println("Übung 4: " + filterWordsStartingWithS(List.of("Scala", "ist", "fantastisch"))); // [Scala]

        // Übung 5
        List<Buch> buecher = List.of(
                new Buch("1984", "George Orwell", 1949),
                new Buch("Brave New World", "Aldous Huxley", 1932),
                new Buch("Fahrenheit 451", "Ray Bradbury", 1953)
        );
        System.out.println("Übung 5: " + filterOldBookTitles(buecher)); // [1984, Brave New World]
    }
}

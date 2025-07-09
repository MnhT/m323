import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExercises {

    // Übung 1: Liste von Listen flach machen + Werte verdoppeln
    public static List<Integer> flattenAndDouble(List<List<Integer>> nested) {
        return nested.stream()
                .flatMap(inner -> inner.stream().map(n -> n * 2))
                .collect(Collectors.toList());
    }

    // Übung 2: Farben extrahieren, flach machen, duplikatfrei
    public record Person(String name, List<String> lieblingsfarben) {}

    public static List<String> uniqueFavoriteColors(List<Person> personen) {
        return personen.stream()
                .flatMap(p -> p.lieblingsfarben().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    // --- Tests ---
    public static void main(String[] args) {
        // Übung 1
        List<List<Integer>> zahlen = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5, 6)
        );
        System.out.println("Übung 1: " + flattenAndDouble(zahlen));
        // Erwartet: [2, 4, 6, 8, 10, 12]

        // Übung 2
        List<Person> personen = List.of(
                new Person("Max", List.of("Blau", "Grün")),
                new Person("Anna", List.of("Rot")),
                new Person("Julia", List.of("Gelb", "Blau", "Grün"))
        );
        System.out.println("Übung 2: " + uniqueFavoriteColors(personen));
        // Erwartet: [Blau, Grün, Rot, Gelb] (Reihenfolge kann je nach JVM variieren)
    }
}

import java.util.List;
import java.util.stream.Collectors;

public class MapFunctionExercises {

    // Übung 1: Zahlen verdoppeln
    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
    }

    // Übung 2: Namen in Grossbuchstaben
    public static List<String> namesToUpper(List<String> names) {
        return names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    // Übung 3: Hälfte jeder Zahl berechnen
    public static List<Double> halveNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n / 2.0)
                .collect(Collectors.toList());
    }

    // Übung 4: Adressen formatieren
    public record Adresse(String strasse, int hausnummer, String postleitzahl, String stadt) {}

    public static List<String> formatAdressen(List<Adresse> adressen) {
        return adressen.stream()
                .map(a -> a.strasse() + " " + a.hausnummer() + ", " + a.postleitzahl() + " " + a.stadt())
                .collect(Collectors.toList());
    }

    // Übung 5: Vornamen in Grossbuchstaben
    public static List<String> extractUppercaseFirstNames(List<String> fullNames) {
        return fullNames.stream()
                .map(name -> name.split(" ")[0].toUpperCase())
                .collect(Collectors.toList());
    }

    // --- Tests ---
    public static void main(String[] args) {
        // Übung 1
        System.out.println("Übung 1: " + doubleNumbers(List.of(1, 2, 3, 4, 5)));

        // Übung 2
        System.out.println("Übung 2: " + namesToUpper(List.of("Alice", "Bob", "Charlie")));

        // Übung 3
        System.out.println("Übung 3: " + halveNumbers(List.of(12, 45, 68, 100)));

        // Übung 4
        List<Adresse> adressen = List.of(
                new Adresse("Hauptstrasse", 10, "12345", "Musterstadt"),
                new Adresse("Nebenstrasse", 5, "23456", "Beispielburg")
        );
        System.out.println("Übung 4: " + formatAdressen(adressen));

        // Übung 5
        System.out.println("Übung 5: " + extractUppercaseFirstNames(List.of("Max Mustermann", "Erika Mustermann")));
    }
}

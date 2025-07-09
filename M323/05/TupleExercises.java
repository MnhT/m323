import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TupleExercises {

    // Tupel für Wetter: Beschreibung, Zeit, Temperatur
    public record Wetter(String beschreibung, LocalTime zeit, double temperatur) {}

    // Aufgabe 1: Wetterfunktion mit Tupel
    public static Wetter aktuellesWetter() {
        return new Wetter("sonnig", LocalTime.now(), 22.5);
    }

    // Aufgabe 2: Liste von Wetterdaten (Ort, Beschreibung, Temperatur)
    public record WetterDaten(String ort, String beschreibung, double temperatur) {}

    public static List<WetterDaten> warmeOrte(List<WetterDaten> daten, double grenzwert) {
        return daten.stream()
                .filter(d -> d.temperatur() > grenzwert)
                .collect(Collectors.toList());
    }

    // Zusatzaufgabe: trending() mit zip-ähnlicher Logik
    public static boolean trending(List<BigDecimal> werte) {
        if (werte.size() < 2) return false;

        return IntStream.range(0, werte.size() - 1)
                .allMatch(i -> werte.get(i).compareTo(werte.get(i + 1)) < 0);
    }

    // --- Tests ---
    public static void main(String[] args) {
        // Aufgabe 1
        Wetter w = aktuellesWetter();
        System.out.println("Aufgabe 1 – Aktuelles Wetter:");
        System.out.println(w.beschreibung() + ", Zeit: " + w.zeit() + ", Temp: " + w.temperatur() + "°C");

        // Aufgabe 2
        List<WetterDaten> daten = List.of(
                new WetterDaten("Zürich", "sonnig", 23.1),
                new WetterDaten("Luzern", "regnerisch", 19.0),
                new WetterDaten("Basel", "bewölkt", 21.5),
                new WetterDaten("Genf", "sonnig", 25.0)
        );

        System.out.println("\nAufgabe 2 – Städte über 20°C:");
        for (WetterDaten d : warmeOrte(daten, 20)) {
            System.out.println(d.ort() + " (" + d.temperatur() + "°C)");
        }

        // Zusatzaufgabe: trending()
        List<BigDecimal> kurs1 = List.of(new BigDecimal("1"), new BigDecimal("4"), new BigDecimal("3"), new BigDecimal("8"));
        List<BigDecimal> kurs2 = List.of(new BigDecimal("1"), new BigDecimal("2"), new BigDecimal("3"), new BigDecimal("8"));

        System.out.println("\nZusatzaufgabe – Trending:");
        System.out.println("Kurs1: " + kurs1 + " → trending? " + trending(kurs1)); // false
        System.out.println("Kurs2: " + kurs2 + " → trending? " + trending(kurs2)); // true
    }
}

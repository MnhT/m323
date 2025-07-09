import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class MapFilterCombinedExercises {

    // Übung 1: IT-Mitarbeiter filtern und formatieren
    public record Mitarbeiter(String name, String abteilung, int gehalt) {}

    public static List<String> filterItMitarbeiter(List<Mitarbeiter> mitarbeiterList) {
        return mitarbeiterList.stream()
                .filter(m -> m.abteilung().equals("IT") && m.gehalt() >= 50000)
                .map(m -> m.name().split(" ")[0].toUpperCase())
                .collect(Collectors.toList());
    }

    // Übung 2: Kursnamen verarbeiten
    public static List<String> filterUndFormatiereKurse(List<String> kurse, boolean reverse) {
        return kurse.stream()
                .filter(k -> k.contains("Daten"))
                .map(k -> k.replaceAll("\\s+", ""))
                .sorted(reverse ? Comparator.reverseOrder() : Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    // --- Tests ---
    public static void main(String[] args) {
        // Übung 1
        List<Mitarbeiter> mitarbeiter = List.of(
                new Mitarbeiter("Max Mustermann", "IT", 50000),
                new Mitarbeiter("Erika Musterfrau", "Marketing", 45000),
                new Mitarbeiter("Klaus Klein", "IT", 55000),
                new Mitarbeiter("Julia Gross", "HR", 40000)
        );
        System.out.println("Übung 1: " + filterItMitarbeiter(mitarbeiter)); // [MAX, KLAUS]

        // Übung 2
        List<String> kurse = List.of(
                "Programmierung in Scala",
                "Datenbanken",
                "Webentwicklung mit JavaScript",
                "Algorithmen und Datenstrukturen"
        );

        System.out.println("Übung 2 – alphabetisch: " + filterUndFormatiereKurse(kurse, false));
        // Erwartet: [AlgorithmenundDatenstrukturen, Datenbanken]

        System.out.println("Übung 2 – reverse alphabetisch: " + filterUndFormatiereKurse(kurse, true));
        // Erwartet: [Datenbanken, AlgorithmenundDatenstrukturen]
    }
}

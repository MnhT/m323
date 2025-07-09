import java.util.List;
import java.util.Optional;

public class FoldLeftExercises {

    // Übung 1: Summe aller Zahlen
    public static int sumList(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum); // initial = 0
    }

    // Übung 2: Alle Strings zu einem einzigen String zusammenführen
    public static String concatStrings(List<String> strings) {
        return strings.stream()
                .reduce("", (acc, str) -> acc + str); // initial = ""
    }

    // Übung 3: Schwerpunkt (Durchschnitt) von Punkten berechnen
    public record Point(int x, int y) {}

    public static Point calculateCentroid(List<Point> points) {
        if (points.isEmpty()) return new Point(0, 0);

        Point sum = points.stream()
                .reduce(new Point(0, 0),
                        (acc, p) -> new Point(acc.x + p.x, acc.y + p.y));

        int count = points.size();
        return new Point(sum.x / count, sum.y / count);
    }

    // --- Tests ---
    public static void main(String[] args) {
        // Übung 1
        System.out.println("Übung 1: Summe = " + sumList(List.of(1, 2, 3, 4, 5))); // 15

        // Übung 2
        System.out.println("Übung 2: Kombiniert = \"" + concatStrings(List.of("Hallo", " ", "Welt", "!")) + "\""); // "Hallo Welt!"

        // Übung 3
        List<Point> points = List.of(
                new Point(1, 3),
                new Point(2, 5),
                new Point(4, 8),
                new Point(6, 2)
        );
        Point centroid = calculateCentroid(points);
        System.out.println("Übung 3: Schwerpunkt = (" + centroid.x + ", " + centroid.y + ")"); // (3, 4)
    }
}

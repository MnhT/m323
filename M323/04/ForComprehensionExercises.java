import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ForComprehensionExercises {

    // Übung 1: Zahlen von 1 bis 10 quadrieren
    public static List<Integer> squareNumbers() {
        return IntStream.rangeClosed(1, 10)
                .map(n -> n * n)
                .boxed()
                .collect(Collectors.toList());
    }

    // Übung 2: Nur gerade Zahlen von 1 bis 20
    public static List<Integer> evenNumbers() {
        return IntStream.rangeClosed(1, 20)
                .filter(n -> n % 2 == 0)
                .boxed()
                .collect(Collectors.toList());
    }

    // Übung 3: Alle Kombinationen aus Farben und Früchten
    public static List<String> colorFruitPairs(List<String> colors, List<String> fruits) {
        return colors.stream()
                .flatMap(color ->
                        fruits.stream().map(fruit -> color + "-" + fruit))
                .collect(Collectors.toList());
    }

    // Übung 4: Nur unerledigte Aufgaben pro Benutzer
    public record User(String name, List<String> tasks) {}

    public static List<String> pendingTasksPerUser(List<User> users, List<String> completedTasks) {
        return users.stream()
                .flatMap(user -> user.tasks().stream()
                        .filter(task -> !completedTasks.contains(task))
                        .map(task -> user.name() + ": " + task))
                .collect(Collectors.toList());
    }

    // --- Tests ---
    public static void main(String[] args) {
        // Übung 1
        System.out.println("Übung 1: Quadrierte Zahlen = " + squareNumbers());

        // Übung 2
        System.out.println("Übung 2: Gerade Zahlen = " + evenNumbers());

        // Übung 3
        List<String> colors = List.of("Red", "Green", "Blue");
        List<String> fruits = List.of("Apple", "Banana", "Orange");
        System.out.println("Übung 3: Farb-Frucht-Paare = " + colorFruitPairs(colors, fruits));

        // Übung 4
        List<User> users = List.of(
                new User("Alice", List.of("Task 1", "Task 2", "Task 3")),
                new User("Bob", List.of("Task 1", "Task 4", "Task 5")),
                new User("Charlie", List.of("Task 2", "Task 3", "Task 6"))
        );
        List<String> tasksCompleted = List.of("Task 1", "Task 3", "Task 5");
        System.out.println("Übung 4: Unerledigte Aufgaben = " + pendingTasksPerUser(users, tasksCompleted));
    }
}

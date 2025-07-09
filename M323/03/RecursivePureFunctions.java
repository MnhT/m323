import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RecursivePureFunctions {

    // Aufgabe 3.1 – Summe einer Liste berechnen (rekursiv)
    public static int sum(List<Integer> numbers) {
        if (numbers.isEmpty()) return 0;
        return numbers.get(0) + sum(numbers.subList(1, numbers.size()));
    }

    // Aufgabe 3.2 – Mittelwert einer Liste berechnen (rekursiv)
    public static double average(List<Integer> numbers) {
        if (numbers.isEmpty()) return 0;
        return (double) sum(numbers) / numbers.size();
    }

    // Aufgabe 3.3 – Alphabetisch sortieren (rekursiv, mit Merge Sort)
    public static List<String> recursiveSortStrings(List<String> list) {
        if (list.size() <= 1) return list;
        int mid = list.size() / 2;
        List<String> left = recursiveSortStrings(list.subList(0, mid));
        List<String> right = recursiveSortStrings(list.subList(mid, list.size()));
        return mergeStrings(left, right);
    }

    private static List<String> mergeStrings(List<String> left, List<String> right) {
        List<String> merged = new ArrayList<>();
        if (left.isEmpty()) return new ArrayList<>(right);
        if (right.isEmpty()) return new ArrayList<>(left);

        if (left.get(0).compareTo(right.get(0)) <= 0) {
            merged.add(left.get(0));
            merged.addAll(mergeStrings(left.subList(1, left.size()), right));
        } else {
            merged.add(right.get(0));
            merged.addAll(mergeStrings(left, right.subList(1, right.size())));
        }
        return merged;
    }

    // Aufgabe 3.4 – Objekte nach Datum, Priorität, Titel sortieren (rekursiv, Merge Sort)
    public static class Task {
        LocalDate date;
        int priority;
        String title;

        public Task(LocalDate date, int priority, String title) {
            this.date = date;
            this.priority = priority;
            this.title = title;
        }

        @Override
        public String toString() {
            return date + " | " + priority + " | " + title;
        }
    }

    public static List<Task> recursiveSortTasks(List<Task> tasks) {
        if (tasks.size() <= 1) return tasks;
        int mid = tasks.size() / 2;
        List<Task> left = recursiveSortTasks(tasks.subList(0, mid));
        List<Task> right = recursiveSortTasks(tasks.subList(mid, tasks.size()));
        return mergeTasks(left, right);
    }

    private static List<Task> mergeTasks(List<Task> left, List<Task> right) {
        List<Task> merged = new ArrayList<>();
        if (left.isEmpty()) return new ArrayList<>(right);
        if (right.isEmpty()) return new ArrayList<>(left);

        Comparator<Task> taskComparator = Comparator
                .comparing((Task t) -> t.date)
                .thenComparingInt(t -> t.priority)
                .thenComparing(t -> t.title);

        if (taskComparator.compare(left.get(0), right.get(0)) <= 0) {
            merged.add(left.get(0));
            merged.addAll(mergeTasks(left.subList(1, left.size()), right));
        } else {
            merged.add(right.get(0));
            merged.addAll(mergeTasks(left, right.subList(1, right.size())));
        }
        return merged;
    }

    // Aufgabe 3.5 – Alle Blätter aus einem Baum extrahieren
    public static class TreeNode<T> {
        T value;
        List<TreeNode<T>> children;

        public TreeNode(T value, List<TreeNode<T>> children) {
            this.value = value;
            this.children = children;
        }

        public boolean isLeaf() {
            return children == null || children.isEmpty();
        }
    }

    public static <T> List<T> collectLeaves(TreeNode<T> node) {
        List<T> result = new ArrayList<>();
        if (node.isLeaf()) {
            result.add(node.value);
        } else {
            for (TreeNode<T> child : node.children) {
                result.addAll(collectLeaves(child));
            }
        }
        return result;
    }

    // --- Tests ---
    public static void main(String[] args) {
        // 3.1 Summe
        System.out.println("Summe: " + sum(List.of(1, 2, 3, 4))); // 10

        // 3.2 Durchschnitt
        System.out.println("Durchschnitt: " + average(List.of(1, 2, 3, 4))); // 2.5

        // 3.3 Sortieren von Strings
        System.out.println("Alphabetisch sortiert: " + recursiveSortStrings(List.of("Banana", "Apple", "Orange")));

        // 3.4 Sortieren von Tasks
        List<Task> tasks = List.of(
                new Task(LocalDate.of(2023, 5, 12), 2, "Zukunft"),
                new Task(LocalDate.of(2023, 5, 12), 1, "Apfel"),
                new Task(LocalDate.of(2022, 3, 1), 3, "Haus")
        );
        System.out.println("Tasks sortiert:");
        for (Task task : recursiveSortTasks(tasks)) {
            System.out.println(task);
        }

        // 3.5 Baumstruktur
        TreeNode<String> tree = new TreeNode<>("Root", List.of(
                new TreeNode<>("A", List.of(
                        new TreeNode<>("A1", List.of()),
                        new TreeNode<>("A2", List.of())
                )),
                new TreeNode<>("B", List.of(
                        new TreeNode<>("B1", List.of(
                                new TreeNode<>("B1a", List.of())
                        ))
                ))
        ));
        System.out.println("Blätter des Baums: " + collectLeaves(tree)); // [A1, A2, B1a]
    }
}

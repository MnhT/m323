import java.util.*;
import java.util.stream.*;
 
public class RaceCalculator {
    public static List<Double> dropWarmUp(List<Double> times) {
        return times.stream()
                .skip(1)
                .collect(Collectors.toList());
    }
 
    public static double computeTotalTime(List<Double> times) {
        return dropWarmUp(times).stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }
 
    public static double computeAverageTime(List<Double> times) {
        List<Double> valid = dropWarmUp(times);
        return valid.isEmpty()
                ? 0.0
                : computeTotalTime(valid) / valid.size();
    }
 
    public static void main(String[] args) {
        Map<String, List<Double>> results = new LinkedHashMap<>();
 
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Auto-Name eingeben (0 = fertig): ");
                String car = scanner.nextLine().trim();
                if ("0".equals(car)) break;
                if (car.isEmpty()) {
                    System.out.println("Ungültiger Name, probier’s nochmal.");
                    continue;
                }
 
                List<Double> times = new ArrayList<>();
                System.out.println("Rundenzeiten in Sekunden eingeben (0 = nächste Runde/Liste beenden):");
                while (true) {
                    System.out.print("Zeit: ");
                    String line = scanner.nextLine().trim();
                    if ("0".equals(line)) break;
                    try {
                        times.add(Double.parseDouble(line));
                    } catch (NumberFormatException e) {
                        System.out.println("Ungültige Zahl.");
                    }
                }
                results.put(car, new ArrayList<>(times));
            }
        }
 
        if (results.isEmpty()) {
            System.out.println("Keine Daten zum Auswerten.");
        } else {
            System.out.println("\n=== Rennergebnisse ===");
            results.forEach((car, times) -> {
                double total   = computeTotalTime(times);
                double average = computeAverageTime(times);
                System.out.printf("%s → Gesamt: %.2f s, Ø-Zeit: %.2f s%n", car, total, average);
            });
        }
    }
}
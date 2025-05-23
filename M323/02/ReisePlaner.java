import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReisePlaner {

    // Funktion 1: Reiseziele eingeben
    public static List<String> reisezieleEingeben() {
        Scanner scanner = new Scanner(System.in);
        List<String> route = new ArrayList<>();

        System.out.println("Geben Sie Ihre Reiseziele ein (zum Beenden 'fertig' eingeben):");
        while (true) {
            System.out.print("Reiseziel: ");
            String ziel = scanner.nextLine();
            if (ziel.equalsIgnoreCase("fertig")) {
                break;
            }
            route.add(ziel);
        }
        return route;
    }

    // Funktion 2: Route ändern
    public static void routeAendern(List<String> route) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Aktuelle Route: " + route);

        System.out.println("Möchten Sie ein Ziel (hinzufügen, entfernen, ersetzen)?");
        String aktion = scanner.nextLine();

        switch (aktion.toLowerCase()) {
            case "hinzufügen":
                System.out.print("Welches Ziel möchten Sie hinzufügen? ");
                String neuesZiel = scanner.nextLine();
                System.out.print("An welcher Position (0 - " + route.size() + ")? ");
                int positionH = Integer.parseInt(scanner.nextLine());
                if (positionH >= 0 && positionH <= route.size()) {
                    route.add(positionH, neuesZiel);
                } else {
                    System.out.println("Ungültige Position.");
                }
                break;

            case "entfernen":
                System.out.print("Welches Ziel möchten Sie entfernen? ");
                String zielEntfernen = scanner.nextLine();
                route.remove(zielEntfernen);
                break;

            case "ersetzen":
                System.out.print("Welches Ziel möchten Sie ersetzen? ");
                String altesZiel = scanner.nextLine();
                System.out.print("Neues Ziel: ");
                String neuesZielErsetzen = scanner.nextLine();
                int index = route.indexOf(altesZiel);
                if (index != -1) {
                    route.set(index, neuesZielErsetzen);
                } else {
                    System.out.println("Ziel nicht gefunden.");
                }
                break;

            default:
                System.out.println("Unbekannte Aktion.");
        }

        System.out.println("Aktualisierte Route: " + route);
    }

    public static void main(String[] args) {
        List<String> route = reisezieleEingeben();
        System.out.println("Ihre geplante Route: " + route);

        System.out.println("\nMöchten Sie die Route ändern? (ja/nein)");
        Scanner scanner = new Scanner(System.in);
        String antwort = scanner.nextLine();

        if (antwort.equalsIgnoreCase("ja")) {
            routeAendern(route);
        }

        System.out.println("Finale Route: " + route);
    }
}
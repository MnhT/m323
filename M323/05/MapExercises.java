import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MapExercises {
    public static void main(String[] args) {
        // Übung 1 – Wert zuweisen
        Map<String, String> m1 = Map.of("key", "value");
        System.out.println("Übung 1: " + m1); // {key=value}

        // Übung 2 – Map aktualisieren
        Map<String, String> m2 = new HashMap<>(m1); // Kopie von m1 (weil Map.of() immutable ist)
        m2.put("key2", "value2");
        System.out.println("Übung 2: " + m2); // {key=value, key2=value2}

        // Übung 3 – Map nochmals aktualisieren
        Map<String, String> m3 = new HashMap<>(m2);
        m3.put("key2", "aDifferentValue");
        System.out.println("Übung 3: " + m3); // {key=value, key2=aDifferentValue}

        // Übung 4 – Element entfernen
        Map<String, String> m4 = new HashMap<>(m3);
        m4.remove("key");
        System.out.println("Übung 4: " + m4); // {key2=aDifferentValue}

        // Übung 5 – Nach key in m3 suchen
        Optional<String> valueFromM3 = Optional.ofNullable(m3.get("key"));
        System.out.println("Übung 5: " + valueFromM3); // Optional[value]

        // Übung 6 – Nach key in m4 suchen (existiert nicht)
        Optional<String> valueFromM4 = Optional.ofNullable(m4.get("key"));
        System.out.println("Übung 6: " + valueFromM4); // Optional.empty
    }
}

import java.util.*;
 
public class WordPoints {
 
    public static class WordScore {
        private final String word;
        private final int score;
 
        public WordScore(String word, int score) {
            this.word = word;
            this.score = score;
        }
 
        public String getWord() {
            return word;
        }
 
        public int getScore() {
            return score;
        }
    }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<WordScore> wordScores = new ArrayList<>();
 
        System.out.println("Gib Wörter ein (\"fertig\" zum Beenden):");
 
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("fertig")) {
                break;
            }
            int score = calculateScore(input);
            wordScores.add(new WordScore(input, score));
        }
 
        wordScores.sort((w1, w2) -> Integer.compare(w2.getScore(), w1.getScore()));
 
        System.out.println("\nBewertete Wörter (absteigend sortiert):");
        for (WordScore ws : wordScores) {
            System.out.printf("%s: %d Punkte%n", ws.getWord(), ws.getScore());
        }
    }
 
    private static int calculateScore(String word) {
        int score = 0;
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c) && Character.toLowerCase(c) != 'a') {
                score++;
            }
        }
        return score;
    }
}
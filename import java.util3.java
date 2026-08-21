import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// Candidate class representing individual candidate details
class Candidate {
    private int candidate_Id;
    private String name;
    private int aptitude;
    private int technical;
    private int communication;

    // Parameterized constructor to initialize candidate details
    public Candidate(int candidate_Id, String name, int aptitude, int technical, int communication) {
        this.candidate_Id = candidate_Id;
        this.name = name;
        this.aptitude = aptitude;
        this.technical = technical;
        this.communication = communication;
    }

    // Method to calculate and return total/overall score
    public int getTotalScore() {
        return aptitude + technical + communication;
    }

    public int getCandidate_Id() {
        return candidate_Id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Total Score: %d", candidate_Id, name, getTotalScore());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input N (Number of candidates) and K (Number to shortlist)
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        // Array of Candidate objects
        Candidate[] candidates = new Candidate[N];

        // Reading candidate data
        for (int i = 0; i < N; i++) {
            // Parses inputs formatted either with space or comma delimiter
            int id = scanner.nextInt();
            String name = scanner.next();
            int aptitude = scanner.nextInt();
            int technical = scanner.nextInt();
            int communication = scanner.nextInt();

            candidates[i] = new Candidate(id, name, aptitude, technical, communication);
        }

        // Custom Comparator to sort by priority rules:
        // 1. Higher total score comes first (descending order)
        // 2. Tie-breaker: Smaller Candidate ID comes first (ascending order)
        Arrays.sort(candidates, new Comparator<Candidate>() {
            @Override
            public int compare(Candidate c1, Candidate c2) {
                if (c2.getTotalScore() != c1.getTotalScore()) {
                    return Integer.compare(c2.getTotalScore(), c1.getTotalScore()); // Descending score
                }
                return Integer.compare(c1.getCandidate_Id(), c2.getCandidate_Id()); // Ascending ID
            }
        });

        // Displaying Top K shortlisted candidates
        System.out.println("\nTop " + K + " Candidates:");
        for (int i = 0; i < Math.min(K, N); i++) {
            System.out.println(candidates[i]);
        }

        scanner.close();
    }
}
import java.util.Scanner;

public class NFA {
    public static boolean check(String s) {
        int state = 0;

        for (char c : s.toCharArray()) {
            if (state == 0) {
                if (c == 'a') state = 1;
                else if (c != 'b') return false;
            }
            else if (state == 1) {
                if (c == 'b') state = 2;
                else if (c != 'a') return false;
            }
        }
        return state == 2;
    }

    public static void main(String[] args) {
        String[] s = {"ab", "aab", "bab", "baab", "aaa", "bbb", "aba"};

        for (String str : s) {
            if (check(str))
                System.out.println(str + " Accepted");
            else
                System.out.println(str + " Rejected");
        }
    }
}
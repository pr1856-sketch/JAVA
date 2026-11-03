import java.util.Scanner;

public class BinaryDFA {
    public static boolean check(String s) {
        int state = 0;

        for (char c : s.toCharArray()) {
            if (state == 0) {
                if (c == '0') state = 1;
                else if (c == '1') state = 0;
                else return false;
            }
            else if (state == 1) {
                if (c == '0') state = 1;
                else if (c == '1') state = 2;
                else return false;
            }
            else {
                if (c == '0') state = 1;
                else if (c == '1') state = 0;
                else return false;
            }
        }
        return state == 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = {"01", "101", "1101", "100", "111", "0", "0101"};

        for (String str : s) {
            if (check(str))
                System.out.println(str + " Accepted");
            else
                System.out.println(str + " Rejected");
        }
    }
}
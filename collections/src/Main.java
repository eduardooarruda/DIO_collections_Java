import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String palavra = scanner.next();

        for(int i = 1; i <= palavra.length(); i++) {
            for(int j = 0; j < i; j++) {
                System.out.print(palavra.charAt(j));
            }
            System.out.println();
        }

    }
}

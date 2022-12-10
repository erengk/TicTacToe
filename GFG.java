import java.util.*;

public class GFG {

    public static void main(String[] args) {

        Board board = new Board(3, 3);

        Scanner scanner = new Scanner(System.in);
        int choise;

        do {
            System.out.println("Please make your choise: 1 vs 1 = 0 || 1 vs CPU = 1");
            choise = scanner.nextInt();
            System.out.println(choise);
        } while (choise != 1 && choise != 0);
        System.out.println("Lütfen player1 isim giriniz: ");
        Player player1 = new Player(scanner.next(), 1);

        String result = " ";
        if (choise == 0) {
            System.out.println("Lütfen player2 isim giriniz: ");
            Player player2 = new Player(scanner.next(), 0);
            result = playervsplayer(player1, player2, board);
            if (result.equals("O")) {
                System.out.println(player2.name + " Kazandı");
            }
        } else {
            Cpu cpu = new Cpu(0);
            result = playervsCPU(player1, cpu, board);
            if (result.equals("O")) {
                System.out.println("CPU Kazandı");
            }
        }
        if (result.equals("X")) {
            System.out.println(player1.name + " Kazandı");
        }

    }

    public static String playervsplayer(Player player1, Player player2, Board board) {
        String result = " ";
        while (true) {
            player1.move(board);
            result = board.checkWinner();
            if (!result.equals(" ")) {
                return result;
            }
            player2.move(board);
            result = board.checkWinner();
            if (!result.equals(" ")) {
                return result;
            }
        }
    }

    public static String playervsCPU(Player player1, Cpu player2, Board board) {
        String result = " ";
        while (true) {
            player1.move(board);
            result = board.checkWinner();
            if (!result.equals(" ")) {
                return result;
            }
            player2.moveCpu(board);
            result = board.checkWinner();
            if (!result.equals(" ")) {
                return result;
            }
        }
    }
}
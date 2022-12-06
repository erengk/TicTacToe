import java.awt.desktop.SystemEventListener;
import java.util.*;

public class GFG {

    public static void main(String[] args) {

        Board board = new Board(3,3);

        Scanner scanner = new Scanner(System.in);
        int choise;

        do {
            System.out.println("Please make your choise: 1 vs 1 = 0 || 1 vs CPU = 1");
            choise = scanner.nextInt();
            System.out.println(choise);
        }while (choise != 1 && choise != 0);
        System.out.println("Lütfen player1 isim giriniz: ");
        Player player1 = new Player(scanner.next(),1);


        if(choise == 0){
            System.out.println("Lütfen player2 isim giriniz: ");
            Player player2 = new Player(scanner.next(),0);
            playervsplayer(player1,player2,board);
        }else{
            Cpu cpu = new Cpu(0);
            playervsCPU(player1,cpu,board);
        }


    }
    public static void playervsplayer(Player player1, Player player2, Board board){
        while (true) {
            player1.move(board);
            if (board.checkWinner().equals("X")) {
                System.out.println(player1.name + " Kazandı!");
                break;
            }
            player2.move(board);
            if (board.checkWinner().equals("O")) {
                System.out.println(player2.name + " Kazandı!");
                break;
            }
        }
    }
    public static void playervsCPU(Player player1, Cpu player2, Board board){
        while (true) {
            player1.move(board);
            if (board.checkWinner().equals("X")) {
                System.out.println(player1.name + " Kazandı!");
                break;
            }
            player2.moveCpu(board);
            if (board.checkWinner().equals("O")) {
                System.out.println("CPU Kazandı!");
                break;
            }
        }
    }

}
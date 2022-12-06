import java.util.Scanner;

public class Player extends Board{
    int type;

    Scanner scanner = new Scanner(System.in);
    public String name;
    Player(String name, int type){
        this.name = name;
        this.type = type;
    }
    public void move(Board board){
        System.out.println("Lütfen satır numarasını giriniz:");
        int x = scanner.nextInt();
        System.out.println("Lütfen sütun numarasını giriniz:");
        int y = scanner.nextInt();
        if(!board.isEmpty(x,y)){
            System.out.println("Lütfen Boş Bir Kareyi Oynayın");
            this.move(board);
        }else{
            board.play(x,y,this.type);
            board.checkWinner();
        }

    }
}



public class Cpu extends Board {


    int type;

    private String name;
    Cpu(int type){
        this.name = "CPU";
        this.type = type;
    }
    public void moveCpu(Board board){
        int x = (int)(Math.random()*3);
        int y = (int)(Math.random()*3);

        if(!board.isEmpty(x,y)){
            this.moveCpu(board);
        }else{
            board.play(x,y,this.type);
        }
    }

}

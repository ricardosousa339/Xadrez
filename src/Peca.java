public abstract class Peca {

    public int x;
    public int y;
    char cor;
    public boolean isVazio;

    int[] vertical;
    int[] horizontal;

    abstract public boolean move(Tabuleiro tabuleiro, int x2, int y2);
    abstract public int getX();
    abstract public int getY();



    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean captura(Tabuleiro tabuleiro, int x1, int y1, int x2, int y2){

        Peca peca = tabuleiro.getBoard(x1, y1);

        if(peca.cor=='b'){
            JogoXadrez.capturadasPeloPreto.add(peca);
        }
        else{
            JogoXadrez.capturadasPeloBranco.add(peca);
        }


        return true;
    }
}

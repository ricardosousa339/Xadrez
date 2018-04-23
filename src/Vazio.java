public class Vazio extends Peca{

    private int x;
    private int y;
    public boolean isVazio;

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    public Vazio(int x, int y){
        setX(x);
        setY(y);
        super.isVazio = true;
    }
    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public boolean move(Tabuleiro tabuleiro, int x2, int y2) {
        return false;
    }

    @Override
    public String toString() {
        return "__";
    }
}

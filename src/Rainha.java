public class Rainha extends Peca {

    @Override
    public boolean move(Tabuleiro tabuleiro, int x2, int y2) {
        return false;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "D"+new String(super.cor+"").toUpperCase();
    }

    public Rainha(int x, int y, char cor){

        super.cor = cor;
        super.setX(x);
        super.setY(y);
    }
}

public class Cavalo extends Peca {

    private int[] horizontal = {1,2,2,1,-1,-2,-2,-1};
    private int[] vertical = {2,1,-1,-2,-2,-1,1,2};



    private boolean isPosicaoValida(int x1, int y1, int x2, int y2){

        if(x2 >= 0 && y2 >= 0 && x2 < 8 && y2 < 8) {

            for (int i = 0; i < 8; i++) {

                if((y2 == y1 + vertical[i] && x2 == x1 +horizontal[i]) || (y2 == y1 - vertical[i] && x2 == x1 - horizontal[i])){
                    return true;
                }
            }
        }

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
    public boolean move(Tabuleiro tabuleiro, int x2, int y2) {

        int x1 = this.getX();
        int y1 = this.getY();

        if(isPosicaoValida(x1,y1,x2,y2)) {
            Peca peca = tabuleiro.getBoard(x1, y1);

            Peca destino = tabuleiro.getBoard(x2, y2);
            Peca vazio = new Vazio(x1, y1);


            if (isPosicaoValida(x1, y1, x2, y2) && peca.cor != destino.cor) {

                if (!tabuleiro.getBoard(x2, y2).isVazio && peca.cor == 'b' && destino.cor == 'p') {
                    JogoXadrez.capturadasPeloBranco.add(destino);
                } else if (!tabuleiro.getBoard(x2, y2).isVazio && peca.cor == 'p' && destino.cor == 'b') {
                    JogoXadrez.capturadasPeloPreto.add(destino);
                }
                peca.setX(x2);
                peca.setY(y2);
                tabuleiro.setBoard(peca);
                tabuleiro.setBoard(vazio);
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "C" + new String(super.cor+"").toUpperCase();
    }

    public Cavalo(int x, int y, char cor){

        super.cor = cor;
        super.setX(x);
        super.setY(y);
    }
}

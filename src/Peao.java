
public class Peao extends Peca {

    private int x;
    private int y;
    private char cor;
    public boolean isVazio = false;

    private int[] vertical = {1, 2, 1};
    private int[] horizontal = {0, 0, 1};

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    public boolean move(Tabuleiro tabuleiro, int x2, int y2) {

        int x1 = this.getX();
        int y1 = this.getY();

        Peca peca = tabuleiro.getBoard(x1, y1);

        Peca destino = tabuleiro.getBoard(x2, y2);
        Peca vazio = new Vazio(x1,y1);


/**
 * verifica a cor, soma ou subtrai dos números dos arrays vertical e horizontal pra ver se o movimento e valido
 */

if((JogoXadrez.vez && y2 == y1 + 1 && x2 == x1 +1) || (peca.cor == 'p' && destino.cor == 'b' && !JogoXadrez.vez && y2 == y1 -1 && x2 == x1 -1)){

    if(peca.cor == 'b' && destino.cor == 'p'){
        JogoXadrez.capturadasPeloBranco.add(destino);
        peca.setX(x2);
        peca.setY(y2);
        tabuleiro.setBoard(peca);
        tabuleiro.setBoard(vazio);
        return true;
    }
    else if(peca.cor == 'p' && destino.cor == 'b'){
        JogoXadrez.capturadasPeloPreto.add(destino);
        peca.setX(x2);
        peca.setY(y2);
        tabuleiro.setBoard(peca);
        tabuleiro.setBoard(vazio);
        return true;
    }
}

        if (peca.cor == 'p' && !JogoXadrez.vez && isPosicaoValida(x1,y1,x2,y2,2)||
                (peca.cor == 'b' && JogoXadrez.vez && isPosicaoValida(x1,y1,x2,y2,1)))
        {

            peca.setX(x2);
            peca.setY(y2);
            tabuleiro.setBoard(peca);
            tabuleiro.setBoard(vazio);

            return true;
        }


        return false;
    }

    public boolean isPosicaoValida(int x1, int y1, int x2, int y2, int op){

        //checa se a posicao destino esta dentro dos limites do tabuleiro
        if(x2 >= 0 && y2 >= 0 && x2 < 8 && y2 < 8) {

            //se a peca e branca e esta no inicio ou se e preta e esta no inicio, retorna true
            if (op == 1 && (y1 == 1 && y2 == 3 && x2 == x1) || op == 2 &&(y1 == 6 && y2 == 4  && x2 == x1)){
                return true;
            }
            for (int i = 0; i < 1; i++) {

                if(op ==1 && (y2 == y1 + vertical[i] && x2 == x1 +horizontal[i]) || op ==2 &&(y2 == y1 - vertical[i] && x2 == x1 - horizontal[i])){
                    return true;
                }
            }
        }

        return false;
    }


    public Peao(int x, int y, char cor){

        super.cor = cor;
        setX(x);
        setY(y);

    }

    @Override
    public String toString() {
        return "P" + new String(super.cor+"").toUpperCase();
    }
}
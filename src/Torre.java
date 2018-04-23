public class Torre extends Peca{

    @Override
    public boolean move(Tabuleiro tabuleiro, int x2, int y2) {

        int x1 = this.getX();
        int y1 = this.getY();

        Peca peca = tabuleiro.getBoard(x1, y1);

        Peca destino = tabuleiro.getBoard(x2, y2);

        if(isPosicaoValida(tabuleiro,peca,destino,x1,y1,x2,y2)){
            return true;
        }




        return false;
    }

    private boolean isPosicaoValida(Tabuleiro tabuleiro, Peca peca, Peca destino, int x1,int y1, int x2, int y2){

        int Ny = y1+1, Sy = y1-1, Ox = x1-1, Lx = x1+1;

        /*
        Ny: Norte; Sy: Sul; Ox: Oeste(esquerda; Lx: Leste(Direita);
        Cada um representa o marco da primeira casa do tabuleiro ocupada, ou seja, o limite do movimento da torre
         */
        while(Lx < 8 && tabuleiro.getBoard(Lx, y1).isVazio){
            Lx++;
        }

        while(Ox >= 0 && tabuleiro.getBoard(Ox, y1).isVazio){
            Ox--;
        }
        while(Ny < 8 && tabuleiro.getBoard(x1, Ny).isVazio){
            Ny++;
        }
        while(Sy >= 0 && tabuleiro.getBoard(x1, Sy).isVazio){
            Sy--;
        }
        System.out.println(Ny);
        System.out.println(Sy);
        System.out.println(Ox);
        System.out.println(Lx);

        /*
        Se a posicao destino estiver em linha reta com a de origem vertical ou horizontalmente, e no limite calculado antes
        ou o destino for uma peca de outra cor, o movimento e permitido
         */
        if(x1 == x2){
            if(y2 > Sy && y2 < Ny) {
                seta(tabuleiro, x1, y1, x2, y2);
                return true;
            }
            if(y2 == Sy || y2 == Ny){
                if(peca.cor == 'b' && JogoXadrez.vez && tabuleiro.getBoard(x2,y2).cor == 'p'){
                    seta(tabuleiro, x1, y1, x2, y2);
                    JogoXadrez.capturadasPeloBranco.add(destino);
                    return true;
                }
                if( peca.cor == 'p' && !JogoXadrez.vez && tabuleiro.getBoard(x2,y2).cor == 'b'){
                    seta(tabuleiro, x1, y1, x2, y2);
                    JogoXadrez.capturadasPeloPreto.add(destino);
                    return true;
                }
            }
        }
        if(y1 == y2){
            if(x2 > Ox && Ox < Lx){
                seta(tabuleiro,x1,y1,x2,y2);
                return true;
            }
            if(x2 == Ox || x2 == Lx){
                if(peca.cor == 'b' && JogoXadrez.vez && tabuleiro.getBoard(x2,y2).cor == 'p'){
                    seta(tabuleiro, x1, y1, x2, y2);
                    JogoXadrez.capturadasPeloBranco.add(destino);
                    return true;
                }
                if(peca.cor == 'p' && !JogoXadrez.vez && tabuleiro.getBoard(x2,y2).cor == 'b'){
                    seta(tabuleiro, x1, y1, x2, y2);
                    this.getX();
                    JogoXadrez.capturadasPeloPreto.add(destino);
                    return true;

                }

            }

        }

        return false;
    }
    private void seta(Tabuleiro tabuleiro, int x1, int y1, int x2, int y2){

        Peca peca = tabuleiro.getBoard(x1, y1);
        Peca vazio = new Vazio(x1,y1);

        peca.setX(x2);
        peca.setY(y2);
        tabuleiro.setBoard(peca);
        tabuleiro.setBoard(vazio);
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
        return "T" + new String(super.cor+"").toUpperCase();
    }

    public Torre(int x, int y, char cor){

        super.cor = cor;
        super.setX(x);
        super.setY(y);
    }
}

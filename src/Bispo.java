public class Bispo extends Peca {

    @Override
    public boolean move(Tabuleiro tabuleiro, int x2, int y2) {



        return false;
    }

    private boolean isPosicaoValida(Tabuleiro tabuleiro, Peca peca, Peca destino, int x1,int y1, int x2, int y2){

        int SEx = x1 -1, SEy = y1 -1;   //Limite Superior Esquerdo
        int SDx = x1 +1, SDy = y1 -1;   //Limite Superior Direito
        int IEx = x1 -1, IEy = y1 +1;   //Limite Inferior Esquerdo
        int IDx = x1 +1, IDy = y1 +1;   //Limite Inferior Direito


        if(x2 == SEx && y2 == SEy && tabuleiro.getBoard(x2,y2).cor == 'b' && destino.cor == 'p' && JogoXadrez.vez){
            seta(tabuleiro, x1, y1, x2, y2);
            JogoXadrez.capturadasPeloBranco.add(destino);
            return true;
        }
        else if(x2 == SEx && y2 == SEy && tabuleiro.getBoard(x2,y2).cor == 'p' && destino.cor == 'b' && JogoXadrez.vez){
            seta(tabuleiro, x1, y1, x2, y2);
            JogoXadrez.capturadasPeloPreto.add(destino);
            return true;
        }
        while(SEx >= 0 && SEy >= 0 && tabuleiro.getBoard(SEx,SEy).isVazio){
            SEx--;
            SEy--;
            if(x2 == SEx && y2 == SEy){
                seta(tabuleiro, x1, y1, x2, y2);
                return true;
            }
        }

        if(x2 == SDx && y2 == SDy && tabuleiro.getBoard(x2,y2).cor == 'b' && destino.cor == 'p' && JogoXadrez.vez){
            seta(tabuleiro, x1, y1, x2, y2);
            JogoXadrez.capturadasPeloBranco.add(destino);
            return true;
        }
        else if(x2 == SDx && y2 == SDy && tabuleiro.getBoard(x2,y2).cor == 'p' && destino.cor == 'b' && JogoXadrez.vez){
            seta(tabuleiro, x1, y1, x2, y2);
            JogoXadrez.capturadasPeloPreto.add(destino);
            return true;
        }
        while(SDx < 8 && SDy >= 0 && tabuleiro.getBoard(SDx,SDy).isVazio){
            SDx++;
            SDy--;
            if(x2 == SDx && y2 == SDy){
                seta(tabuleiro, x1, y1, x2, y2);
                return true;
            }
        }
        
        while(IEx >= 0 && IEy < 8 && tabuleiro.getBoard(IEx,IEy).isVazio){
            IEx--;
            IEy++;
        }
        while(IDx <8 && IDy < 8 && tabuleiro.getBoard(IDx,IDy).isVazio){
            IDx++;
            IDy++;
        }


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
        return "B"+new String(super.cor+"").toUpperCase();
    }

    public Bispo(int x, int y, char cor){

        super.cor = cor;
        super.setX(x);
        super.setY(y);
    }
}

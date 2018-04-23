public class Tabuleiro {

    public Peca[][] board = new Peca[8][8];
    public Peca[] capturados;
    int qtdCapturados = 0;

    public Peca getBoard(int x, int y) {

        if(x >= 0 && x < 8 && y >= 0 && y <8) {
            return board[x][y];
        }
        return null;
    }

    public void setBoard(Peca peca) {
        this.board[peca.getX()][peca.getY()] = peca;
    }

    public Tabuleiro(){
        preenche();
    }
    public void preenche(){

        for(int i = 0; i < 8 ; i++){
            for (int j = 2; j < 6; j++){

                this.setBoard(new Vazio(i,j));
            }
        }

        for (int i = 0; i < 8; i++){
            this.setBoard(new Peao(i,1,'b'));
            this.setBoard(new Peao(i,6,'p'));
        }

        this.setBoard(new Cavalo(1,0,'b'));
        this.setBoard(new Cavalo(6,0,'b'));

        this.setBoard(new Cavalo(1,7,'p'));
        this.setBoard(new Cavalo(6,7,'p'));

        this.setBoard(new Torre(0,0,'b'));
        this.setBoard(new Torre(7,0,'b'));

        this.setBoard(new Torre(0,7,'p'));
        this.setBoard(new Torre(7,7,'p'));

        this.setBoard(new Bispo(2,0,'b'));
        this.setBoard(new Bispo(5,0,'b'));

        this.setBoard(new Bispo(2,7,'p'));
        this.setBoard(new Bispo(5,7,'p'));

        this.setBoard(new Rainha(4,0,'b'));
        this.setBoard(new Rei(3,0,'b'));

        this.setBoard(new Rainha(3,7,'p'));
        this.setBoard(new Rei(4,7,'p'));
    }

    public void setCapturados(Peca capturada) {
        this.capturados[qtdCapturados] = capturada;
        qtdCapturados++;
    }

    public void exibeTabuleiro(){

        System.out.println("  1  2  3  4  5  6  7  8");
        for (int i = 0; i < 8; i++){

            System.out.printf("%d|",(i+1));
            for(int j = 0; j < 8; j++){

                System.out.print(this.getBoard(j,i) +" ");

            }

            System.out.println();
        }

    }
}

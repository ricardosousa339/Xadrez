import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JogoXadrez {

    Tabuleiro tabuleiro = new Tabuleiro();

    public static List<Peca> capturadasPeloBranco;
    public static List<Peca> capturadasPeloPreto;


    public static boolean vez = true;

    public JogoXadrez(){
        this.tabuleiro = tabuleiro;
        this.capturadasPeloBranco = new ArrayList<Peca>();
        this.capturadasPeloPreto = new ArrayList<Peca>();
    }

    public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    JogoXadrez jogo = new JogoXadrez();


    int x1, y1, x2, y2;

        System.out.println("ESCOLHA UMA OPÇÃO:\n1.NOVO JOGO\n2.SAIR(digite \"-1\"a qualquer momento para sair)");
    String op = input.next();

        while (!op.equalsIgnoreCase("2")){

        jogo.tabuleiro.exibeTabuleiro();
        System.out.println("\nJOGADOR "+ (JogoXadrez.vez ? "BRANCO" : "PRETO") + " SUA VEZ:");
        System.out.print("\nPOSIÇÃO DA PEÇA A SER MOVIDA\nx: ");
        x1 = input.nextInt()-1;
        if(x1 == -2)
            break;
        System.out.print("y: ");
        y1 = input.nextInt()-1;
        if(y1 == -2)
            break;
        System.out.print("POSIÇÃO DE DESTINO\nx: ");
        x2 = input.nextInt()-1;
        if(x2 == -2)
            break;
        System.out.print("y: ");
        y2 = input.nextInt()-1;
        if(y2 == -2)
            break;


        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        if(jogo.tabuleiro.getBoard(x1,y1) != null && jogo.tabuleiro.getBoard(x1,y1).move(jogo.tabuleiro,x2,y2)){
            JogoXadrez.vez = !JogoXadrez.vez;
        }
        else {
            System.out.println("JOGADA INVÁLIDA!\n");
        }


        System.out.print("\nCapturadas pelo branco: \n{");
        for (Peca p : JogoXadrez.capturadasPeloBranco){

            System.out.println(" "+ p);
            System.out.print(",");
        }
        System.out.print("}\n");
        System.out.print("\nCapturadas pelo preto: \n{");
        for (Peca p:JogoXadrez.capturadasPeloPreto) {
            System.out.print(" " +p);
            System.out.print(",");
        }
        System.out.print("}\n");

    }
}

}

import java.util.Random;

public class Main{
    public static void main(String[]args){
        int n = Integer.parseInt(args[0]);

        int totalA = Integer.parseInt(args[1]);
        int totalB = Integer.parseInt(args[2]);
        int winsA = 0;
        int winsB = 0;
        int coinThrows = 0;
        int aheadA = 0;
        int aheadB = 0;
        int tie = 0;
        int gameAheadA = 0;
        int gameAheadB = 0;
        int gameAheadTie = 0;

        for (int i=0; i<n; i++){
            while(totalA != 0 && totalB != 0){
                int rand = new Random().nextInt(0, 2);
                coinThrows++;
                if(rand == 0){
                    if(totalB != 0){
                        totalB--;
                    }
                } else if (rand == 1) {
                    if (totalA != 0){
                        totalA--;
                    }
                }
                if(totalA > totalB){
                    aheadA++;
                }else if(totalB > totalA){
                    aheadB++;
                }else{
                    tie++;
                }
            }

            if (totalB == 0){
                winsA++;
            }else{
                winsB++;
            }

            if(aheadA > aheadB){
                gameAheadA++;
            }else if(aheadB > aheadA){
                gameAheadB++;
            }else{
                gameAheadTie++;
            }

            aheadA = 0;
            aheadB = 0;
            totalA = Integer.parseInt(args[1]);
            totalB = Integer.parseInt(args[2]);
        }

        System.out.println("Qtd de vitorias de A: " + winsA + " (" + winsA*100/n + "%" + ")");
        System.out.println("Qtd de vitorias de B: " + winsB + " (" + (100 - (winsA*100)/n) + "%)");
        System.out.println("Média de lançamentos de moedas por jogo: " + coinThrows/n);
        System.out.println("Quantidade de jogos em que A ficou na frente: " + gameAheadA + " (" + (gameAheadA*100)/n + "%)");
        System.out.println("Quantidade de jogos em que B ficou na frente: " + gameAheadB + " (" + (gameAheadB*100)/n + "%)");
        System.out.println("Quantidade de jogos de vitórias empatadas: " + gameAheadTie + " (" + (100 - (gameAheadA*100)/n - (gameAheadB*100)/n) + "%)");
    }
}
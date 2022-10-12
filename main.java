
public class Main{

  public static void main(String[] args) {

    int n = Integer.parseInt(args[0]);
    double pontA = Double.parseDouble(args[1]);
    double pontB = Double.parseDouble(args[2]);
    String first = args[3];
    String second = (first.equals("A")) ? "B" : "A";

    System.out.println("----------------------------------------------------");
    
    System.out.println("n = " + n);
    System.out.println("Pont A = " + pontA);
    System.out.println("Pont B = " + pontB);
    System.out.println("First = " + first);

    System.out.println("----------------------------------------------------");
    
    int winsFirst = 0;
    int winsSecond = 0;

    for(int i = 0; i < n; i++){

      double winner = duel(pontA, pontB, first);

      if(winner == 1){
        System.out.println(first + " ganhou!");
        winsFirst++;
      }else{
        System.out.println(second + " ganhou!");
        winsSecond++;
      }
    }

    System.out.println("Wins " + first + ": " + winsFirst);
    System.out.println("Wins " + second + ": " + winsSecond);
  }

  public static int duel(double pontA, double pontB, String first){

    boolean shoot = false;
    double pont1, pont2 = 0.0;

    if(first.equals("A")){
        pont1 = pontA;
        pont2 = pontB;
    }else{
        pont1 = pontB;
        pont2 = pontA;
    }

    do{
        shoot = Math.random() < pont1;

        if(shoot){
            return 1;
        }else{
            shoot = Math.random() < pont2;

            if(shoot){
                return 2;
            }
        }
    }while(!shoot);
    return 0;
  }
}
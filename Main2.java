import java.util.ArrayList;

public class Main {
  public static void main(String[] args){

    int n = Integer.parseInt(args[0]);

    System.out.println("----------------------------------------------------");

    System.out.println("n = " + n);

    System.out.println("----------------------------------------------------");

    int winsFirst = 0;
    int winsSecond = 0;
    int winsThird = 0;

    for(int i = 0; i < n; i++){
      int winner = truel();

      if(winner == 1){
          winsFirst++;
      }else if(winner == 2){
          winsSecond++;
      }else if(winner == 3){
          winsThird++;
      }
    }
    System.out.println("Wins first: " + winsFirst + " (" + (winsFirst*100)/n + "%)");
    System.out.println("Wins second: " + winsSecond + " (" + (winsSecond*100)/n + "%)");
    System.out.println("Wins third: " + winsThird + " (" + (100 - (winsFirst*100)/n - winsSecond*100/n) + "%)");
  }

  public static int truel(){

    int shootCount = 0;
    ArrayList<Integer> survivers = new ArrayList<Integer>();
    survivers.add(1);
    survivers.add(2);
    survivers.add(3);

    double pont1 = (0.67);
    double pont2 = (0.83);
    double pont3 = (0.33);

    do{

      if( survivers.contains(1) && Math.random() < pont1){

        shootCount++;
        if(survivers.contains(2)){
          survivers.remove(survivers.indexOf(2));
        }else{
          survivers.remove(survivers.indexOf(3));
        }

      }else{

        if(survivers.contains(2) && Math.random() < pont2){
          shootCount++;
          if(survivers.contains(1)){
            survivers.remove(survivers.indexOf(1));
          }else{
            survivers.remove(survivers.indexOf(3));
          }

        }else{

          if(survivers.contains(3) && Math.random() < pont3){
            shootCount++;
            if(survivers.contains(2)){
              survivers.remove(survivers.indexOf(2));
            }else{
              survivers.remove(survivers.indexOf(1));
            }
          }

        }
      }
    }while(survivers.size() > 1);
    return survivers.get(0);
  }
}
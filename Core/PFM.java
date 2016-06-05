/*
    Produit minimum
*/
import java.util.Scanner;

public class PFM{
    public PFM(){
        int tour=0;
        int choice;
        boolean trig=true;
        Scanner input = new Scanner(System.in);

        Trainer t1 = new Trainer("Red", "Pakachu", 1, 15, 15);
        Trainer t2 = new Trainer("Blue", "Silimeche", 1, 15, 15);

        t1.team[0].add_ability("Charge", 5, 50, 0.2, Type.NORMAL, 0);
        t1.team[0].add_ability("Coupd'pat", 5, 10, 1, Type.NORMAL, 1);

        t2.team[0].add_ability("Charge", 5, 50, 0.2, Type.NORMAL, 0);
        t2.team[0].add_ability("Coupd'pat", 5, 10, 1, Type.NORMAL, 1);

        Fight f = new Fight(t1, t2);

        while(trig){
            if(tour==0){
                System.out.println("It's Red turn !");
                System.out.println( t1.team[0].name + " has " + t1.team[0].current.hp + "HP");
            }else {
                System.out.println("It's Blue turn !");
                System.out.println( t2.team[0].name + " has " + t2.team[0].current.hp + "HP");
            }

            System.out.println("Select abilty :");
            System.out.println("1 : Charge");
            System.out.println("2 : Coupd'pat");

            choice = input.nextInt();

            System.out.println("Ennemis take " + f.turn(tour, choice-1) + " damage !");

            if(t1.team[0].current.hp==0 || t2.team[0].current.hp==0){
                trig = false;
                if(t2.team[0].current.hp==0)
                    System.out.println("Red win");
                else
                    System.out.println("Blue win");
            }else {
                tour = (tour + 1) % 2;
            }

        }

    }


    public static void main(String[] arg){
        new PFM();
    }
}
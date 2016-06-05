import java.util.Random;

public class Ability{
    public String name;
    private int max_pp;//pareil pour les pp
    private int power;
    private int pp;
    private double pre;

    public Ability(String name, int max_pp, int power, double pre){

    }

    public int use(){
        Random rand;
        pp--;
        if(rand.nextDouble()<pre)
            return power;
        else
            return 0;
    }

    Power
}

import java.util.Random;

public class Ability{
    public String name;
    private int max_pp;//pareil pour les pp
    private int power;
    private int pp;
    private double pre;
    private Type type;


    public Type getType(){
        return type;
    }

    public Ability(String nam, int max_pp, int pow, double pr, Type typ){
        name=nam;
        pp=max_pp;
        power=pow;
        pre=pr;
        type=typ;
    }

    public int use(){
        Random rand = new Random();
        pp--;
        if(rand.nextDouble()<pre)
            return power;
        else
            return 0;
    }
}

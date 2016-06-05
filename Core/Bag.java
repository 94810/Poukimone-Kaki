public class Bag{
    private int popo;
    private int oil;

    public void list(){
        System.out.print("You got "+popo+" Potions");
        System.out.print("You got "+oil+" Oil");
    }

    public boolean useHeal(){
       if(popo>0) {
           popo--;
           return true;
       }else
           return false;
    }

    public boolean useMana(){
        if(oil>0){
            oil--;
            return true;
        }else
            return false;
    }

    public boolean addItem(String str) {
        boolean res=true;

        if("Mana".equals(str))
            oil++;
        else if("Popo".equals(str))
            popo++;
        else
            res=false;
        return res;
    }
    public Bag(int popo, int mana){

    }
}

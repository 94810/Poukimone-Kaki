public class Stats implements Cloneable {
    public int att;
    public int def;
    public int spd;
    public int lvl;
    public int xp;
    public int hp;
    public int max_hp;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
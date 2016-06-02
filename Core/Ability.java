public class Ability{
    public String name;
    public String type;
    private int max_pp;//pareil pour les pp
    private int power;
    private int att_red;
    private int def_red;
    private int vit_red;
    public int pp;

    public Ability(String name, int max_pp, int power, int att_red, int def_red, int vit_red, String type) {
        pp=max_pp;
    }

}

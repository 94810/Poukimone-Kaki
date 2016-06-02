public class Trainer{
    private String name;
    private Poukimone team[];
    public Bag inventaire;

    public Trainer (String n, Poukimone starter){ //On a forcement 1 pkm et 1nm
        name=n;
        team[1]=starter;
    }
}
public class Trainer{
    private String name;
    public Poukimone team[];
    public Bag inventaire;

    public Trainer (String n, String starter, int starter_levl, int potions, int oils){ //On a forcement 1 pkm et 1nm
        team = new Poukimone[6];
        name=n;
        team[0]=new Poukimone (starter, starter_levl);
        inventaire= new Bag (potions, oils);
    }
}
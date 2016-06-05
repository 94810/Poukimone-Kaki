/*
				==TODO==
*/

//Include pour parser Json
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
//Fin include pour parseur Json


public class Poukimone {
    public String name;
	public Type type;

	public Stats base;
	public Stats current;

    public int next_level_exp;
    private int exp_curve;

    public Ability[] abilites;


	/* Methodes*/
    private void level_up(){
    	current.lvl++;
    	current.max_hp=base.hp*(1/50)+current.hp;
    	current.hp=base.hp*(1/50)+current.hp;
    	current.att=base.att*(1/50)+current.att;
    	current.def=base.def*(1/50)+current.def;
    	current.spd=base.spd*(1/50)+current.spd;
    	current.xp=0;
    	next_level_exp=calc_exp();
    }
	private void set_level(int level){
		if (current.lvl<level){
			while (current.lvl!=level){
				level_up();
			}
		}
	}

    public int calc_exp(){
    	int res=0;
		int k=current.lvl++;
    	switch (exp_curve){
    		case 1:
    			res=(int)(0.8*(k*k*k));
    		break;
    		case 2:
    			res=k*k*k;
    		break;
    		case 3:
    			res=(int)(1.2*(k*k*k))-(15*(k*k))+(100*k)-140;
    		break;
    		case 4:
    			res=(int) (1.25*(k*k*k));
    		break;
    	}
    	return res;
    }
    public Poukimone(String spices, int level){
    	//TODO: verfier que le pokémon est valide!!

		base = new Stats();
		current = new Stats();

		name=spices;
		this.get_base();
		current.lvl=1;

    	if (exp_curve==3) {
			next_level_exp = 63;//voir "Bug de l'expérience" sur Pokémon G1 et 2
		}else{
    		next_level_exp=calc_exp();
    	}

		abilites = new Ability[4]; //TODO Need choose UI for Ability
		set_level(level);
	}
    public void take_damage (Poukimone atk, int AbilityNb){
    	int dmg=0;
    	dmg=(int)((((((current.lvl*0.4)+2)*atk.current.att*atk.use_ability(AbilityNb))/(current.def*50))+2)*Type.compare(atk.type,type));
    	if (dmg > 0) {
			current.hp = current.hp - dmg;
			if (current.hp < 1) {
				kill();
			}
		}else
			System.out.print("Miss !");
    }

    public int use_ability (int AbIndex){
		return abilites[AbIndex].use();
    }

	private void get_base(){
		JSONParser parser = new JSONParser();
		try{
		Object obj = parser.parse(new FileReader("./poukimone.json"));

		JSONArray pkm = (JSONArray) obj;

		boolean trig=false;

		for(Object objd : pkm) {
			JSONObject root = (JSONObject) objd;
			if(name.equals((String) root.get("name"))){
				trig = true;
				base.lvl = 1;
				base.att = Integer.parseInt((String) root.get("att"));
				base.def = Integer.parseInt((String) root.get("def"));
				base.spd = Integer.parseInt((String) root.get("spd"));
				base.xp = Integer.parseInt((String) root.get("xp"));
				type = (Type) root.get("type");
				exp_curve = Integer.parseInt((String) root.get("curve"));
			}
		}

		} catch (FileNotFoundException e) {
		e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		} catch (ParseException e) {
		e.printStackTrace();
		}

	}

	private void kill(){
		current.hp=0;
	}

	public boolean is_dead(){
		if(current.hp==0)
			return true;
		else
			return false;
	}

}


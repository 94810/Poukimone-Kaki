/*
	==TODO==

*/
public class Poukimone {
    public String name;
    public int hp;
    public int max_hp;// Besoin de le garder car il ya des objets de soin!
    public int att;
    public int def;
    public int spd;
    public int lvl;// j'étais pas sur si il fallait mettre ça la, mais si il a des stats definies, forcément le level est déja instancié
    public int next_level_exp;
    public int exp_value; //Combien il rapporte en exp quand il est vaincu. faudrait peut-être envoyer un mail a Anu pour avoir des précisions sur comment la gérer?
    private int exp;
    private int exp_curve;//1 rapide,2 moyenne, 3 parabolique, 4 lente.
    public Ability[] abilites;

	/* Methodes*/
    private void level_up(){
    	lvl++;
    	max_hp=get_base(name, "hp")*(1/50)+max_hp;
    	hp=get_base(name,"hp")*(1/50)+hp;
    	att=get_base(name, "att")*(1/50)+att;
    	def=get_base(name, "def")*(1/50)+def;
    	spd=get_base(name, "spd")*(1/50)+spd;
    	exp=0;
    	next_level_exp=calc_exp();
    }

    public int calc_exp(){
    	int res=0;
		int k=lvl++;
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
    public Poukimone(String spices){
    	//TODO: verfier que le pokémon est valide!!
    	name=spices;
    	lvl=1;
    	exp_curve=get_base(name, "curve");
    	if (exp_curve==3) {
			next_level_exp = 63;//voir "Bug de l'expérience" sur Pokémon G1 et 2
		}else{
    		next_level_exp=calc_exp();
    	}
    	max_hp=get_base(name, "hp");
    	hp=get_base(name,"hp");
    	att=get_base(name, "att");
    	def=get_base(name, "def");
    	spd=get_base(name, "spd");
    	exp_value=get_base(name,"value");
    }
    public void take_damage (int foe_power, int foe_att){
    	int dmg=0;
    	dmg=(int)((((lvl*0.4)+2)*foe_att*foe_power)/(def*50))+2;
    	if (dmg > 0) {// pas sûr que ça soit très utile...
			hp = hp - dmg;
			if (hp < 1) {
				kill();
			}
		}
    }
    public void use_ability (Ability attack){
			exp++;
    }

	private int get_base(String name, String  field){
		int fake_var=12;
		return fake_var;
	}

	private void kill(){

	}
}

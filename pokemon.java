public class Ability{
	public String name;
	public int max_pp;//pareil pour les pp
	public int power;
	
	ability(String name, int max_pp, int power){
	}
}

public class Poukimone_ability extends ability{
	public int pp;
	poukimone_ability(){
		pp=super.max_pp;
	}
}

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
    public int exp;
    public int exp_curve;//1 rapide,2 moyenne, 3 parabolique, 4 lente.
    public Poukimone_ability[] abilites;
    /* Methodes*/
    int level_up(){
    	lvl++;
    	max_hp=get_base(name, "hp")*(1/50)+max_hp;
    	hp=get_base(name,"hp")*(1/50)+hp;
    	att=get_base(name, "att")*(1/50)+att;
    	def=get_base(name, "def")*(1/50)+def;
    	spd=get_base(name, "spd")*(1/50)+spd;
    	exp=0;
    	next_level_exp=calc_exp();
    }
    int calc_exp(){
    	int res;
    	int k=lvl++;
    	switch exp_curve{
    		case 1:
    			res=(0.8*(k**3));
    		break;
    		case 2:
    			res=k**3;
    		break;
    		case 3:
    			res=(1.2*(k**3))-(15*(k**2))+(100*k)-140;
    		break;
    		case 4:
    			res=1.25*(k**3);
    		break;
    	}
    	return res;
    }
    poukimone(String spices){
    	//TODO: verfier que le pokémon est valide!!
    	name=spices;
    	lvl=1;
    	exp_curve=get_base(name, "curve");
    	if (exp_curve==3){
    		next_level_exp=63;//voir "Bug de l'expérience" sur Pokémon G1 et 2
    		else
    		next_level_exp=calc_exp();
    	}
    	max_hp=get_base(name, "hp");
    	hp=get_base(name,"hp");
    	att=get_base(name, "att");
    	def=get_base(name, "def");
    	spd=get_base(name, "spd");
    	exp_value=get_base(name,"value");
    }
    public take_damage (int foe_power, int foe_att){
    	int dmg=0;
    	dmg=((((lvl*0.4)+2)*foe_att*foe_power)/(def*50))+2;
    	if (dmg > 0){// pas sûr que ça soit très utile...
    		hp=hp-dmg;
    		if (hp < 1){
    			is_dead();
    		}
    	}
    }
    public use_ability(Poukimone_ability attack){
 
    }
}
public class Bag{
	
}

public class Trainer{
	public String name;
	public Poukimone[] team;
	public Bag inventaire;
}

public class Fight{
	public Trainer[] trainers;
	public Poukimone[] fighters;
}






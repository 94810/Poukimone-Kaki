/*
				==TODO==

*/
package com.mkyong.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Stats{
	public int att;
	public int def;
	public int spd;
	public int lvl;
	public int xp;
	public int hp;
}


public class Poukimone {
    public String name;
	public String type;

	public Stats base;
	public Stats current;

    public int next_level_exp;
    private int exp_curve;

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
    public void take_damage (int foe_power, int foe_att, Type ow_type, Type boum_type){
    	int dmg=0;
    	dmg=(int)(((((lvl*0.4)+2)*foe_att*foe_power)/(def*50))+2)*Type.compare(boum_type,ow_type);
    	if (dmg > 0) {
			hp = hp - dmg;
			if (hp < 1) {
				kill();
			}
		}else
			System.out.print("Miss !");
    }

    public void use_ability (Ability attack){
			exp++;
    }

	private void get_base(String name, String field){
		ObjectMapper mapper = new OjectMapper();

		JsonNode rootArr = mapper.readTree(new File("./poukimone.json"));

		boolean trig=false;

		for(JsonNode root : rootArr) {
			if(name.equals(root.path("name").asText())){
				trig=true;
				base.lvl = 1;
				base.att = root.path("att").asInt();
				base.def = root.path("def").asInt();
				base.spd = root.path("spd").asInt();
				base.xp = root.path("exp").asInt();
				type = root.path("type").asInt();
			}
		}

	}

	private void kill(){

	}

	public boolean is_dead(){
		if(hp==0)
			return true;
		else
			return false;
	}
}

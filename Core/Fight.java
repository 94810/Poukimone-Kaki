public class Fight{
    public Trainer[] trainers;
    private int[] selectPkm;
    public Trainer winner;
    public Trainer loser;


  //deroulement du combat
    //
    public Fight(Trainer t1, Trainer t2){
        trainers = new Trainer[2];
        trainers[0] = t1;
        trainers[1] = t2;

        selectPkm = new int[2];
        selectPkm[0] = 0;
        selectPkm[1] = 0;

    }

    private void turn(int t, int abili){
        trainers[t].team[selectPkm[t]].take_damage(trainers[(t + 1) % 2].team[selectPkm[(t + 1) % 2]], abili);
    }

    public void setSelectPkm(int i, int pkm){

    }

    public int rest_of_poukimone(int t){
        int res = 0;
        for (int i=0; i<=trainers[t].team.length; i++){
            if(trainers[t].team[i].is_dead()==false)
               res = 1;
        }
        return res;
    }


    public boolean winner(){

        if (rest_of_poukimone(2)==0){
            winner=trainers[1];
            loser=trainers[2];
            return true;
        }

        if (rest_of_poukimone(1)==0){
            winner=trainers[2];
            loser=trainers[1];
            return true;
        }

        return false;
    }

}


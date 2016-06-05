public class Fight{
    public Trainer[] trainers;
    private int[] selectPkm;
    public trainer winner;
    public trainer loser;

  //deroulement du combat
    //
    public Fight(Trainer t1, Trainer t2){
        trainers = new Trainer[2];
        trainers[0] = t1;
        trainers[1] = t2;

        selectPkm = new int[2]{1,1};
        if (trainers[0].poukimone[0].current.spd>trainers[0].poukimone[0].current.spd)
            thi.turn(0);
        else
            this.turn(1);
    }

    private void turn(int t, int abili){
        trainers[t].poukimone[selectPkm[t]].take_damage(trainers[(t + 1) % 2].poukimone[selectPkm[(t + 1) % 2]], abili)

        if (!this.winner) //We go until we have a winner
            this.turn((t + 1) % 2);
    }

    public int rest_of_poukimone(int t){
        for (int i=0, i<=Trainer[t].poukimoune.length,i++){
            if(poukimoune[i].is_dead==false)
               return 1;
        }
    }


    public boolean winner(){

        if (rest_of_poukimone(2)==0){
            winner=trainner[1];
            loser=trainner[2];
            return true;
        }

        if (rest_of_poukimone(1)==0){
            winner=trainner[2];
            loser=trainner[1];
            return true;
        }

        return false;
    }

}


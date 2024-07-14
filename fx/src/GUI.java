
public class GUI {
    public static void main(String[] args) {
        Karte.main(args);
        createTeam1();
        createTeam2();
        

    }

    //Team von Objekten in ein Array
    public static Troops[] createTeam1(){
        Troops[] team1 = new Troops[8];

        team1[0] = new Soldier(2,8);
        team1[1] = new Fighterplain(3,6);
        team1[2] = new MechanizedInfantry(4,6);
        team1[3] = new MobileArtillery(2,3);
        team1[4]= new Tank(7,4);
        team1[5] = new Bomber(3,6);
        team1[6] = new BattleCopter(9,5);
        team1[7] = new AntiAir(1,2);

        return team1;
    }

    public static Troops[] createTeam2(){
        Troops team2[] = new Troops[8];

        team2[0] = new Soldier(9,1);
        team2[1] = new Fighterplain(2,1);
        team2[2] = new MechanizedInfantry(3,1);
        team2[3] = new MobileArtillery(4,3);
        team2[4]= new Tank(3,2);
        team2[5] = new Bomber(2,2);
        team2[6] = new BattleCopter(1,1);
        team2[7] = new AntiAir(7,7);

        return team2;
    }

}
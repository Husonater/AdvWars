
public class GUI {
    public static void main(String[] args) {
        Karte.main(args);
        createTeam1();
        createTeam2();

    }


    public static Troops[] createTeam1(){
        Troops team1[] = new Troops[7];

        team1[0] = new Soldier(2,8);
        team1[1] = new Fighterplain();
        team1[2] = new MechanizedInfantry();
        team1[3] = new MobileArtillery();
        team1[4]= new Tank();
        team1[5] = new Bomber();
        team1[6] = new BattleCopter();
        team1[7] = new AntiAir();

        return team1;
    }

    public static Troops[] createTeam2(){
        Troops team2[] = new Troops[7];

        team2[0] = new Soldier();
        team2[1] = new Fighterplain();
        team2[2] = new MechanizedInfantry();
        team2[3] = new MobileArtillery();
        team2[4]= new Tank();
        team2[5] = new Bomber();
        team2[6] = new BattleCopter();
        team2[7] = new AntiAir();

        return team2;
    }

}
class IPLMINUSTWO {
    String teamname, team2name;
    int runs, runs1, wickets, wickets2, ballsplayed, ballsplayed2;

    IPLMINUSTWO(String teamname, int runs, int wickets, int ballsplayed,
            String team2name, int runs1, int wickets2, int ballsplayed2) {
        this.teamname = teamname;
        this.team2name = team2name;
        this.runs = runs;
        this.runs1 = runs1;
        this.wickets = wickets;
        this.wickets2 = wickets2;
        this.ballsplayed = ballsplayed;
        this.ballsplayed2 = ballsplayed2;
    }

    // win or lose
    int winlose(IPLMINUSTWO obj, finaltable ob, finaltable ob1) {
        if (runs > runs1) {
            System.out.print(teamname + " " + runs + "/" + wickets + " " + ballsplayed + " " + team2name + " " + runs1
                    + "/" + wickets2 + " " + ballsplayed2);
            ob.points += 2;
            return 1;
        } else {
            System.out.println(team2name + " " + runs1 + "/" + wickets2 + " " + ballsplayed2 + " " + teamname + " "
                    + runs + "/" + wickets + " " + ballsplayed);
            ob1.points += 2;
            return 2;
        }
    }

    void rr(IPLMINUSTWO obj) {
        int rr = (runs - runs1) / 2;

    }

}

class finaltable {
    String teamname;
    int points;
    int place, runrate;

    finaltable(String teamname, int points, int place) {
        this.teamname = teamname;
        this.points = points;
        this.place = place;
        this.runrate = runrate;
    }

    public static void main(String[] args) {
        finaltable MI = new finaltable("mi", 0, 0);
        finaltable RCB = new finaltable("rcb", 0, 0);
        finaltable RR = new finaltable("rr", 0, 0);
        finaltable SRH = new finaltable("srh", 0, 0);
        finaltable CSK = new finaltable("csk", 0, 0);
        finaltable KKR = new finaltable("kkr", 0, 0);
        finaltable DC = new finaltable("dc", 0, 0);
        finaltable PBKS = new finaltable("pbks", 0, 0);

        IPLMINUSTWO m1 = new IPLMINUSTWO("csk", 131, 9, 120, "srh", 117, 8, 120);
        m1.winlose(m1, CSK, SRH);
    }
}
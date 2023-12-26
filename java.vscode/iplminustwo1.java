import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class iplminustwo1 {
    String teamname, team2name;
    int runs, runs1, wickets, wickets2, ballsplayed, ballsplayed2;

    public iplminustwo1() {
    }

    public iplminustwo1(String teamname, int runs, int wickets, int ballsplayed,
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
    int winlose(iplminustwo1 obj, finaltable ob, finaltable ob1) {
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

    public static void main(String[] args) {
        finaltable MI = new finaltable("mi", 0, 0, 0);
        finaltable RCB = new finaltable("rcb", 0, 0, 0);
        finaltable RR = new finaltable("rr", 0, 0, 0);
        finaltable SRH = new finaltable("srh", 0, 0, 0);
        finaltable CSK = new finaltable("csk", 0, 0, 0);
        finaltable KKR = new finaltable("kkr", 0, 0, 0);
        finaltable DC = new finaltable("dc", 0, 0, 0);
        finaltable PBKS = new finaltable("pbks", 0, 0, 0);

        iplminustwo1 ipl = new iplminustwo1();
        iplminustwo1 m1 = new iplminustwo1("csk", 116, 9, 120, "srh", 117, 8, 120);
        iplminustwo1 m2 = new iplminustwo1("csk", 116, 9, 120, "srh", 117, 8, 120);
        iplminustwo1[] arr = new iplminustwo1[54];
        for (int i = 0; i < 54; i++) {
            Scanner sc = new Scanner(System.in);
            String a = sc.nextLine();
            int r = sc.nextInt();
            int w = sc.nextInt();
            int rb = sc.nextInt();
            String aa = sc.nextLine();
            int rr = sc.nextInt();
            int ww = sc.nextInt();
            int rbw = sc.nextInt();
            arr[i] = new iplminustwo1(a, r, i, ww, a, r, w, rbw);
            ipl.winlose(m2, DC, PBKS);
        }
        System.out.println(SRH.points);
        m1.winlose(m2, CSK, SRH);
        table obb = new table();
        obb.pointstable(MI, RCB, RR, SRH, CSK, KKR, DC, PBKS);
    }

}

class finaltable {
    String teamname;
    int points, place, runrate;

    finaltable(String teamname, int points, int place, int runrate) {
        this.teamname = teamname;
        this.points = points;
        this.place = place;
        this.runrate = runrate;
    }

    public String toString() {
        return this.teamname;
    }
}

class table {
    finaltable[] pointstable(finaltable ob1, finaltable ob2, finaltable ob3, finaltable ob4,
            finaltable ob5, finaltable ob6, finaltable ob7, finaltable ob8) {
        finaltable[] arr = { ob1, ob2, ob3, ob4, ob5, ob6, ob7, ob8 };

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].points < arr[j + 1].points) {
                    // Swap arr[j] and arr[j+1]
                    finaltable temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("\n Place 1 :   " + arr[0] +
                "\n Place 2 :   " + arr[1] +
                "\n Place 3 :   " + arr[2] +
                "\n Place 4 :   " + arr[3] +
                "\n Place 5 :   " + arr[4] +
                "\n Place 6 :   " + arr[5] +
                "\n Place 7 :   " + arr[6] +
                "\n Place 8 :   " + arr[7]);

        return arr;
    }
}
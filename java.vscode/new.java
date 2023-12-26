import java.util.Scanner;

class rohith {
    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);
        System.out.print("Enter: ");

        String var = scr.nextLine();

        switch (var) {
            case "rohith": {
                System.out.println("Hello");
                break;
            }

            case "vishnu": {
                System.out.println("world");
                break;
            }

            default: {

                System.out.println("Def");
            }

        }
    }
}
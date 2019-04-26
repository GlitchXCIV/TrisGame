import java.util.Scanner;

public class Play {
    public static void main(String[] args) {
        int round = 0;
        Character player = 'x';
        Tris game = new Tris();
        Scanner in = new Scanner(System.in);
        System.out.println("START");
        int row, col;
        String checkSign, newGame = "";
        do {
            do {
                System.out.print("ROW " + player + " : ");
                row = in.nextInt();
                if (row < 0) return;
                else if (row > 2) System.out.println("ERROR NUMBER");
                System.out.print("COL " + player + " : ");
                col = in.nextInt();
                if (col < 0) return;
                else if (col > 2) System.out.println("ERROR NUMBER");
                checkSign = game.played(row, col, player);
                if(checkSign.equalsIgnoreCase("nope")) {
                    System.out.println("already occupied, please try again\n");
                    if(player.equals('x')) player = 'x';
                    else player = 'o';
                }
            }
            while (row > 2 || col > 2 || checkSign.equalsIgnoreCase("nope"));
            System.out.println(game.printGrid());

            String check = game.getWinner();
            if(check.equalsIgnoreCase("==> X WIN") || check.equalsIgnoreCase("==> O WIN")) {

                System.out.println(check);
                game.resetGrid();
                round = 0;
                System.out.print("\n NEW GAME, YES o NO? ");
                newGame = in.next();
                player = 'o';
                System.out.println(" ");
            }

            round++;

            if (round == 9) {
                System.out.println("DRAW");
                game.resetGrid();
                round = 0;
                System.out.print("\n NEW GAME, YES o NO?");
                newGame = in.next();
                player = 'o';
                System.out.println(" ");
            }

            if (player.equals('x')) player = 'o';
            else player = 'x';
        }
        while(round < 9 || newGame.equalsIgnoreCase("yep"));
        return;
    }
}


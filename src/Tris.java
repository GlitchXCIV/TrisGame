public class Tris {
    // MATRIX 3*3 NULL
    public Tris() {
        grid = new String[x][y];
        for (int i = 0; i < x; i++)
            for (int j = 0; j < y; j++)
                grid[i][j] = " ";
    }

    public String printGrid() {
        String r = "";
        for (int i = 0; i < x; i++) {
            r = r + "|";

            for (int j = 0; j < y; j++)
                r = r + grid[i][j] + "|";

            r = r + "\n";
        }
        return r;
    }

    public String played(int i, int j, Character player) {
        try {
            if (grid[i][j].equals(" ")) {
                grid[i][j] = String.valueOf(player);
                return "yep";
            }
            else return "nope";
        }
        catch (IllegalArgumentException e) {
            return "nope";
        }
    }

    public String getWinner() {
        int a = 0;
        int b = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j].equals("x")) {
                    a++;
                    if (a == 3) return "==> X WIN";
                }
                else if (grid[i][j].equals("o")) {
                    b++;
                    if(b == 3) return "==> O WIN";
                }
            }
            a = 0;
            b = 0;
        }
        for(int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (grid[j][i].equals("x")) {
                    a++;
                    if(a == 3) return "==> X WIN";
                }
                else if (grid[j][i].equals("o")) {
                    b++;
                    if(b == 3) return "==> O WIN";
                }
            }
            a = 0;
            b = 0;
        }
        for(int i = 0; i < x; i++) {
            int j = i;
            if (grid[i][j].equals("x")) {
                a++;
                if(a == 3) return "==> X WIN";
            }
            else if (grid[i][j].equals("o")) {
                b++;
                if(b == 3) return "==> O WIN";
            }
        }
        a = 0;
        b = 0;
        int j = 2;

        for (int i = 0; i< x; i++) {
            if (grid[i][j].equals("x")) {
                a++;
                if(a == 3) return "==> X WIN";
            }
            else if (grid[i][j].equals("o")) {
                b++;
                if(b == 3) return "==> O WIN";
            }
            j--;
        }
        return "" ;
    }
    public void resetGrid(){
        for (int i = 0; i < x; i++)
            for (int j = 0; j < y; j++)
                grid[i][j] = " ";
    }
    private String[][] grid;
    private static final int x = 3;
    private static final int y = 3;
}
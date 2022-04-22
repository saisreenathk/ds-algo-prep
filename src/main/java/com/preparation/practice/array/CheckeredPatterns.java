package com.preparation.practice.array;

/*
Question to you from microsoft azure communication services team in april 2022
 */
enum Type {
    ROW, COLUMN
}

public class CheckeredPatterns {
    private int goldCount;

    public CheckeredPatterns(int goldCount) {
        this.goldCount = goldCount;
    }

    public int applyCheckeredPattern(char[][] grid, Type type, int position) {
        if (type.equals(Type.ROW)) {
            for (int i = 0; i < grid[0].length; i++) {//traverse the column
                if (grid[position][i] == 'G') {
                    grid[position][i] = 'B';//toggle to black
                    if (goldCount > 0) {
                        goldCount--;//decrement as cell is toggled to black
                    }
                } else {
                    goldCount++;
                    grid[position][i] = 'G';//toggle to Gold
                }
            }
        } else {
            for (int i = 0; i < grid.length; i++) {//traverse the row
                if (grid[i][position] == 'G') {
                    grid[i][position] = 'B';//toggle to black
                    if (goldCount > 0) {
                        goldCount--;//decrement as cell is toggled to black
                    }
                } else {
                    goldCount++;
                    grid[i][position] = 'G';//toggle to Gold
                }
            }
        }
        return goldCount;
    }

    public static void main(String[] args) {
        CheckeredPatterns checkerdPatterns = new CheckeredPatterns(0);
        char[][] grid = new char[3][4];
        //fill the grid with all black Color initially
        checkerdPatterns.fillGridWithBlack(grid);

        int position = 2;
        checkerdPatterns.goldCount = checkerdPatterns.applyCheckeredPattern(grid, Type.ROW, position);
        System.out.println("goldCount: " + checkerdPatterns.goldCount + " after applying Gold on row:" + position);

        position = 3;
        checkerdPatterns.applyCheckeredPattern(grid, Type.COLUMN, position);
        System.out.println("goldCount: " + checkerdPatterns.goldCount + " after applying Gold on row:" + position);

        checkerdPatterns.goldCount = checkerdPatterns.applyCheckeredPattern(grid, Type.ROW, 2);
        System.out.println("goldCount: " + checkerdPatterns.goldCount + " after applying Gold on row:" + position);

    }

    private void fillGridWithBlack(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = 'B';
            }
        }
    }
}

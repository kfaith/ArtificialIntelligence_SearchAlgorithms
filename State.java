public class State {


    int[][] GameState1 = {{1, 2, 3},
                             {4, 0, 5},
                             {6, 7, 8}};

    int[][] GameState2 = {{0, 1, 2},
                          {8, 4, 3},
                          {7, 6, 5}};

    int[][] GameState3 =  {{1, 6, 0},
                           {4, 8, 3},
                           {7, 2, 5}};

    int[][] GameState4 =   {{7, 6, 1},
                          {4, 8, 3},
                          {2, 0, 5}};

    int[][] GameState5 = {{0, 6, 1},
            {7, 3, 4},
            {2, 8, 5}};

    int[][] TestState = {{1, 2, 3},
                         {8, 0, 4},
                         {7, 6, 5}};

    int[][] GoalState = {{1, 2, 3},
                            {8, 0, 4},
                            {7, 6, 5}};





    public void formatState(int[][] array)
    {

        System.out.println(" ___________");
        System.out.println("| "+ array[0][0] + " | " + array[0][1] + " | " + array[0][2]+" |");
        System.out.println(" -----------");
        System.out.println("| "+ array[1][0] + " | " + array[1][1] + " | " + array[1][2]+" |");
        System.out.println(" -----------");
        System.out.println("| "+ array[2][0] + " | " + array[2][1] + " | " + array[2][2]+" |");
        System.out.println(" -----------");
    }
}

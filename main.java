
import java.util.Arrays;
import java.util.List;

//Author: Kyle Faith

public class main
{
    public static void main( String[] args ) {
        State state = new State();

        System.out.println("\nBFS - Game 1: \n");
        long startTime1 = System.nanoTime();
        BreadthFirstSearch BFS1 = new BreadthFirstSearch(state.GameState1, state.GoalState);
        long endTime1 = System.nanoTime();
        long timeTaken1 = (endTime1 - startTime1);
        System.out.println("Time Taken: "+ timeTaken1/1000000 + " milliseconds");

        long startTime2 = System.nanoTime();
        System.out.println("\nBFS - Game 2: \n");
        BreadthFirstSearch BFS2 = new BreadthFirstSearch(state.GameState2, state.GoalState);
        long endTime2 = System.nanoTime();
        long timeTaken2 = (endTime2 - startTime2);
        System.out.println("Time Taken: "+ timeTaken2/1000000 + " milliseconds");

        long startTime3 = System.nanoTime();
        System.out.println("\nBFS - Game 3: \n");
        BreadthFirstSearch BFS3 = new BreadthFirstSearch(state.GameState3, state.GoalState);
        long endTime3 = System.nanoTime();
        long timeTaken3 = (endTime3 - startTime3);
        System.out.println("Time Taken: "+ timeTaken3/1000000 + " milliseconds");

        long startTime4 = System.nanoTime();
        System.out.println("\nBFS - Game 4: \n");
        BreadthFirstSearch BFS4 = new BreadthFirstSearch(state.GameState4, state.GoalState);
        long endTime4 = System.nanoTime();
        long timeTaken4 = (endTime4 - startTime4);
        System.out.println("Time Taken: "+ timeTaken4/1000000 + " milliseconds");

        long startTime5 = System.nanoTime();
        System.out.println("\nBFS - Game 5: \n");
        BreadthFirstSearch BFS5 = new BreadthFirstSearch(state.GameState5, state.GoalState);
        long endTime5 = System.nanoTime();
        long timeTaken5 = (endTime5 - startTime5);
        System.out.println("Time Taken: "+ timeTaken5/1000000 + " milliseconds");

        long startTime6 = System.nanoTime();
        System.out.println("\nDFID - Game 1: \n");
        DepthFirstIterativeDeepening DFIS1 = new DepthFirstIterativeDeepening(state.GameState1, state.GoalState, 10);
        long endTime6 = System.nanoTime();
        long timeTaken6 = (endTime6 - startTime6);
        System.out.println("Time Taken: "+ timeTaken6/1000000 + " milliseconds");

        long startTime7 = System.nanoTime();
        System.out.println("\nDFID - Game 2: \n");
        DepthFirstIterativeDeepening DFIS2 = new DepthFirstIterativeDeepening(state.GameState2, state.GoalState, 10);
        long endTime7 = System.nanoTime();
        long timeTaken7 = (endTime7 - startTime7);
        System.out.println("Time Taken: "+ timeTaken7/1000000 + " milliseconds");

        long startTime8 = System.nanoTime();
        System.out.println("\nDFID - Game 3: \n");
        DepthFirstIterativeDeepening DFIS3 = new DepthFirstIterativeDeepening(state.GameState3, state.GoalState, 10);
        long endTime8 = System.nanoTime();
        long timeTaken8 = (endTime8 - startTime8);
        System.out.println("Time Taken: "+ timeTaken8/1000000 + " milliseconds");

        long startTime9 = System.nanoTime();
        System.out.println("\nDFID - Game 4: \n");
        DepthFirstIterativeDeepening DFIS4 = new DepthFirstIterativeDeepening(state.GameState4, state.GoalState, 10);
        long endTime9 = System.nanoTime();
        long timeTaken9 = (endTime9 - startTime9);
        System.out.println("Time Taken: "+ timeTaken9/1000000 + " milliseconds");

        long startTime10 = System.nanoTime();
        System.out.println("\nDFID - Game 5: \n");
        DepthFirstIterativeDeepening DFIS5 = new DepthFirstIterativeDeepening(state.GameState5, state.GoalState, 15);
        long endTime10 = System.nanoTime();
        long timeTaken10 = (endTime10 - startTime10);
        System.out.println("Time Taken: "+ timeTaken10/1000000 + " milliseconds");

//        long startTime11 = System.nanoTime();
//        System.out.println("\nASTAR - Game 1: \n");
//        aStarSearch ASTAR1 = new aStarSearch(state.GameState1, state.GoalState);
//        long endTime11 = System.nanoTime();
//        long timeTaken11 = (endTime11 - startTime11);
//        System.out.println("Time Taken: "+ timeTaken11/1000000 + " milliseconds");
//
//        long startTime12 = System.nanoTime();
//        System.out.println("\nASTAR - Game 2: \n");
//        aStarSearch ASTAR2 = new aStarSearch(state.GameState2, state.GoalState);
//        long endTime12 = System.nanoTime();
//        long timeTaken12 = (endTime12 - startTime12);
//        System.out.println("Time Taken: "+ timeTaken12/1000000 + " milliseconds");
//
//        long startTime13 = System.nanoTime();
//        System.out.println("\nASTAR - Game 3: \n");
//        aStarSearch ASTAR3 = new aStarSearch(state.GameState3, state.GoalState);
//        long endTime13 = System.nanoTime();
//        long timeTaken13 = (endTime13 - startTime13);
//        System.out.println("Time Taken: "+ timeTaken13/1000000 + " milliseconds");
//
//        long startTime14 = System.nanoTime();
//        System.out.println("\nASTAR - Game 4: \n");
//        aStarSearch ASTAR4 = new aStarSearch(state.GameState4, state.GoalState);
//        long endTime14 = System.nanoTime();
//        long timeTaken14 = (endTime14 - startTime14);
//        System.out.println("Time Taken: "+ timeTaken14/1000000 + " milliseconds");
//
//        long startTime15 = System.nanoTime();
//        System.out.println("\nASTAR - Game 5: \n");
//        aStarSearch ASTAR5 = new aStarSearch(state.GameState5, state.GoalState);
//        long endTime15 = System.nanoTime();
//        long timeTaken15 = (endTime15 - startTime15);
//        System.out.println("Time Taken: "+ timeTaken15/1000000 + " milliseconds");


        long averageBreadth = ((timeTaken1 +  timeTaken2 + timeTaken3 + timeTaken4 + timeTaken5)/5)/1000000;
        long averageDepth = ((timeTaken6 +  timeTaken7 + timeTaken8 + timeTaken9 + timeTaken10)/5)/1000000;
//        long averageAStar = ((timeTaken11 + timeTaken12 + timeTaken13 + timeTaken14 + timeTaken15)/5)/1000000;
        System.out.println("The average time taken for Breadth First Search: "+ averageBreadth + " milliseconds");
        System.out.println("The average time taken for Depth First Iterative Deepening: "+ averageDepth + " milliseconds");
//        System.out.println("The average time taken for A Star: "+ averageAStar + " milliseconds");



    }
}


import java.util.*;

public class BreadthFirstSearch
{
    // Object of graph is created.
    Graph<int[][]> graph = new Graph<int[][]>();
    State state = new State();
    List allStatesInGraph = new ArrayList();
    boolean rightJustUsed = false;
    boolean leftJustUsed = false;
    boolean upJustUsed= false;
    boolean downJustUsed = false;
    int[][] previousArray;

    BreadthFirstSearch(int[][] startState, int[][] goalState)
    {
        Set<int[][]> sets = new HashSet<int[][]>();
        Node node = new Node(startState);
        Queue<Node> queue = new LinkedList<>();
        Node current = node;

        //while current is not the goal state
        while(!(Arrays.deepEquals(current.getState(), goalState)))
        {
            List<int[][]> neighbors = neighbors(current.getState());
            sets.add(current.getState());
            for(int i = 0; i < neighbors.size(); i++)
            {
                if(sets.contains(neighbors.get(i)))
                    continue;
                sets.add(neighbors.get(i));
                Node child = new Node(neighbors.get(i));
                current.addChild(child);
                child.setParent(current);
                queue.add(child);

            }
            current = queue.poll();
        }

        Node.printPath(current, node);
    }




    //after two painstaking days of trying to create a graph before searching said graph, i gave up trying
    // to copy the python code provided and made my own implementation...

//    public Graph<int[][]> createGraph(int[][] start) {
//        int[][] tempArray;
//        graph.addVertex(start); //adds the very first starting node
//        allStatesInGraph.add(start);
//        List tempList = neighbors(start);
//
//        for (int i = 0; i <= 3; i++) { //adds the next 4 nodes after the first node
//            graph.addVertex((int[][]) tempList.get(i));
//            graph.addEdge(start, (int[][]) tempList.get(i));
//            queue.add((int[][]) tempList.get(i));
//        }
//
//
//            tempArray = queue.poll();
//            tempList = neighbors(tempArray);
//
//            for (int g = 0; g < tempList.size(); g++) {
//                graph.addVertex((int[][]) tempList.get(g));
//                graph.addEdge(tempArray, (int[][]) tempList.get(g));
//                queue.add((int[][]) tempList.get(g));
//            }
//
//        graph.getVertexCount();
//        return graph;
//    }




    //neighbors is a list which contains all the possible states around the start state
    public List neighbors(int[][] array)
    {

        List neighborList = new ArrayList();
        int[][] rightArray = moveBlankRight(array);
        int[][] leftArray = moveBlankLeft(array);
        int[][] upArray = moveBlankUp(array);
        int[][] downArray = moveBlankDown(array);


            neighborList.add(rightArray);  //adds the right state to a list of neighbor states
            allStatesInGraph.add(rightArray);
            neighborList.add(leftArray);  //adds the left state to a list of neighbor states
            allStatesInGraph.add(leftArray);
            neighborList.add(upArray);  //adds the up state to a list of neighbor states
            allStatesInGraph.add(upArray);
            neighborList.add(downArray);  //adds the down state to a list of neighbor states
            allStatesInGraph.add(downArray);

        return neighborList;
    }

    public int[][] moveBlankRight(int[][] array)
    {
        int tempValueBlank = getXPosBlank(array);
        int[][] tempRightArray = new int[3][3];
        for(int i =0; i < 3; i++)
            for(int j = 0; j <3; j++)
                tempRightArray[i][j] = array[i][j];


        if(getXPosBlank(array) != 2) {
            int tempValue = tempRightArray[getYPosBlank(tempRightArray)][getXPosBlank(tempRightArray) + 1];
            tempRightArray[getYPosBlank(tempRightArray)][getXPosBlank(tempRightArray) + 1] = tempRightArray[getYPosBlank(tempRightArray)][getXPosBlank(tempRightArray)]; //0 goes into the 8
            tempRightArray[getYPosBlank(tempRightArray)][tempValueBlank] = tempValue; //8 goes into the 0 position

        }
        else {
            int tempValue = tempRightArray[getYPosBlank(tempRightArray)][getXPosBlank(tempRightArray) - 2];

            tempRightArray[getYPosBlank(tempRightArray)][getXPosBlank(tempRightArray) - 2] = tempRightArray[getYPosBlank(tempRightArray)][getXPosBlank(tempRightArray)]; //0 goes into the 7
            tempRightArray[getYPosBlank(tempRightArray)][tempValueBlank] = tempValue; //7 goes into the 0 position

        }

        return tempRightArray;
    }

    public int[][] moveBlankLeft(int[][] array)
    {

        int tempValueBlank = getXPosBlank(array);
        int[][] tempLeftArray = new int[3][3];
        for(int i =0; i < 3; i++)
            for(int j = 0; j <3; j++)
                tempLeftArray[i][j] = array[i][j];

        if(getXPosBlank(array) != 0) {
            int tempValue = tempLeftArray[getYPosBlank(tempLeftArray)][getXPosBlank(tempLeftArray) - 1];
            tempLeftArray[getYPosBlank(tempLeftArray)][getXPosBlank(tempLeftArray) - 1] = tempLeftArray[getYPosBlank(tempLeftArray)][getXPosBlank(tempLeftArray)]; //0 goes into the 7
            tempLeftArray[getYPosBlank(tempLeftArray)][tempValueBlank] = tempValue; //7 goes into the 0 position

        }
        else {
            int tempValue = tempLeftArray[getYPosBlank(tempLeftArray)][getXPosBlank(tempLeftArray) + 2];

            tempLeftArray[getYPosBlank(tempLeftArray)][getXPosBlank(tempLeftArray) + 2] = array[getYPosBlank(tempLeftArray)][getXPosBlank(tempLeftArray)]; //0 goes into the 7
            tempLeftArray[getYPosBlank(tempLeftArray)][tempValueBlank] = tempValue; //7 goes into the 0 position

        }

        return tempLeftArray;

    }

    public int[][] moveBlankUp(int[][] array)
    {

        int tempValueBlank = getYPosBlank(array);
        int[][] tempUpArray = new int[3][3];
        for(int i =0; i < 3; i++)
            for(int j = 0; j <3; j++)
                tempUpArray[i][j] = array[i][j];


        if(getYPosBlank(tempUpArray) != 0) {
            int tempValue = tempUpArray[getYPosBlank(tempUpArray) - 1][getXPosBlank(tempUpArray)]; //stores 5
            tempUpArray[getYPosBlank(tempUpArray) - 1][getXPosBlank(tempUpArray)] = tempUpArray[getYPosBlank(tempUpArray)][getXPosBlank(tempUpArray)]; //0 goes into the 5
            tempUpArray[tempValueBlank][getXPosBlank(tempUpArray)] = tempValue; //5 goes into the 0 position

        }
        else {
            int tempValue = tempUpArray[getYPosBlank(tempUpArray) + 2][getXPosBlank(tempUpArray)];
            tempUpArray[getYPosBlank(array) + 2][getXPosBlank(array)] = tempUpArray[getYPosBlank(tempUpArray)][getXPosBlank(tempUpArray)]; //0 goes into the 7
            tempUpArray[tempValueBlank][getXPosBlank(array)] = tempValue; //6 goes into the 0 position

        }

        return tempUpArray;

    }

    public int[][] moveBlankDown(int[][] array)
    {

        int tempValueBlank = getYPosBlank(array);
        int[][] tempDownArray = new int[3][3];
        for(int i =0; i < 3; i++)
            for(int j = 0; j <3; j++)
                tempDownArray[i][j] = array[i][j];

        if(getYPosBlank(tempDownArray) != 2) {
            int tempValue = tempDownArray[getYPosBlank(tempDownArray) + 1][getXPosBlank(tempDownArray)]; //stores 5
            tempDownArray[getYPosBlank(tempDownArray) + 1][getXPosBlank(tempDownArray)] = tempDownArray[getYPosBlank(tempDownArray)][getXPosBlank(tempDownArray)]; //0 goes into the 5
            tempDownArray[tempValueBlank][getXPosBlank(tempDownArray)] = tempValue; //5 goes into the 0 position

        }
        else {
            int tempValue = tempDownArray[getYPosBlank(tempDownArray) - 2][getXPosBlank(tempDownArray)];
            tempDownArray[getYPosBlank(tempDownArray) - 2][getXPosBlank(tempDownArray)] = tempDownArray[getYPosBlank(tempDownArray)][getXPosBlank(tempDownArray)]; //0 goes into the 7
            tempDownArray[tempValueBlank][getXPosBlank(tempDownArray)] = tempValue; //6 goes into the 0 position

        }

        return tempDownArray;

    }

    public int getYPosBlank(int[][] start)
    {
        for(int i =0; i < 3; i++)
            for(int j = 0; j <3; j++)
                if(start[i][j] == 0)
                    return i;

                return -1;
    }

    public int getXPosBlank(int[][] start)
    {
        for(int i =0; i < 3; i++)
            for(int j = 0; j <3; j++)
                if(start[i][j] == 0)
                    return j;

                return -1;
    }

}

import java.util.*;

public class aStarSearch{

    private int highestComparableNumber = 0;
    private Node mostImportantNode;

    aStarSearch(int[][] startState, int[][] goalState)
    {
        Set<int[][]> sets = new HashSet<>();
        Node node = new Node(startState);

        LinkedList<Node> list = new LinkedList<>();
        Node current = node;
        while(!(Arrays.deepEquals(current.getState(), goalState)))
        {
            sets.add(current.getState());
            List<int[][]> neighbors = neighbors(current.getState());
            for(int[][] array : neighbors)
            {
                if(sets.contains(array))
                    continue;
                sets.add(array);
                Node child = new Node(array);
                current.addChild(child);
                child.setParent(current);

                //now check for whether the current node is similar to the goal node, by checking each value in the array.
                int guessCost = checkSimilarity(current.getState(),goalState);
                child.setCost(guessCost);
                list.add(child);
            }
            highestComparableNumber = 0;

            //TODO: fix the infinite loop
            //ideally this for loop should check the state the has the least amount of tiles misplaced, and store it.
            for(int i = 0; i < list.size(); i++)
            {
                if(highestComparableNumber > list.get(i).getCost()) {
                    highestComparableNumber = list.get(i).getCost();
                    mostImportantNode = list.peek();
                }
            }
            //this should ideally put the most important node into the current node, and then loop through the node,
            //getting the best possible moves every time. However it is not working and I do not have enough time to fix it.
            current = mostImportantNode;
        }
        Node.printPath(current, node);
    }

    public int checkSimilarity(int[][] current, int[][] goalState)
    {
        int diffs = 0;
        for(int i =0; i < 3; i++)
            for(int j = 0; j <3; j++)
            {
                if(current[i][j] != goalState[i][j])
                    diffs++;
            }
        return diffs;
    }


    //neighbors is a list which contains all the possible states around the start state
    public List neighbors(int[][] array)
    {

        List neighborList = new ArrayList();
        int[][] rightArray = moveBlankRight(array);
        int[][] leftArray = moveBlankLeft(array);
        int[][] upArray = moveBlankUp(array);
        int[][] downArray = moveBlankDown(array);


        neighborList.add(rightArray);  //adds the right state to a list of neighbor states
        neighborList.add(leftArray);  //adds the left state to a list of neighbor states
        neighborList.add(upArray);  //adds the up state to a list of neighbor states
        neighborList.add(downArray);  //adds the down state to a list of neighbor states


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

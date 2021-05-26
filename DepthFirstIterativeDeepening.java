import java.util.*;

public class DepthFirstIterativeDeepening {


    Queue<Node> queue1 = new LinkedList<>();
    Queue<Node> queue2 = new LinkedList<>();
    Node node1;

    DepthFirstIterativeDeepening(int[][] startState, int[][] goalState, int depth) {
        Node current = new Node(startState);
        boolean Found = false;
        Set<int[][]> sets = new HashSet<>();

        for (int totalDepth = 1; totalDepth < depth; totalDepth++) {
            sets.clear();
            Node node = new Node(startState);
            node1 = node;
            queue1.add(node);
            current = node;
            List<int[][]> nodeChildren = null;
            sets.add(current.getState());

            while (!queue1.isEmpty()) {

                current = queue1.poll();

                if ((Arrays.deepEquals(current.getState(), goalState))) {// if current node is the goal node, break out
                    Found = true;
                    break;
                }
                else if (current.getDepth() < totalDepth) {
                    nodeChildren = neighbors(current.getState());
                    for(int i = 0; i < nodeChildren.size(); i++)
                    {
                        if (sets.contains(nodeChildren.get(i))) {
                            continue;
                        }
                        sets.add(nodeChildren.get(i));
                        Node child = new Node(nodeChildren.get(i));
                        current.addChild(child);
                        child.setParent(current);
                        child.setDepth(current.getDepth() + 1);
                        queue2.add(child);
                    }
                    while(!queue2.isEmpty()) {
                        queue1.add(queue2.poll());
                    }
                }
            }
            if (Found)
                break;
        }
            Node.printPath(current, node1);
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

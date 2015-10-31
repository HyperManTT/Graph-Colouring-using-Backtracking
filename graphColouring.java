public class graphColouring
{
    final int vertices = 4;
    int colour[];
    boolean canColour(int vertex, int graph[][], int colour[], int c)
    {
        for(int i = 0; i < vertex; i++)
        {
            //If the current vertex is connected to another node and that node has the colour we want to assign, return false
            if(graph[vertex][i] == 1 && c == colour[i])
                return false;
         }
         return true;
     }

    boolean colourGraph(int graph[][], int m, int colour[], int v)
    {
        if(v == vertices)
        {
            return true;
        }
        //Try to assign different colours to the current vertex
        for(int c = 1; c <= m; c++)
        {
            if(canColour(v, graph, colour, c))
            {
                colour[v] = c;
                
                //Move on to next node and colour it
                if(colourGraph(graph, m, colour, v + 1))
                {
                    return true;
                }
                colour[v] = 0; //If the assigned colour didn't lead to a solution, assign it to 0 and move on with another colour
            }
        }
        
        return false;  //If we've tried all possible combinations, return false since the problem is unsolvable.
    }
    
    
    boolean setupGraph(int graph[][], int m)
    {
        colour = new int[vertices];
        for(int i = 0; i < vertices; i++)
        {
            colour[i] = 0;
        }
        
        if(!colourGraph(graph, m, colour, 0))
        {
            System.out.println("No solution exists!");
            return false;
        }
        
        printSolution(colour);
        return true;
    }
    
    void printSolution(int colour[])
    {
        System.out.println("Solution to problem: ");
        for(int i = 0; i < vertices; i++)
        {
            System.out.print(colour[i] + " ");
        }
        
        System.out.println("");
    }
    
    public static void main(String[] args)
    {
        graphColouring g = new graphColouring();
         int graph[][] = {{0, 1, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 1},
            {1, 0, 1, 0},
        };
        int m = 3; // Number of colours
        g.setupGraph(graph, m);
    }
}
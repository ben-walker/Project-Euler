package euler15_latticepaths;

/**
 *
 * @author Ben Walker
 */
public class Euler15_latticePaths {

    public static long[][] latticeGrid;
    
    public static void main(String[] args) {
        int xVertices = 21, yVertices = 21;
        fillLatticeGrid(yVertices, xVertices);
        System.out.println("ALL POSSIBLE PATHS THROUGH " + (xVertices - 1) + "x" + (yVertices - 1) + " LATTICE: " + getNumberOfPaths(yVertices, xVertices));
    }
    
    private static void fillLatticeGrid (int y, int x) {
        latticeGrid = new long[y][x];
        
        for (int Y = 0; Y < y; Y++) {
            for (int X = 0; X < x; X++) {
                if(Y - 1 < 0 || X - 1 < 0)
                    latticeGrid[Y][X] = 1;
                else
                    latticeGrid[Y][X] = latticeGrid[Y - 1][X] + latticeGrid[Y][X - 1];
            }
        }
    }
    
    private static long getNumberOfPaths (int y, int x) {
        long numPaths = 0L;
        
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                numPaths = latticeGrid[i][j];
            }
        }
        
        return numPaths;
    }
    
}

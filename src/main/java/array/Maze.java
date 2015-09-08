package array;

/**
 * 
 * @author harish.sharma
 *
 */
public class Maze {

    public static boolean isSolvable(char[][] maze, int startX, int startY) {

        if (startX < 0 || startX > maze[0].length - 1 || startY < 0 || startY > maze.length - 1) return false;
        if (maze[startX][startY] == '*') return false;
        if (maze[startX][startY] == 'E') return true;
        // avoid cycle
        maze[startX][startY] = '*';
        if (isSolvable(maze, startX - 1, startY)) return true;
        if (isSolvable(maze, startX + 1, startY)) return true;
        if (isSolvable(maze, startX, startY - 1)) return true;
        if (isSolvable(maze, startX, startY + 1)) return true;
        return false;
    }

    public static void main(String[] args) {
        char[][] maze = { { ' ', '*', ' ', ' ', ' ', ' '}, { ' ', '*', ' ', ' ', ' ', ' '},
                { ' ', '*', ' ', ' ', ' ', ' '}, { ' ', '*', '*', '*', ' ', ' '}, { ' ', '*', ' ', ' ', ' ', ' '},
                { ' ', ' ', ' ', '*', 'E', ' '}};
        System.out.println(isSolvable(maze, 0, 0));
    }
}

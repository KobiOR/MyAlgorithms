package mazeGenerators;

import java.util.Random;

/**
 * Created by orrko_000 on 07/08/2016.
 */
public class SimpleMaze3dGenerator extends Maze3dType {
    Coordinate Perimeter;
    @Override
    public Maze3d Generate(int x, int y, int z) {
        Maze3d maze = new Maze3d();
        maze.createMaze(x, y, z);
        Perimeter = new Coordinate(x, y, z);

        buildMaze(maze);
        buildFloors(maze);
        buildSeparateWalls(maze);
        placeRandomWalls(maze);
        placeRandomPosition(maze, true);
        placeRandomPosition(maze, false);

        return maze;
    }
    void buildFloors(Maze3d newMaze) {
        for (int i = 0; i < newMaze.getmHeight(); i++) {
            if (i % 2 != 0) continue;
            for (int j = 0; j < newMaze.getfHeight(); j++)
                for (int z = 0; z < newMaze.getfWidth(); z++)
                    newMaze.setWall(i, j, z);


        }
    }
    void buildSeparateWalls(Maze3d newMaze) {
        for (int i = 0; i < newMaze.getmHeight(); i++) {
            if (i % 2 == 0) continue;
            for (int j = 0; j < newMaze.getfHeight(); j++) {
                newMaze.setWall(i, j, 0);

                for (int z = 0; z < newMaze.getfWidth(); z++) {
                    newMaze.setWall(i, newMaze.getfHeight() - 1, z);
                    newMaze.setWall(i, 0, z);
                    newMaze.setWall(i, j, newMaze.getfWidth() - 1);
                }
            }

        }
        createHoleOnWalls(newMaze);
    }
    void buildMaze(Maze3d newMaze) {
        for (int i = 0; i < newMaze.getmHeight(); i++) {
            if (i % 2 == 0) continue;
            for (int j = 0; j < newMaze.getfHeight(); j++) {
                if (j % 2 != 0) continue;
                for (int z = 0; z < newMaze.getfWidth(); z++)
                    newMaze.setWall(i, j, z);


            }

        }
    }
    void placeRandomWalls(Maze3d newMaze) {
        for (int i = 1; i < newMaze.getmHeight(); i++) {
            if (i % 2 == 0) continue;
            for (int j = 1; j < newMaze.getfHeight() - 1; j++) {
                if (j % 2 != 0) continue;
                for (int z = 1; z < newMaze.getfWidth() - 1; z++) {
                    Random rand = new Random();
                    int randomWidthPosition = rand.nextInt(newMaze.getfWidth() - 2) + 1;
                    int randomNumber = rand.nextInt(100);
                    if (randomNumber % 2 == 0) {
                        newMaze.removeWall(i, j, randomWidthPosition);
                        break;
                    }

                }


            }

        }


    }

}


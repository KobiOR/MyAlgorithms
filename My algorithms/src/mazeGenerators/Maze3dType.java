package mazeGenerators;

import java.util.Random;

/**
 * Created by orrko_000 on 07/08/2016.
 */
public abstract class Maze3dType implements Maze3dGenerator
{

    @Override
    public abstract Maze3d Generate(int x, int y, int z);
     @Override
    public String measureAlgorithmTime(int x,int y,int z) {
         long start = System.currentTimeMillis();
         Generate(x,y,z);
         long end = System.currentTimeMillis();
         String sTemp="Took: ";
         sTemp +=(end - start);
         return sTemp;

     }
    Coordinate placeRandomPosition(Maze3d newMaze, boolean startPosition) {
        Random rNumber = new Random();
        Coordinate newCoor = new Coordinate();
        if (startPosition) {
            int tempMazeHeight = 1;
            int random=1;
            int leftVsRight = (rNumber.nextInt() % 2 == 0) ? 0 : newMaze.getfWidth() - 1;
            int upVsDown = (rNumber.nextInt() % 2 == 0) ? 1 : newMaze.getfHeight() - 1;
            if (rNumber.nextInt() % 2 == 0) upVsDown = -1;
            else leftVsRight = -1;
            if (leftVsRight > upVsDown) {
                newCoor.setCoordinate(tempMazeHeight, rNumber.nextInt(newMaze.getfHeight()-1)+1, leftVsRight);
            } else {
                newCoor.setCoordinate(tempMazeHeight, upVsDown, rNumber.nextInt(newMaze.getfWidth()));
            }

            newMaze.setEntry(new Coordinate(1,1,2));
            return newCoor;
        } else {
            int tempMazeHeight = rNumber.nextInt(newMaze.getmHeight() - 2) + 1;
            while (tempMazeHeight == 2) {
                tempMazeHeight = rNumber.nextInt(newMaze.getmHeight() - 2) + 1;
            }
            int leftVsRight = (rNumber.nextInt() % 2 == 0) ? 0 : newMaze.getfWidth() - 1;
            int upVsDown = (rNumber.nextInt() % 2 == 0) ? 0 : newMaze.getmHeight() - 1;
            int semiFinal = (rNumber.nextInt() % 2 == 0) ? upVsDown = -1 : leftVsRight - 1;
            if (leftVsRight > upVsDown)
                newCoor.setCoordinate(tempMazeHeight, rNumber.nextInt(newMaze.getfHeight()), leftVsRight);
            else
                newCoor.setCoordinate(tempMazeHeight, upVsDown, rNumber.nextInt(newMaze.getfWidth()));


            newMaze.setExit(new Coordinate(newMaze.getmHeight()-1,1,1));
            return newCoor;
        }


    }
    private boolean verityPathOnMaze(Maze3d myMaze, Coordinate startCoor, Coordinate endCoor) {
        if (startCoor.equals(endCoor)) return true;
        if (myMaze.WallExist(startCoor)) return false;
        else {
            myMaze.setValueByCoor(startCoor,1);
            return
                    (
                            verityPathOnMaze(myMaze, startCoor.RIGHT(), endCoor)||
                                    verityPathOnMaze(myMaze, startCoor.LEFT(), endCoor)||
                                    verityPathOnMaze(myMaze, startCoor.UP(), endCoor)||
                                    verityPathOnMaze(myMaze, startCoor.DOWN(), endCoor)||
                                    verityPathOnMaze(myMaze, startCoor.BACKWORDS(), endCoor)||
                                    verityPathOnMaze(myMaze, startCoor.STRAIGHT(), endCoor)
                    );
        }

    }
    void createHoleOnWalls(Maze3d myMaze){
        for (int i = 1; i < myMaze.getmHeight() - 1; i++) {
            if (i % 2 != 0) continue;
            Random rand = new Random();
            int randHole = rand.nextInt(myMaze.getfHeight() - 2) + 1;
            int randHoleRow = rand.nextInt(myMaze.getfWidth() - 2) + 1;
            while (randHole % 2 == 0) {
                randHole = rand.nextInt(myMaze.getfHeight() - 2) + 1;
            }
            myMaze.removeWall(i, randHole, randHoleRow);
        }


    }
    public boolean verityPathOnMaze(Maze3d myMaze){
        Maze3d tempMaze=new Maze3d(myMaze);
        return verityPathOnMaze(tempMaze,tempMaze.getEntry(),tempMaze.getExit());
    }


}

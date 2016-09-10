package mazeGenerators;

import java.util.ArrayList;
import java.util.List;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;
import static jdk.nashorn.internal.objects.Global.print;
import static mazeGenerators.Maze3dGenerator.*;

/**
 * Created by orrko_000 on 07/08/2016.
 */
public class Maze3d {

    int[][][] maze3d;
    private Coordinate entry, exit;
    private int  mHeight,fHeight,fWidth;

    public Maze3d(Maze3d myMaze) {
        this.mHeight=myMaze.getmHeight();
        this.fHeight=myMaze.getfHeight();
        this.fWidth=myMaze.getfWidth();

        this.maze3d=new int[mHeight][fHeight][fWidth];

        for (int i = 0; i <mHeight ; i++)
            for (int j = 0; j <fHeight ; j++)
                for (int k = 0; k <fWidth ; k++)
                    this.maze3d[i][j][k]=myMaze.maze3d[i][j][k];
        this.entry=new Coordinate(myMaze.getEntry());
        this.exit=new Coordinate(myMaze.getExit());


    }
    public int getmHeight() {
        return mHeight;
    }
    public void setmHeight(int mHeight) {
        this.mHeight = mHeight;
    }
    public int getfHeight() {
        return fHeight;
    }
    public void setfHeight(int fHeight) {
        this.fHeight = fHeight;
    }
    public int getfWidth() {
        return fWidth;
    }
    public void setfWidth(int fWidth) {
        this.fWidth = fWidth;
    }
    public Maze3d() {}
    public Maze3d(int mHeight, int floorHeight, int floorWidth) {
        createMaze(mHeight, floorHeight,floorWidth);
    }
    public Coordinate getEntry() {
        return entry;
    }
    public void setEntry(Coordinate COOR) {
        this.entry = COOR;
        setValueByCoor(COOR,0);

    }
    public Coordinate getExit() {
        return exit;
    }
    public void setExit(Coordinate COOR)    {
        this.exit = COOR;
        setValueByCoor(COOR,0);
    }
    public void createMaze(int mazeHeight, int floorHeight, int floorWidth){
        mHeight = 2*mazeHeight+1;
        fHeight = floorHeight;
        fWidth = floorWidth;
        maze3d = new int[mHeight][fHeight][fWidth];

    }
    public void printMaze() {
        for (int i = 0; i < mHeight; i++) {
            for (int j = 0; j < fHeight; j++){
                for (int z = 0; z < fWidth; z++) {
                    if (maze3d[i][j][z]==1)
                    {
                         System.out.print("\033[1m" +maze3d[i][j][z]+ "\033[0m");
                    }
                    else
                    {
                        if (entry.sameCoors(i,j,z)){System.out.print("\033[1m"+ANSI_GREEN +maze3d[i][j][z] +ANSI_RESET+ "\033[0m");continue;}
                        if (exit.sameCoors(i,j,z)){System.out.print("\033[1m"+ANSI_RED +maze3d[i][j][z] +ANSI_RESET+ "\033[0m");continue;}
                        if (i%2==0 && maze3d[i][j][z]==0){System.out.print("\033[1m"+ANSI_BLUE +maze3d[i][j][z] +ANSI_RESET+ "\033[0m");}
                           else System.out.print(maze3d[i][j][z]);
                    }
                }
                System.out.print("\n");
            }
            System.out.print("\n");
        }
    }
    public void setWall(int mazeHeight, int floorHeight, int floorWidth){
        if (mazeHeight<mHeight&&floorHeight<fHeight&& floorWidth<fWidth)
            maze3d[mazeHeight][floorHeight][floorWidth]=1;
        else System.out.print("Cant set wall\n");

    }
    public void removeWall(int mazeHeight, int floorHeight, int floorWidth){
        if (mazeHeight<mHeight&&floorHeight<fHeight&& floorWidth<fWidth)
            maze3d[mazeHeight][floorHeight][floorWidth]=0;
        else System.out.print("Cant remove wall\n");
    }
    public void setValueByCoor(Coordinate coor,int value){
          maze3d[coor.cMazeHeight][coor.cFloorHeight][coor.cFloorWidth]=value;

    }
    public int getValueByCoor(Coordinate coor){
           return maze3d[coor.cMazeHeight][coor.cFloorHeight][coor.cFloorWidth];
            }
    public boolean WallExist(Coordinate coors){

       if(coors.cMazeHeight<0|| coors.cFloorHeight<0||coors.cFloorWidth<0){return true;}
       if(coors.cMazeHeight>=mHeight || coors.cFloorHeight>=fHeight||coors.cFloorWidth>=fWidth){return true;}
       if(maze3d[coors.cMazeHeight][coors.cFloorHeight][coors.cFloorWidth]==0) return false;
       if(getValueByCoor(coors)==1){return true;}
       else {return true;}


    }
    public String[] getPossibleMoves(Coordinate coors){

        List<String> moveString = new ArrayList<>();
        if (!WallExist(coors.STRAIGHT())) moveString.add("Straight");
        if (!WallExist(coors.BACKWORDS())) moveString.add("Backword");
        if (!WallExist(coors.LEFT())) moveString.add("Left");
        if (!WallExist(coors.RIGHT())) moveString.add("Right");
        if (!WallExist(coors.UP())) moveString.add("Up");
        if (!WallExist(coors.DOWN())) moveString.add("Down");

        String[] myMoves=new String[moveString.size()];
        for (int i = 0; i <moveString.size() ; i++) {
            myMoves[i]=moveString.get(i);
        }
        return myMoves;

    }
    public String getGoalPosition() {
        String str=getEntry().getCoodinate();
        str+=" "+getExit().getCoodinate();
        return str;
    }
    public int[][] getCrossSectionByX(int i) {
        int[][] temp=new int[fHeight][fWidth];
        for (int j = 0; j < fHeight; j++) {
            for (int k = 0; k <fWidth ; k++)
                temp[j][k]=maze3d[i][j][k];


        }
        return  temp;
    }
    public int[][] getCrossSectionByY(int i) {
        int[][] temp=new int[mHeight][fWidth];
        for (int j = 0; j < mHeight; j++) {
            for (int k = 0; k <fWidth ; k++)
                temp[j][k]=maze3d[j][i][k];


        }
        return  temp;
    }
    public int[][] getCrossSectionByZ(int i){
        int[][] temp=new int[mHeight][fHeight];
        for (int j = 0; j < mHeight; j++) {
            for (int k = 0; k <fHeight ; k++)
                temp[j][k]=maze3d[j][k][i];


        }
        return  temp;
    }
    public byte[] toByteArray() {
        List<Byte> list = new ArrayList<Byte>();
        int index = 0;
        byte counterZero = 0;
        byte counterOne = 0;
        Byte[] arr = new Byte[mHeight * fHeight * fWidth];
        for (int i = 0; i < mHeight; i++)
            for (int j = 0; j < fHeight; j++)
                for (int k = 0; k < fWidth; k++) {
                    if (maze3d[i][j][k] == 1) arr[index] = 1;
                    else if (maze3d[i][j][k] == 0) arr[index] = 0;
                    index++;
                }
        index = 0;
        list.add((byte) mHeight);
        list.add((byte) fHeight);
        list.add((byte) fWidth);
        while (index < mHeight * fHeight * fWidth) {

            while (arr[index] == 1) {
                counterOne++;
                index++;
                if (index >= arr.length)
                    break;
            }
            list.add(counterOne);
            list.add((byte) 1);
            counterOne = 0;
            if (index >= arr.length)
                break;
            if (index < mHeight * fHeight * fWidth) {
                while (arr[index] == 0) {
                    counterZero++;
                    index++;
                    if (index >= arr.length)
                        break;
                }
                list.add(counterZero);
                list.add((byte) 0);
                counterZero = 0;
            }


        }
        byte[] finalArr = new byte[list.size()];
        index = 0;
        for (Byte b : list) {
            finalArr[index] = b;
            index++;

        }

        return finalArr;
    }

    public Maze3d(byte[] bytesArray) {
    }
}
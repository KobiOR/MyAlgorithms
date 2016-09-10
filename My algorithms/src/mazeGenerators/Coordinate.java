/**
 * COORDINATE CLASS
 * FOR POSITION-X,Y,Z
 *
 */
package mazeGenerators;

import java.util.Random;

/**
 * Created by orrko_000 on 07/08/2016.
 */
public class Coordinate {
      int cMazeHeight,cFloorHeight,cFloorWidth;

      public boolean isVisited() {
            return visited;
      }

      public void setVisited(boolean visited) {
            this.visited = visited;
      }

      private boolean visited;



      public int getcMazeHeight() {
            return cMazeHeight;
      }
      public int getcFloorHeight() {
            return cFloorHeight;
      }
      public int getcFloorWidth() {
            return cFloorWidth;
      }
      Coordinate(){}
      public Coordinate(int x, int y, int z){cMazeHeight=x;cFloorHeight=y;cFloorWidth=z;}
      public Coordinate(Coordinate coor){this.cMazeHeight=coor.getcMazeHeight();this.cFloorHeight=coor.getcFloorHeight();this.cFloorWidth=coor.getcFloorWidth();}
      void setCoordinate(int nX,int nY,int nZ){cMazeHeight=nX;cFloorHeight=nY;cFloorWidth=nZ;}
      int getSpecCoordinate(char reqCoor){switch (reqCoor){case'x':return cMazeHeight;case'y':return cFloorHeight;case'z' : return cFloorWidth;default: return-1;}}
      void randomCoors(int maxMazeHeight,int maxFloorHeight,int maxFloorWidth){
            Random rand = new Random();
            cMazeHeight = rand.nextInt(maxMazeHeight-2) + 1;
            cFloorHeight = rand.nextInt(maxFloorHeight-2) + 1;
            cFloorHeight = rand.nextInt(maxFloorWidth-2) + 1;


      }
      public void printCoordinate(){
            System.out.print("("+cMazeHeight+","+cFloorHeight+","+cFloorWidth+")\n");

      }
      boolean sameCoors(int coorMHeight,int coorFHeight,int coorFWidth){
            if (cMazeHeight==coorMHeight && cFloorHeight==coorFHeight&& cFloorWidth==coorFWidth)
                  return true;
            return false;
      }
      public Coordinate UP(){

            ++cMazeHeight;
            Coordinate temp=new Coordinate(this);
            --cMazeHeight;
            return temp;
      }
      public Coordinate DOWN(){

            --cMazeHeight;
            Coordinate temp=new Coordinate(this);
            ++cMazeHeight;
            return temp;
      }
      public Coordinate RIGHT(){

            ++cFloorWidth;
            Coordinate temp=new Coordinate(this);
            --cFloorWidth;
            return temp;
      }
      public Coordinate LEFT(){

            --cFloorWidth;
            Coordinate temp=new Coordinate(this);
            ++cFloorWidth;
            return temp;
      }
      public Coordinate STRAIGHT(){

            --cFloorHeight;
            Coordinate temp=new Coordinate(this);
            ++cFloorHeight;
            return temp;
      }
      public Coordinate BACKWORDS(){

            ++cFloorHeight;
            Coordinate temp=new Coordinate(this);
            --cFloorHeight;
            return temp;
      }
      public boolean equals(Coordinate someCoor){
            if(cMazeHeight==someCoor.cMazeHeight && cFloorHeight==someCoor.cFloorHeight && cFloorWidth==someCoor.cFloorWidth)
                  return true;
            return false;


      }
      @Override
      public boolean equals(Object obj) {
            if (this == obj)
                  return true;
            if (obj == null)
                  return false;
            if (!(obj instanceof Coordinate))
                  return false;
            Coordinate other = (Coordinate) obj;
           return equals(other);
      }
      String getCoodinate(){
            return ("("+cMazeHeight+","+cFloorHeight+","+cFloorWidth+")");

      }
      @Override
      public String toString() {
            return getCoodinate();
      }

      public byte[] toByteArray() {

            return new byte[]{(byte) cMazeHeight, (byte) cFloorHeight, (byte) cFloorWidth};
      }
}

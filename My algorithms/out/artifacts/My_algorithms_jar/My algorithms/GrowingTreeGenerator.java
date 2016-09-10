package mazeGenerators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;



public class GrowingTreeGenerator extends Maze3dType
{
    private ArrayList<Coordinate> frontier;

    @Override
    public Maze3d Generate(int mHeight, int fHeight, int fWidth) {
        Maze3d myMaze=new Maze3d(mHeight,fHeight,fWidth);
        frontier = new ArrayList<>();
        init(myMaze);
        for (int i = 0; i < myMaze.getmHeight(); i++)
        {if (i%2==0)continue;start(myMaze,i);}
        createHoleOnWalls(myMaze);
        this.placeRandomPosition(myMaze,true);
        this.placeRandomPosition(myMaze,false);
        return myMaze;
    }
    public void init(Maze3d newMaze){
        for (int mHeight=0;mHeight< newMaze.getmHeight();mHeight++) {
            for (int fHeight = 0; fHeight < newMaze.getfHeight(); fHeight++) {
                for (int fWidth = 0; fWidth < newMaze.getfWidth(); fWidth++) {
                    if (mHeight%2==0 ||fHeight==0||fWidth==0 || fHeight==newMaze.getfHeight()-1||fWidth==newMaze.getfWidth()-1)
                        newMaze.setValueByCoor(new Coordinate(mHeight,fHeight,fWidth),1);
                    else
                    newMaze.setValueByCoor(new Coordinate(mHeight,fHeight,fWidth),-1);
                }
            }
        }

    }
    public void carve(Maze3d myMaze,int mHeight,int mFloorHeight, int mFloorWidth){
        ArrayList<Coordinate> extra =new ArrayList<Coordinate>();
        myMaze.maze3d[mHeight][mFloorHeight][mFloorWidth]=0;

        if (mFloorWidth>0)
        {
            if (myMaze.maze3d[mHeight][mFloorHeight][mFloorWidth-1]==-1)
            {
                myMaze.maze3d[mHeight][mFloorHeight][mFloorWidth-1] =0;
                extra.add(new Coordinate(mHeight,mFloorHeight,mFloorWidth-1));

            }
        }
        if(mFloorWidth < myMaze.getfWidth()-1)
        {
            if (myMaze.maze3d[mHeight][mFloorHeight][mFloorWidth+1]==-1)
            {
                myMaze.maze3d[mHeight][mFloorHeight][mFloorWidth+1] =0;
                extra.add(new Coordinate(mHeight,mFloorHeight,mFloorWidth+1));
            }
        }
        if(mFloorHeight>0)
        {
            if (myMaze.maze3d[mHeight][mFloorHeight-1][mFloorWidth]==-1)
            {
                if (myMaze.maze3d[mHeight][mFloorHeight-1][mFloorWidth]==-1)
                {
                    myMaze.maze3d[mHeight][mFloorHeight-1][mFloorWidth]=0;
                    extra.add(new Coordinate(mHeight,mFloorHeight-1,mFloorWidth));
                }
            }

        }
        if( mFloorHeight < myMaze.getfHeight()-1)
        {
            if( myMaze.maze3d[mHeight][mFloorHeight+1][mFloorWidth]==-1)
            {
                myMaze.maze3d[mHeight][mFloorHeight+1][mFloorWidth]=0;
                extra.add(new Coordinate(mHeight,mFloorHeight+1,mFloorWidth));

            }
        }
        Collections.shuffle(extra);
        frontier.addAll(extra);

    }
    public void harden(Maze3d myMaze,int mHeight,int mFloorHeight,int mFloorWidth){

        myMaze.setValueByCoor(new Coordinate(mHeight,mFloorHeight,mFloorWidth),1);
    }
    public boolean check(Maze3d myMaze,int mHeight,int y, int x, boolean nodiagonals){
        int edgestate=0;

        if(x>0)
            if (myMaze.maze3d[mHeight][y][x-1] == 0)
                edgestate +=1;


        if(x< myMaze.getfWidth()-1)
            if (myMaze.maze3d[mHeight][y][x+1]==0)
                edgestate +=2;

        if(y>0)
            if(myMaze.maze3d[mHeight][y-1][x] == 0)
                edgestate+=4;


        if(y< myMaze.getfHeight()-1)
            if(myMaze.maze3d[mHeight][y+1][x]==0)
                edgestate+=8;


        if (nodiagonals)
        {


            //make diagonals
            if (edgestate ==1)
            {
                if(x< myMaze.getfWidth()-1 )
                {
                    if(y>0)
                    {
                        if(myMaze.maze3d[mHeight][y-1][x+1] == 0)
                        {
                            return false;
                        }
                    }
                    if(y< myMaze.getfHeight()-1)
                    {
                        if(myMaze.maze3d[mHeight][y+1][x+1]==0)
                        {
                            return false;
                        }
                    }
                }
                return true;
            }
            else if (edgestate==2)
            {
                if(x>0 )
                {
                    if(y>0)
                    {
                        if (myMaze.maze3d[mHeight][y-1][x-1]==0)
                        {
                            return false;
                        }
                        if( y<myMaze.getfHeight()-1)
                        {
                            if (myMaze.maze3d[mHeight][y+1][x-1] == 0)
                            {
                                return false;
                            }
                        }
                    }
                }
                return true;

            }
            else if(edgestate==4)
            {
                if(y< myMaze.getfHeight()-1)
                {
                    if(x>0)
                    {
                        if(myMaze.maze3d[mHeight][y+1][x-1]==0)
                        {
                            return false;
                        }
                    }
                    if(x<myMaze.getfWidth()-1)
                    {
                        if(myMaze.maze3d[mHeight][y+1][x+1]==0)
                        {
                            return false;
                        }
                    }

                }
                return true;
            }
            else if (edgestate ==8)
            {
                if(y>0)
                {
                    if(x>0)
                    {
                        if(myMaze.maze3d[mHeight][y-1][x-1] ==0)
                        {
                            return false;
                        }
                    }
                    if(x<myMaze.getfWidth()-1)
                    {
                        if(myMaze.maze3d[mHeight][y-1][x+1]==0)
                        {
                            return false;
                        }
                    }
                }
                return true;
            }
            return false;// nodiag
        }
        else//nodiag
        {
            if(edgestate==1 || edgestate==2|| edgestate==4||edgestate==8)
            {
                return true;
            }
            return false;
        }



    }
    public void start(Maze3d myMaze,int mHeight){

        int mFloorWidth = randInt(0,myMaze.getfWidth()-1);
        int mFloorHeight = randInt(0,myMaze.getfHeight()-1);
        carve(myMaze,mHeight,mFloorHeight,mFloorWidth);
        int branchrate=0;
        while(frontier.size()>0)
        {

            double pos =  Math.random();
            pos = Math.pow(pos,Math.pow(Math.E, -branchrate) );

            int choiceint = (int) (pos*frontier.size());
            Coordinate choice = frontier.get(choiceint);

            if(check(myMaze,choice.getcMazeHeight(),choice.getcFloorHeight(),choice.getcFloorWidth(), true))
                carve(myMaze,choice.getcMazeHeight(),choice.getcFloorHeight(), choice.getcFloorWidth());
            else
                harden(myMaze,choice.getcMazeHeight(),choice.getcFloorHeight(), choice.getcFloorWidth());


            frontier.remove(choice);
        }
           for (int y = 0; y < myMaze.getfHeight(); y++)
              for (int x = 0; x < myMaze.getfWidth(); x++)
                   if (myMaze.maze3d[mHeight][y][x] == -1)
                          myMaze.maze3d[mHeight][y][x] = 1;


    }
    public  int randInt(int min, int max) {

        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }


}



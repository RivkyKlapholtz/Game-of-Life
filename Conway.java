import java.util.Random;
//-------------------0 is death, 1 is life-----------------
//constructor of class Conway, constructors a matrix with random values: 0 or 1.
public class Conway
{
    private static int [][] _lifeMatrix;

    public Conway(int len, int width)
    {
        _lifeMatrix = new int[len][width];
        Random randNum = new Random();
        for (int i = 0; i < len; i++)
        {
            for (int j = 0; j < width; j++)
            {
                _lifeMatrix[i][j] = randNum.nextInt(2);
            }
        }
    }

    //This method return the life matrix.
    public int[][] getLifeMatrix()
    {
        return _lifeMatrix;
    }

    //This method updates the life matrix according to the rules of life game.
    public void setLifeMatrix(int len, int width)
    {
        int numFriends = 0;
        int [][] tempLifeMatrix = new int[len][width];

        //------------------checks how many friends every "person" in the life matrix has---------------
        for (int i = 0; i < _lifeMatrix.length; i++)
        {
            for (int j = 0; j < _lifeMatrix[0].length; j++)
            {
                numFriends = 0;
                if (i == 0 && j == 0)//upper left corner
                 {
                     numFriends = numFriends + _lifeMatrix[i][j+1] + _lifeMatrix[i+1][j] + _lifeMatrix[i+1][j+1];
                 }
                else if (i == 0 && j == _lifeMatrix[0].length-1)//upper right corner
                {
                    numFriends = numFriends + _lifeMatrix[i][j-1] + _lifeMatrix[i+1][j-1] + _lifeMatrix[i+1][j];
                }
                else if (i == _lifeMatrix.length-1 && j == _lifeMatrix[0].length-1)//lower right corner
                {
                    numFriends = numFriends + _lifeMatrix[i-1][j] + _lifeMatrix[i-1][j-1] + _lifeMatrix[i][j-1];
                }
                else if (i == _lifeMatrix.length-1 && j == 0)//lower left corner
                {
                    numFriends = numFriends + _lifeMatrix[i-1][j] + _lifeMatrix[i-1][j+1] + _lifeMatrix[i][j+1];
                }
                else if (j == _lifeMatrix[0].length-1)//right row
                {
                    numFriends = numFriends + _lifeMatrix[i+1][j] + _lifeMatrix[i-1][j]
                            + _lifeMatrix[i+1][j-1] + _lifeMatrix[i-1][j-1] + _lifeMatrix[i][j-1];
                }
                else if (j == 0)//left row
                {
                    numFriends = numFriends + _lifeMatrix[i+1][j] + _lifeMatrix[i-1][j]
                           + _lifeMatrix[i+1][j+1] + _lifeMatrix[i-1][j+1] + _lifeMatrix[i][j+1];
                }
                else if (i == 0)//top row
                {
                    numFriends = numFriends + _lifeMatrix[i+1][j] + _lifeMatrix[i+1][j-1]
                            + _lifeMatrix[i+1][j+1] + _lifeMatrix[i][j+1] + _lifeMatrix[i][j-1];
                }
                else if (i == _lifeMatrix.length-1)//bottom row
                {
                    numFriends = numFriends + _lifeMatrix[i-1][j] + _lifeMatrix[i-1][j-1]
                            + _lifeMatrix[i-1][j+1] + _lifeMatrix[i][j+1] + _lifeMatrix[i][j-1];
                }
                else
                {
                    numFriends = numFriends + _lifeMatrix[i+1][j] + _lifeMatrix[i-1][j]
                                        + _lifeMatrix[i+1][j-1] + _lifeMatrix[i+1][j+1]
                                    + _lifeMatrix[i-1][j-1] + _lifeMatrix[i-1][j+1]
                                + _lifeMatrix[i][j+1] + _lifeMatrix[i][j-1];
                }
                //update the next matrix based on the life and death of the friends:
                if (_lifeMatrix[i][j] == 0)
                {
                    if(numFriends == 3)
                    {
                        tempLifeMatrix[i][j] = 1;
                    }
                    else
                    {
                        tempLifeMatrix[i][j] = 0;
                    }
                }
                else //(_lifeMatrix[i][j] == 1)
                {
                    if(numFriends == 0 || numFriends == 1 || numFriends >= 4)
                    {
                        tempLifeMatrix[i][j] = 0;
                    }
                    else
                    {
                        tempLifeMatrix[i][j] = 1;
                    }
                }
            }//end of for that runs on the matrix
        }//end of for that runs on the matrix
        _lifeMatrix = tempLifeMatrix;
    }//end of method
}//end of class Conway

package DataStructure;

import DataStructure.TrainingData;
import Utility.Utility;

import java.util.ArrayList;

/**
 * Created by EmilKarlsson on 11/27/16.
 */
public class TrainingDataCollection extends ArrayList<TrainingData>
{

    public TrainingData getRandom()
    {
         return this.get(Utility.getRandomInt(0,this.size()));
    }
}

package DataStructure.Test;


import DataStructure.TrainingData;
import org.junit.Test;


/**
 * Created by EmilKarlsson on 1/14/17.
 */
public class TrainingDataTest
{

    @Test
    public void addTest()
    {
        TrainingData data = new TrainingData.Builder().addToInput(1)
                .addToInput(2)
                .addToInput(3)
                .addToOutput(4).build();
        System.out.println(data.toString());
    }





}
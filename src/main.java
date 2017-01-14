import DataStructure.TrainigDataCollection;
import DataStructure.TrainingData;
import Network.INeuralNetwork;
import Network.LayerProperties;
import Network.NeuralNetworkFactory;
import Strategy.ActivationFunctions;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by EmilKarlsson on 11/27/16.
 */
public class main
{
    public static void main(String[] args)
    {
        NeuralNetworkFactory factory = new NeuralNetworkFactory();

        HashMap<Integer, LayerProperties> hiddenMap = new HashMap<Integer, LayerProperties>();

        LayerProperties inputLayer = new LayerProperties(ActivationFunctions.SmoothTan,0.1,2);
        LayerProperties outputLayer = new LayerProperties(ActivationFunctions.LogSigmoid,0.9,1);

        hiddenMap.put(1,new LayerProperties(ActivationFunctions.SmoothTan,0.9,3));

        INeuralNetwork neuralNetwork = factory.CreateNetwork(inputLayer,outputLayer,hiddenMap);
        // this is a new start on a breanch
        /*TrainigDataCollection dataSet = new TrainigDataCollection();

        TrainingData data1 = new TrainingData();
        data1.addToInput(1.0);
        data1.addToInput(1.0);
        data1.addToOutput(0.9);
        dataSet.add(data1);

        TrainingData data2 = new TrainingData();
        data2.addToInput(0.0);
        data2.addToInput(1.0);
        data2.addToOutput(0.1);
        dataSet.add(data2);

        TrainingData data3 = new TrainingData();
        data3.addToInput(1.0);
        data3.addToInput(0.0);
        data3.addToOutput(0.1);
        dataSet.add(data3);

        TrainingData data4 = new TrainingData();
        data4.addToInput(0.0);
        data4.addToInput(0.0);
        data4.addToOutput(0.90);
        dataSet.add(data4);

        neuralNetwork.TrainNetwork(dataSet,4000);

        System.out.println(neuralNetwork.toString());
        System.out.println("Error: " + neuralNetwork.getError());


        ArrayList<Double> in = new ArrayList<Double>();
        in.add(0.0);
        in.add(0.0);

        ArrayList<Double> out = neuralNetwork.RunNetwork(in);
        System.out.println("Input: " + in.toString());
        System.out.println("Output: " + out.toString());
        in.set(0,1.0);
        out = neuralNetwork.RunNetwork(in);
        System.out.println("Input: " + in.toString());
        System.out.println("Output: " + out.toString());
        in.set(1,1.0);
        out = neuralNetwork.RunNetwork(in);
        System.out.println("Input: " + in.toString());
        System.out.println("Output: " + out.toString());
        in.set(0,0.0);
        out = neuralNetwork.RunNetwork(in);
        System.out.println("Input: " + in.toString());
        System.out.println("Output: " + out.toString());
        */
    }
}

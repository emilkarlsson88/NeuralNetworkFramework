import DataStructure.TrainingDataCollection;
import DataStructure.TrainingData;
import Network.LayerProperties;
import Network.NeuralNetwork;
import Strategy.ActivationFunctions;

/**
 * Created by EmilKarlsson on 11/27/16.
 */
public class Main
{
    public static void main(String[] args)
    {
        NeuralNetwork neuralNetwork = new NeuralNetwork.CreateNetwork()
                .addInputLayer(new LayerProperties(ActivationFunctions.SmoothTan,0.1,2))
                .addHiddenLayer(new LayerProperties(ActivationFunctions.SmoothTan,0.9,3))
                .addOutputLayer(new LayerProperties(ActivationFunctions.LogSigmoid,0.9,1)).build();

        TrainingDataCollection dataSet = new TrainingDataCollection();

        dataSet.add(new TrainingData.Builder().addToInput(1.0).addToInput(1.0).addToOutput(0.9).build());
        dataSet.add(new TrainingData.Builder().addToInput(0.0).addToInput(1.0).addToOutput(0.1).build());
        dataSet.add(new TrainingData.Builder().addToInput(1.0).addToInput(0.0).addToOutput(0.1).build());
        dataSet.add(new TrainingData.Builder().addToInput(0.0).addToInput(0.0).addToOutput(0.1).build());

        neuralNetwork.TrainNetwork(dataSet,4000);

        System.out.println(neuralNetwork.toString());
        System.out.println("Error: " + neuralNetwork.getError());

        for (TrainingData data : dataSet)
        {
            System.out.println("Input: " + data.getInput());
            System.out.println("Output from network: " + neuralNetwork.RunNetwork(data.getInput()));
            System.out.println("Expected output: " + data.getOutput());
        }
    }
}

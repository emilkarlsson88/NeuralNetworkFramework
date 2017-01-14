package Network;

import DataStructure.TrainingDataCollection;
import DataStructure.TrainingData;

import java.util.ArrayList;

/**
 * Created by EmilKarlsson on 11/27/16.
 */
public interface INeuralNetwork
{
    void TrainNetwork(TrainingData data); // Traningdata
    void TrainNetwork(TrainingDataCollection dataCollection, int iterations);
    ArrayList<Double> RunNetwork(ArrayList<Double> input);
    ArrayList<Double> getOutput();
    ArrayList<NeuronLayer> getHiddenLayers();
    NeuronLayer getInputLayer();
    NeuronLayer getOutputLayer();
    double getError();



}

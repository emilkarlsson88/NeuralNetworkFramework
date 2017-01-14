package Network;

import DataStructure.TrainigDataCollection;
import DataStructure.TrainingData;

import java.util.ArrayList;

/**
 * Created by EmilKarlsson on 11/27/16.
 */
public interface INeuralNetwork
{
    public void TrainNetwork(TrainingData data); // Traningdata
    public void TrainNetwork(TrainigDataCollection dataCollection, int iterations);
    public void ConnectNeuron(INeuron source, INeuron destination,double weight);
    public void ConnectNeuron(INeuron source, INeuron destination);
    public void ConnectLayers(NeuronLayer layer1, NeuronLayer layer2);
    public void ConnectLayers();
    public ArrayList<Double> RunNetwork(ArrayList<Double> input);
    public ArrayList<Double> getOutput();
    public ArrayList<NeuronLayer> getHiddenLayers();
    public void addLayer(NeuronLayer layer);
    public NeuronLayer getInputLayer();
    public NeuronLayer getOutputLayer();
    public double getError();



}

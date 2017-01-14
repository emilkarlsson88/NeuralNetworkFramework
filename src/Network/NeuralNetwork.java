package Network;

import DataStructure.NeuronLayerArray;
import DataStructure.TrainigDataCollection;
import DataStructure.TrainingData;
import Utility.Utility;

import java.util.ArrayList;

/**
 * Created by EmilKarlsson on 11/27/16.
 */
public class NeuralNetwork implements INeuralNetwork {

    private NeuronLayerArray layer = new NeuronLayerArray();
    private double error = 0;

    @Override
    public void TrainNetwork(TrainingData data) {

        int i = 0;
        for(INeuron neuron : this.getInputLayer())
        {
            neuron.setOutputValue(data.getInput().get(i));
            i++;
        }

        for (NeuronLayer layer : this.getHiddenLayers())
        {
            for (INeuron neuron : layer)
            {
                neuron.UpdateOutput();
            }
        }

        for (INeuron neuron : this.getOutputLayer())
        {
            neuron.UpdateOutput();
        }

        i = 0;
        error = 0;
        for (INeuron neuron : this.getOutputLayer())
        {
            neuron.UpdateDelta(data.getOutput().get(i) - neuron.getOutputValue());
            error += 0.5*Math.pow(data.getOutput().get(i) - neuron.getOutputValue(),2);
            i++;
        }

        for (i = layer.size()-2 ; i >= 0; i--)
        {
            NeuronLayer layer = this.layer.get(i);
            for (INeuron neuron : layer)
            {
                neuron.UpdateDelta();
            }
        }

        for (NeuronLayer layer : this.layer.getLayersWithParm())
        {
            for (INeuron neuron : layer )
            {
                neuron.UpdateFreeParams();
            }
        }
    }

    @Override
    public void TrainNetwork(TrainigDataCollection dataCollection, int iterations) {

        error = 0;
        for (int i = 1 ; i <=iterations;i++)
        {
//            for (TrainingData data : dataCollection)
//            {
                TrainingData data = dataCollection.getRandom();
                this.TrainNetwork(data);
                error = this.getError();
                //System.out.println(error);
//            }
        }
    }

    @Override
    public void ConnectNeuron(INeuron source, INeuron destination, double weight) {

        destination.addToInputs(source,weight);
        source.addToForwardConnections(destination);
    }

    @Override
    public void ConnectNeuron(INeuron source, INeuron destination) {

        this.ConnectNeuron(source,destination, Utility.getRandom());
    }

    @Override
    public void ConnectLayers(NeuronLayer layer1, NeuronLayer layer2) {

        for (INeuron inputNeuron : layer1)
        {
            for (INeuron targetNeuron : layer2)
            {
                this.ConnectNeuron(inputNeuron,targetNeuron);
            }
        }
    }

    @Override
    public void ConnectLayers()
    {
        for (int i = 0; i < layer.size()-1;i++)
        {
            this.ConnectLayers(layer.get(i),layer.get(i+1));
        }
    }

    @Override
    public ArrayList<Double> RunNetwork(ArrayList<Double> input) {

        int i = 0;
        for (INeuron neuron : this.getInputLayer())
        {
            neuron.setOutputValue(input.get(i));
            i++;
        }

        for (NeuronLayer layer : this.layer.getLayersWithParm())
        {
            for (INeuron neuron : layer)
            {
                neuron.UpdateOutput();
            }
        }

        return this.getOutput();
    }

    @Override
    public ArrayList<Double> getOutput() {
        ArrayList<Double> arr = new ArrayList<Double>();

        for(INeuron neuron : this.getOutputLayer())
        {
            arr.add(neuron.getOutputValue());
        }
        return arr;
    }

    @Override
    public ArrayList<NeuronLayer> getHiddenLayers() {
        return layer.getHiddenLayers();
    }

    @Override
    public void addLayer(NeuronLayer layer) {
        this.layer.addLayer(layer);
    }

    private ArrayList<NeuronLayer> getLayersInRevers()
    {
        return layer.getHiddenLayersInRevers();
    }

    @Override
    public NeuronLayer getInputLayer() {
        return layer.getInputLayer();
    }

    @Override
    public NeuronLayer getOutputLayer() {
        return layer.getOutputLayer();
    }

    @Override
    public double getError() {
        return error;
    }

    @Override
    public String toString()
    {
        String str = "Neural Network config:\n";
        for (NeuronLayer layer : this.layer)
        {
            str += layer.toString();
        }
        return str;
    }
}

package Network;

import DataStructure.NeuronLayerArray;
import DataStructure.TrainingDataCollection;
import DataStructure.TrainingData;
import Strategy.INeuronStrategy;
import Strategy.NeuronStrategyFactory;
import Utility.Utility;

import java.util.ArrayList;

/**
 * Created by EmilKarlsson on 11/27/16.
 */
public class NeuralNetwork implements INeuralNetwork
{

    private NeuronLayerArray layerArray = new NeuronLayerArray();
    private double error = 100;

    private NeuralNetwork(CreateNetwork network)
    {
        NeuronStrategyFactory strategyFactory = new NeuronStrategyFactory();

        NeuronLayer layer = new NeuronLayer("InputLayer");

        for (int i = 1; i <= network.inputLayer.getNumOfNeuron(); i++)
        {
            INeuronStrategy strat = strategyFactory.createStrategy(network.inputLayer.getTypeOfFunction(),network.inputLayer.getLearningRate());
            layer.add(new Neuron(strat,"Network.Neuron " + i));
        }

        layerArray.add(layer);

        int hiddenLayerNumber = 1;

        for (LayerProperties hiddenLayer : network.hiddenLayerArray)
        {
            layer = new NeuronLayer("HiddenLayer " + hiddenLayerNumber);
            for (int i = 1; i <= hiddenLayer.getNumOfNeuron(); i++)
            {
                INeuronStrategy strat = strategyFactory.createStrategy(hiddenLayer.getTypeOfFunction(),hiddenLayer.getLearningRate());
                layer.add(new Neuron(strat,"Network.Neuron " + i + hiddenLayerNumber));
            }

            layerArray.add(layer);
            hiddenLayerNumber++;
        }

        layer = new NeuronLayer("OutputLayer");

        for (int i = 1; i <= network.outputLayer.getNumOfNeuron(); i++)
        {
            INeuronStrategy strat = strategyFactory.createStrategy(network.outputLayer.getTypeOfFunction(),network.outputLayer.getLearningRate());
            layer.add(new Neuron(strat,"Network.Neuron " + i));
        }
        layerArray.add(layer);

        this.ConnectLayers();
    }

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

        for (i = layerArray.size()-2 ; i >= 0; i--)
        {
            NeuronLayer layer = layerArray.get(i);
            for (INeuron neuron : layer)
            {
                neuron.UpdateDelta();
            }
        }

        for (NeuronLayer layer : layerArray.getLayersWithParm())
        {
            for (INeuron neuron : layer )
            {
                neuron.UpdateFreeParams();
            }
        }
    }

    @Override
    public void TrainNetwork(TrainingDataCollection dataCollection, double tol,int iterations) {

        error = 100;
        int it = 0;

        while (error > tol && it < iterations)
        {
            double errorTemp = 100;
            for (TrainingData data : dataCollection)
            {
                this.TrainNetwork(data);
                errorTemp =+ this.getError();
            }
            error = errorTemp;
            it++;
        }

        System.out.println("Traning Done - Error: " + error + ", Iterations: " + it);
    }

    private void ConnectNeuron(INeuron source, INeuron destination, double weight) {

        destination.addToInputs(source,weight);
        source.addToForwardConnections(destination);
    }

    private void ConnectNeuron(INeuron source, INeuron destination) {

        this.ConnectNeuron(source,destination, Utility.getRandom());
    }

    private void ConnectLayers(NeuronLayer layer1, NeuronLayer layer2) {

        for (INeuron inputNeuron : layer1)
        {
            for (INeuron targetNeuron : layer2)
            {
                this.ConnectNeuron(inputNeuron,targetNeuron);
            }
        }
    }

    private void ConnectLayers()
    {
        for (int i = 0; i < layerArray.size()-1;i++)
        {
            this.ConnectLayers(layerArray.get(i),layerArray.get(i+1));
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

        for (NeuronLayer layer : layerArray.getLayersWithParm())
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
        return layerArray.getHiddenLayers();
    }

    private ArrayList<NeuronLayer> getLayersInRevers()
    {
        return layerArray.getHiddenLayersInRevers();
    }

    @Override
    public NeuronLayer getInputLayer() {
        return layerArray.getInputLayer();
    }

    @Override
    public NeuronLayer getOutputLayer() {
        return layerArray.getOutputLayer();
    }

    @Override
    public double getError() {
        return error;
    }

    @Override
    public String toString()
    {
        String str = "Neural Network config:\n";
        for (NeuronLayer layer : layerArray)
        {
            str += layer.toString();
        }
        return str;
    }

    public static class CreateNetwork
    {
        private LayerProperties inputLayer;
        private LayerProperties outputLayer;
        private ArrayList<LayerProperties> hiddenLayerArray = new ArrayList<LayerProperties>();

        public CreateNetwork addInputLayer(LayerProperties inputLayer)
        {
            this.inputLayer = inputLayer;
            return this;
        }

        public CreateNetwork addOutputLayer(LayerProperties outputLayer)
        {
            this.outputLayer = outputLayer;
            return this;
        }

        public CreateNetwork addHiddenLayer(LayerProperties hiddenlayer)
        {
            hiddenLayerArray.add(hiddenlayer);
            return this;
        }

        public NeuralNetwork build()
        {
            return new NeuralNetwork(this);
        }
    }
}

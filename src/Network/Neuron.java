package Network;

import DataStructure.NeuronArray;
import DataStructure.NeuronMap;
import Network.INeuron;
import Strategy.INeuronStrategy;
import Utility.Utility;

/**
 * Created by EmilKarlsson on 11/26/16.
 */
public class Neuron implements INeuron
{
    private String name;
    private double bias = Utility.getRandom();
    private double output;
    private double delta;
    private NeuronArray forwardConnections = new NeuronArray();
    private NeuronMap inputs = new NeuronMap();
    private INeuronStrategy strategy;

    public Neuron() {
    }

    public Neuron(INeuronStrategy strategy,String name) {
        this.strategy = strategy;
        this.name = name;
    }

    @Override
    public double getBiasValue() {
        return bias;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setBiasValue(double bias) {
        this.bias = bias;
    }

    @Override
    public double getOutputValue()
    {
        return output;
    }

    @Override
    public void setOutputValue(double output) {
        this.output = output;
    }

    @Override
    public double getDeltaValue() {
        return delta;
    }

    @Override
    public void setDeltaValue(double delta)
    {
        this.delta = delta;
    }

    @Override
    public INeuronStrategy getStrategy() {
        return strategy;
    }

    @Override
    public void setStrategy(INeuronStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public NeuronArray ForwardConnections() {
        return forwardConnections;
    }

    @Override
    public void addToForwardConnections(INeuron neuron) {
        this.forwardConnections.add(neuron);
    }

    @Override
    public NeuronMap Inputs() {
        return inputs;
    }

    @Override
    public void addToInputs(INeuron neuron, double weight) {
        this.inputs.Add(neuron,weight);
    }

    @Override
    public void UpdateOutput()
    {
        double Value = strategy.FindValue(inputs,bias);
        output = strategy.Activation(Value);
    }

    @Override
    public void UpdateDelta(double errorFactor)
    {
        delta = strategy.FindDelta(output,errorFactor);
    }

    @Override
    public void UpdateDelta()
    {
        double errorFactor = 0;
        for (INeuron neuron : forwardConnections)
        {
            errorFactor += neuron.getDeltaValue() * neuron.Inputs().getWeight(this);
        }
        delta = strategy.FindDelta(output,errorFactor);
    }

    @Override
    public void UpdateFreeParams()
    {
        bias = strategy.FindNewBias(bias,delta);
        strategy.UpdateWeights(inputs,delta);
    }

    @Override
    public String toString()
    {
        String str = "Network.Neuron: [Name: " + name + "\n" +
                     "           Strategy: " + strategy.toString() + "\n" +
                     "           Bias: " + Math.round(bias*1000)/1000.0 + "\n" +
                     "           ForwardConnections: " + forwardConnections.toString() + "\n" +
                     "           Inputs: " + inputs.toString() + "]";
        return str;
    }
}

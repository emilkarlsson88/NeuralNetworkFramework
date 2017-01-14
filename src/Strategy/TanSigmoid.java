package Strategy;

import DataStructure.NeuronMap;
import Network.INeuron;

/**
 * Created by EmilKarlsson on 12/9/16.
 */
public class TanSigmoid implements INeuronStrategy
{
    private double Learning_rate;
    private static final String name = "TanSigmoid";

    public TanSigmoid(double learningRate)
    {
        this.Learning_rate = learningRate;
    }

    @Override
    public double FindDelta(double output, double errorFactor)
    {
        return ( 1 - Math.pow(output,2) ) * errorFactor;
    }

    @Override
    public double Activation(double value)
    {
        return ( Math.exp(value) - Math.exp(-value) )/(Math.exp(value) + Math.exp(-value));
    }

    @Override
    public double FindValue(NeuronMap inputs, double bias)
    {
        double sum = bias;
        for(INeuron neuron : inputs.getNeurons() )
        {
            sum = sum + inputs.getWeight(neuron)*neuron.getOutputValue();
        }
        return sum;
    }

    @Override
    public double FindNewBias(double bias, double delta) {
        return bias + Learning_rate*delta;
    }

    @Override
    public void UpdateWeights(NeuronMap connections, double delta)
    {
        for(INeuron neuron : connections.getNeurons())
        {
            double newWeight = connections.getWeight(neuron)+ Learning_rate*neuron.getOutputValue()*delta;
            connections.Add(neuron,newWeight);
        }
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        String str = "[ Name :" + name + ", Learning rate: " + Learning_rate + " ]";
        return str;
    }
}

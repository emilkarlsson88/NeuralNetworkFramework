package Strategy;

import DataStructure.NeuronMap;
import Network.INeuron;

/**
 * Created by EmilKarlsson on 11/26/16.
 */
public class LogSigmoid implements INeuronStrategy
{
    private double Learning_rate;
    private static final String name = "LogSigmoid";

    public LogSigmoid(double learningRate)
    {
        this.Learning_rate = learningRate;
    }


    @Override
    public double FindDelta(double output, double errorFactor) {
        return output * (1 - output)*errorFactor;
    }

    @Override
    public double Activation(double value) {
        return 1/(1 + Math.exp(-value));
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
    public double FindNewBias(double bias, double delta)
    {
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
    public String getName() {
        return name;
    }

    @Override
    public String toString()
    {
        String str = "[ Name :" + name + ", Learning rate: " + Learning_rate + " ]";
        return str;
    }


}

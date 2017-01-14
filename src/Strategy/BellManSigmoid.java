package Strategy;

import DataStructure.NeuronMap;
import Network.INeuron;

/**
 * Created by EmilKarlsson on 12/11/16.
 */
public class BellManSigmoid implements INeuronStrategy
{
    private double Learning_rate;
    private static final String name = "BellManSigmoid";

    public BellManSigmoid(double learning_rate)
    {
        Learning_rate = learning_rate;
    }

    @Override
    public double FindDelta(double output, double errorFactor) {
        return 0;
    }

    @Override
    public double Activation(double value) {
        return value;
    }

    @Override
    public double FindValue(NeuronMap inputs, double bias) {
        double sum = 0;
        for(INeuron neuron : inputs.getNeurons() )
        {
            sum = sum + inputs.getWeight(neuron)*neuron.getOutputValue();
        }
        return sum;
    }

    @Override
    public double FindNewBias(double bias, double delta) {
        return 0; // the bellman
    }

    @Override
    public void UpdateWeights(NeuronMap connections, double delta) {

    }

    @Override
    public String getName() {
        return name;
    }
}

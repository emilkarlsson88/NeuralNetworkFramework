package Network;

import Strategy.ActivationFunctions;

/**
 * Created by EmilKarlsson on 12/10/16.
 */
public class LayerProperties
{
    private ActivationFunctions typeOfFunction;
    private int numOfNeuron;

    private double learningRate;

    public LayerProperties(ActivationFunctions typeOfFunction,double learningRate, int numOfNeuron) {
        this.typeOfFunction = typeOfFunction;
        this.numOfNeuron = numOfNeuron;
        this.learningRate = learningRate;
    }

    public double getLearningRate() {
        return learningRate;
    }

    public ActivationFunctions getTypeOfFunction() {
        return typeOfFunction;
    }

    public int getNumOfNeuron() {
        return numOfNeuron;
    }

}

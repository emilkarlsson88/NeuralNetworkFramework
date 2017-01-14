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

    public void setLearningRate(double learningRate) {
        this.learningRate = learningRate;
    }

    public ActivationFunctions getTypeOfFunction() {
        return typeOfFunction;
    }

    public void setTypeOfFunction(ActivationFunctions typeOfFunction) {
        this.typeOfFunction = typeOfFunction;
    }

    public int getNumOfNeuron() {
        return numOfNeuron;
    }

    public void setNumOfNeuron(int numOfNeuron) {
        this.numOfNeuron = numOfNeuron;
    }
}

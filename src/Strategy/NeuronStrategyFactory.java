package Strategy;

import Strategy.ActivationFunctions;
import Strategy.INeuronStrategy;
import Strategy.LogSigmoid;
import Strategy.TanSigmoid;

/**
 * Created by EmilKarlsson on 12/9/16.
 */
public class NeuronStrategyFactory
{

    public NeuronStrategyFactory()
    {

    }

    public INeuronStrategy createStrategy(ActivationFunctions funk, double learningRate)
    {
        INeuronStrategy activationFunction = null; //by defualt
        switch (funk)
        {
            case LogSigmoid:
                activationFunction = new LogSigmoid(learningRate);
                break;
            case TanSigmoid:
                activationFunction = new TanSigmoid(learningRate);
                break;
            case SmoothTan:
                activationFunction = new SmoothTan(learningRate);
                break;
        }

        return activationFunction;
    }
}

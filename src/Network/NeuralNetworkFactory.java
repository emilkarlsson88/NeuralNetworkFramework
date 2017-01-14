package Network;

import Strategy.INeuronStrategy;
import Strategy.NeuronStrategyFactory;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by EmilKarlsson on 11/27/16.
 */
public class NeuralNetworkFactory implements INetworkFactory
{
    @Override
    public INeuralNetwork CreateNetwork(LayerProperties inputlayer, LayerProperties outputlayer, HashMap<Integer,LayerProperties> hiddenLayers)
    {
        NeuralNetwork bnn = new NeuralNetwork();
        NeuronStrategyFactory strategyFactory = new NeuronStrategyFactory();

        NeuronLayer layer = new NeuronLayer("InputLayer");

        for (int i = 1; i <= inputlayer.getNumOfNeuron(); i++)
        {
            INeuronStrategy strat = strategyFactory.createStrategy(inputlayer.getTypeOfFunction(),inputlayer.getLearningRate());
            layer.add(new Neuron(strat,"Network.Neuron " + i));
        }

        bnn.addLayer(layer);


        Set<Integer> hiddenNum =  hiddenLayers.keySet();

        for (Integer num : hiddenNum)
        {
            layer = new NeuronLayer("HiddenLayer " + num);
            LayerProperties hidden = hiddenLayers.get(num);

            for (int i = 1; i <= hidden.getNumOfNeuron(); i++)
            {
                INeuronStrategy strat = strategyFactory.createStrategy(hidden.getTypeOfFunction(),hidden.getLearningRate());
                layer.add(new Neuron(strat,"Network.Neuron " + i + num));
            }
            bnn.addLayer(layer);
        }


        layer = new NeuronLayer("OutputLayer");

        for (int i = 1; i <= outputlayer.getNumOfNeuron(); i++)
        {
            INeuronStrategy strat = strategyFactory.createStrategy(outputlayer.getTypeOfFunction(),outputlayer.getLearningRate());
            layer.add(new Neuron(strat,"Network.Neuron " + i));
        }
        bnn.addLayer(layer);

        bnn.ConnectLayers();

        return bnn;
    }
}

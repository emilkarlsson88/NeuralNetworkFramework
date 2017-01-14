package Network.Test;

import Network.LayerProperties;
import Network.NeuralNetwork;
import Strategy.ActivationFunctions;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by EmilKarlsson on 1/14/17.
 */
public class NeuralNetworkTest
{
    @Test
    public void createNetworkTest()
    {
        NeuralNetwork network = new NeuralNetwork.CreateNetwork()
                .addInputLayer(new LayerProperties(ActivationFunctions.SmoothTan,0.1,2))
                .addHiddenLayer(new LayerProperties(ActivationFunctions.SmoothTan,0.9,3))
                .addOutputLayer(new LayerProperties(ActivationFunctions.LogSigmoid,0.9,1)).build();

        System.out.println(network.toString());

    }

    @Test
    public void LayerPorpertyTest()
    {
        LayerProperties layer = new LayerProperties(ActivationFunctions.SmoothTan,0.1,2);
        System.out.println(layer.toString());
    }

}
package Network;

import java.util.HashMap;

/**
 * Created by EmilKarlsson on 11/27/16.
 */
public interface INetworkFactory
{

    public INeuralNetwork CreateNetwork(LayerProperties inputlayer, LayerProperties outputlayer, HashMap<Integer,LayerProperties> hiddenLayers);

}

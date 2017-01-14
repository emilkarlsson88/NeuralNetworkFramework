package DataStructure;

import java.util.ArrayList;
import java.util.Collections;
import Network.*;

/**
 * Created by EmilKarlsson on 11/27/16.
 */
public class NeuronLayerArray extends ArrayList<NeuronLayer>
{

    public NeuronLayerArray() {
        super();
    }

    public ArrayList<NeuronLayer> getLayersWithParm()
    {
        return  new ArrayList<NeuronLayer>(super.subList(1,super.size()));
    }

    public void addLayer(NeuronLayer layer)
    {
        super.add(layer);
    }

    public ArrayList<NeuronLayer> getHiddenLayers()
    {
        // returns all layers exept the first and the last layer
        return  new ArrayList<NeuronLayer>(super.subList(1,super.size()-1));
    }

    public ArrayList<NeuronLayer> getHiddenLayersInRevers()
    {
        ArrayList<NeuronLayer> l = this.getHiddenLayers();
        Collections.reverse(l);
        return l;
    }

    public NeuronLayer getInputLayer()
    {
        return super.get(0);
    }

    public NeuronLayer getOutputLayer()
    {
        return super.get(super.size()-1);
    }
}

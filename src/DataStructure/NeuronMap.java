package DataStructure;

import Network.INeuron;

import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Double;
import Utility.Utility;


/**
 * Created by EmilKarlsson on 11/26/16.
 */
public class NeuronMap
{
    private HashMap<INeuron,Double> map = new HashMap<INeuron,Double>();

    public void Add(INeuron neuron, Double weight)
    {
        map.put(neuron,weight);
    }

    public void Add(INeuron neuron)
    {
        map.put(neuron, Utility.getRandom());
    }

    public void Remove(INeuron neuron)
    {
        map.remove(neuron);
    }

    public ArrayList<INeuron> getNeurons()
    {
        return new ArrayList<INeuron>(map.keySet());
    }

    public Double getWeight(INeuron neuron)
    {
        return map.get(neuron);
    }

    public String toString()
    {
        String str = "DataStructure.NeuronMap: [ ";
        for (INeuron neuron : map.keySet())
        {
            str += "{Name: " + neuron.getName() + ", Weight: " + Math.round(1000*map.get(neuron))/1000.0 + "} ";
        }
        str +=  "]";
        return str;
    }
}

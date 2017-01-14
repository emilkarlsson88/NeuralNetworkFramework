package Network;

import Network.INeuron;

import java.util.ArrayList;

/**
 * Created by EmilKarlsson on 11/27/16.
 */
public class NeuronLayer extends ArrayList<INeuron>
{
    private String name;

    public NeuronLayer(String name)
    {
        this.name = name;
    }

    public String toString()
    {
        String str = "[Name: " + name + "\n";
        for (int i = 0; i < super.size();i++)
        {
            str += super.get(i).toString() + "\n";
        }
        return str;
    }
}

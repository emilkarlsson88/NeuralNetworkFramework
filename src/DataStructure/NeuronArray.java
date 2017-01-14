package DataStructure;

import java.util.ArrayList;
import Network.INeuron;

/**
 * Created by EmilKarlsson on 11/26/16.
 */
public class NeuronArray extends ArrayList<INeuron>
{
    public NeuronArray()
    {

    }

    public String toString()
    {
        String str = "[";

        for (int i = 0; i < super.size();i++)
        {
            str += " {Name: " + super.get(i).getName() + "}";
        }
        str += "]";
        return str;
    }
}

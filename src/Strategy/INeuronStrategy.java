package Strategy;

import java.util.ArrayList;
import DataStructure.NeuronMap;

/**
 * Created by EmilKarlsson on 11/26/16.
 */
public interface INeuronStrategy
{
    public double FindDelta(double output,double errorFactor);
    public double Activation(double value);
    public double FindValue(NeuronMap inputs, double bias);
    public double FindNewBias(double bias,double delta);
    public void UpdateWeights(NeuronMap connections, double delta);
    public String getName();
}

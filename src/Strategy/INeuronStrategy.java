package Strategy;

import DataStructure.NeuronMap;

/**
 * Created by EmilKarlsson on 11/26/16.
 */
public interface INeuronStrategy
{
     double FindDelta(double output,double errorFactor);
     double Activation(double value);
     double FindValue(NeuronMap inputs, double bias);
     double FindNewBias(double bias,double delta);
     void UpdateWeights(NeuronMap connections, double delta);
     String getName();
}

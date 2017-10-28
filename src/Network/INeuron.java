package Network;

import DataStructure.NeuronArray;
import DataStructure.NeuronMap;
import Strategy.INeuronStrategy;

/**
 * Created by EmilKarlsson on 11/26/16.
 */
public interface INeuron
{
     double getBiasValue();
     String getName();
     void setBiasValue(double bias);
     double getOutputValue();
     void setOutputValue(double output);
     double getDeltaValue();
     void setDeltaValue(double delta);
     INeuronStrategy getStrategy();
     void setStrategy(INeuronStrategy strategy);
     NeuronArray ForwardConnections();
     void addToForwardConnections(INeuron neuron);
     NeuronMap Inputs();
     void addToInputs(INeuron neuron, double weight);
     void UpdateOutput();
     void UpdateDelta(double errorFactor);
     void UpdateDelta();
     void UpdateFreeParams();




}

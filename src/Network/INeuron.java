package Network;

import DataStructure.NeuronArray;
import DataStructure.NeuronMap;
import Strategy.INeuronStrategy;

/**
 * Created by EmilKarlsson on 11/26/16.
 */
public interface INeuron
{
    public double getBiasValue();
    public String getName();
    public void setBiasValue(double bias);
    public double getOutputValue();
    public void setOutputValue(double output);
    public double getDeltaValue();
    public void setDeltaValue(double delta);
    public INeuronStrategy getStrategy();
    public void setStrategy(INeuronStrategy strategy);
    public NeuronArray ForwardConnections();
    public void addToForwardConnections(INeuron neuron);
    public NeuronMap Inputs();
    public void addToInputs(INeuron neuron, double weight);
    public void UpdateOutput();
    public void UpdateDelta(double errorFactor);
    public void UpdateDelta();
    public void UpdateFreeParams();




}

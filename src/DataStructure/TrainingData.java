package DataStructure;

import java.util.ArrayList;

/**
 * Created by EmilKarlsson on 11/27/16.
 */
public class TrainingData
{
    private ArrayList<Double> input = new ArrayList<Double>();
    private ArrayList<Double> output = new ArrayList<Double>();

    public TrainingData() {
    }

    public TrainingData(ArrayList<Double> input, ArrayList<Double> output) {
        this.input = input;
        this.output = output;
    }

    public void addToInput(double data)
    {
        input.add(data);
    }

    public void addToOutput(double data)
    {
        output.add(data);
    }

    public ArrayList<Double> getInput() {
        return input;
    }

    public void setInput(ArrayList<Double> input) {
        this.input = input;
    }

    public ArrayList<Double> getOutput() {
        return output;
    }

    public void setOutput(ArrayList<Double> output) {
        this.output = output;
    }

    @Override
    public String toString()
    {
        String str = "Input: { ";
        for( Double d : input )
        {
            str += " " + d + ", ";
        }
        str += " }, ";

        str += "Output: { ";
        for( Double d : output )
        {
            str += " " + d + ", ";
        }
        str += " } \n";
        return str;
    }
}

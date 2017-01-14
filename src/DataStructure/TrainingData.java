package DataStructure;

import java.util.ArrayList;

/**
 * Created by EmilKarlsson on 11/27/16.
 */
public class TrainingData
{
    private ArrayList<Double> input;
    private ArrayList<Double> output;

    private TrainingData(Builder builder)
    {
        input = builder.input;
        output = builder.output;
    }

    public ArrayList<Double> getInput() {
        return input;
    }

    public ArrayList<Double> getOutput() {
        return output;
    }

    @Override
    public String toString()
    {
        String str = "Input: {";
        for( Double d : input )
        {
            str += " " + d + " ";
        }
        str += "}, ";

        str += "Output: {";
        for( Double d : output )
        {
            str += " " + d + " ";
        }
        str += "} \n";
        return str;
    }

    public static class Builder
    {
        private ArrayList<Double> input = new ArrayList<Double>();
        private ArrayList<Double> output = new ArrayList<Double>();

        public Builder addToInput(double data)
        {
            this.input.add(data);
            return this;
        }

        public Builder addToOutput(double data)
        {
            this.output.add(data);
            return this;
        }

        public TrainingData build()
        {
            return new TrainingData(this);
        }
    }
}

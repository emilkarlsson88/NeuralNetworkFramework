package Utility; /**
 * Created by EmilKarlsson on 11/26/16.
 */
import java.util.Random;

public class Utility
{
    private static Random r = new Random();
    public static int getRandomInt(int start, int end)
    {
       return r.nextInt(end + start) - start;
    }

    public static Double getRandom()
    {
        double ran = r.nextDouble();
        if(ran < 0.5)
        {
            return -5 + 2.5*r.nextDouble();
        }
        else
        {
            return 5 - 2.5*r.nextDouble();
        }
    }
}

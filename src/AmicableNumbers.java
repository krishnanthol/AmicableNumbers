import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class AmicableNumbers
{
    public static void main (String[] args)
    {
        File name = new File("src/pairs.text");
        List<Amicable> numbers = new ArrayList<>();
        List<Integer> factors1 = new ArrayList<>();
        List<Integer> factors2 = new ArrayList<>();
        int firstPairSum = 0;
        int secondPairSum = 0;

        try
        {
            BufferedReader input = new BufferedReader(new FileReader(name));
            String text;

            while ((text = input.readLine()) != null)
            {
                Amicable amicable = new Amicable(Integer.parseInt(text.split(" ")[0]), Integer.parseInt(text.split(" ")[1]));
                numbers.add(amicable);
            }

        }
        catch (Exception e)
        {

        }

        for (int i = 0; i < numbers.size(); i++)
        {
            for(int x = 0; x <= numbers.get(i).getFirstNum(); x++)
            {
                if(numbers.get(i).getFirstNum() % x == 0)
                {
                    factors1.add(x);
                }
            }

            for(int y = 0; y <= numbers.get(i).getSecondNum(); y++)
            {
                if(numbers.get(i).getSecondNum() % y == 0)
                {
                    factors2.add(y);
                }
            }

            for(int z = 0; z < factors1.size(); z++)
            {
                firstPairSum+=factors1.get(z);
            }

            for(int n = 0; n < factors2.size(); n++)
            {
               secondPairSum+=factors2.get(n);
            }
        }
    }
}

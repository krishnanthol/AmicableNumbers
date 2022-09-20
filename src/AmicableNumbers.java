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
            //find factors numbers in amicable pair
            for(int x = 1; x < numbers.get(i).getFirstNum(); x++)
            {
                if(numbers.get(i).getFirstNum() % x == 0)
                {
                    factors1.add(x);
                }
            }
            for(int y = 1; y < numbers.get(i).getSecondNum(); y++)
            {
                if(numbers.get(i).getSecondNum() % y == 0)
                {
                    factors2.add(y);
                }
            }

            //sum of the factors of the numbers in the amicable pair
            for(int z = 0; z < factors1.size(); z++)
            {
                firstPairSum+=factors1.get(z);
            }
            for(int n = 0; n < factors2.size(); n++)
            {
               secondPairSum+=factors2.get(n);
            }

            //check if the pair is amicable
            if(firstPairSum == numbers.get(i).getSecondNum() && secondPairSum == numbers.get(i).getFirstNum())
            {
                System.out.println("The numbers " + numbers.get(i).getFirstNum() + " and " + numbers.get(i).getSecondNum() + " are amicable.");
            }
            else
            {
                System.out.println("The numbers " + numbers.get(i).getFirstNum() + " and " + numbers.get(i).getSecondNum() + " are not amicable.");
            }

            //printing the factors of the numbers in the amicable pair and the sums
            System.out.print("\tFactors of " + numbers.get(i).getFirstNum() + " are ");
            for(int m = 0; m < factors1.size(); m++)
            {
                if(m == factors1.size() - 1)
                {
                    System.out.print("and " + factors1.get(m)+".");
                }
                else
                {
                    System.out.print(factors1.get(m) + ", ");
                }
            }
            System.out.println(" Sum is " + firstPairSum + ".");

            System.out.print("\tFactors of " + numbers.get(i).getSecondNum() + " are ");
            for(int l = 0; l < factors2.size(); l++)
            {
                if(l == factors2.size() - 1)
                {
                    System.out.print("and " + factors2.get(l)+".");
                }
                else
                {
                    System.out.print(factors2.get(l) + ", ");
                }
            }
            System.out.println(" Sum is " + secondPairSum + ".");

            //resetting variables for next amicable pair
            factors1.clear();
            factors2.clear();
            firstPairSum = 0;
            secondPairSum = 0;
        }
        }
    }

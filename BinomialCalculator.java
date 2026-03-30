import java.util.ArrayList;
import java.util.Scanner;

public class BinomialCalculator
{

    private static ArrayList<long[]> pascal = new  ArrayList();

    static
    {
       pascal.add(new long[]{1L});
    }

    public static long calcBinomialCoefficient(int n, int k)
    {
        long[] values;

        if (n < 0 || k < 0 || k > n)
        {
            return 0;
        }

        ensureSize(n,k);

        return pascal.get(n)[k];
    }


    private static void ensureSize(int n, int k)
    {
        while (pascal.size() <= n)
        {
            //this gets the array at the previous row
            long[] lastRow = pascal.get(pascal.size()-1);
            //the size of the new array is the size of the current array plus 1
            long[] newRow = new long[pascal.size()+1];

             //the 1 placed at the beginning of the row
             newRow[0] = 1;

             //the 1 placed at the end of the row
             newRow[newRow.length-1] = 1;

             for (int i = 1; i< newRow.length-1; i++)
             {
                 newRow[i] = lastRow[i-1] + lastRow[i];
             }

             pascal.add(newRow);
        }
    }


    public static void main(String[] args)
    {
        System.out.println("Testing binomial");

        //Creating the scanner to holds the users input
        Scanner sc = new Scanner(System.in);


        while(true)
        {

            try
            {
                System.out.print("Enter two numbers, or hit enter to quit: ");
                String input = sc.nextLine();

                if(input.isEmpty())
                {
                    System.out.println("Goodbye!");
                    break;
                }

                String[] position = input.split(" ");

                int n = Integer.parseInt(position [0]);
                int k = Integer.parseInt(position[1]);

                System.out.println("the binomial coefficient is " + calcBinomialCoefficient(n,k));


            } catch (NumberFormatException e)
            {
                System.out.println("I don't understand that please try again");
            }
        }
    }
}

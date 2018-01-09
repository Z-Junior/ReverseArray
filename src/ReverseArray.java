/**
 * @author Z
 * @since January 8 2018
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseArray
{
    private final static Scanner SCAN = new Scanner(System.in);

    public static void main(String[] args)
    {
        int iLen = PromptInt("Enter the size of the int array: ");

        int iNums[] = new int[iLen];

        for (int i = 0; i < iLen; i++)
            iNums[i] = PromptInt(String.format("Enter the value for %d: ", i + 1));

        System.out.println(String.format("Original order: %s", Arrays.stream(iNums).mapToObj(String::valueOf).collect(Collectors.joining(", "))));

        for (int i = 0; i < iLen / 2; i++)
        {
            int iTemp = iNums[i];

            iNums[i] = iNums[iLen - i - 1];
            iNums[iLen - i - 1] = iTemp;
        }

        System.out.println(String.format("Reversed order: %s", Arrays.stream(iNums).mapToObj(String::valueOf).collect(Collectors.joining(", "))));
    }

    protected static int PromptInt(String question)
    {
        System.out.print(question);

        while (!SCAN.hasNextInt())
        {
            System.out.flush();

            System.out.print("Enter a number: ");

            SCAN.next();
        }

        return SCAN.nextInt();
    }
}

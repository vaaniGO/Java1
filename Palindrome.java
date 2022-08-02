import java.util.*;

public class Palindrome

{

    int num, rev;

    Palindrome()

    {

        num=0;

        rev=0;

    }


    void Read()

    {

        Scanner sc = new Scanner (System.in);

        System.out.println("Enter the number: ");

        num=sc.nextInt();

    }


    void Rev()

    {

        int i=1;

        int d=0;

        int copy=num;

        while (copy>0)

        {

            d=copy%10;

            rev=(rev*10)+d;

            copy/=10;

        }

    }


    void Display()

    {

        if (num==rev)

            System.out.println("\nYes."+"\n"+num+" is a palindrome.");

        else

            System.out.println("\nNo."+"\n"+num+" is not a Palindrome.");

    }


    public static void main ()

    {

        Scanner sc = new Scanner (System.in);

        Palindrome P=new Palindrome();

        P.Read();

        P.Rev();

        P.Display();

    }

}

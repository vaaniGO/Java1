import java.util.*; 
public class Armstrong 
{
    int n; 
    Armstrong ()
    {
        n=0;
    }

    void Get()
    {
        Scanner sc = new Scanner (System.in); 
        System.out.println("Enter a number: "); 
        n=sc.nextInt(); 
    }

    int Sum_of_Cube ()
    {
        int copy=n; 
        int d=0, c, cubesum=0; 
        while (copy>0)
        {
            d=copy%10; 
            c=d*d*d; 
            cubesum+=c; 
            copy/=10; 
        }
        return cubesum; 
    }

    void Display()
    { 
        int a = Sum_of_Cube(); 
        if (n==a)
            System.out.println("\nYes."+"\n"+n+" is an Armstrong number.");
        else 
            System.out.println("\nNo."+"\n"+n+" is not an Armstrong number.");
    }

    public static void main ()
    {
        Scanner sc = new Scanner (System.in); 
        Armstrong A = new Armstrong(); 
        A.Get(); 
        A.Display();
    }
}


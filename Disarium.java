import java.util.*; 
public class Disarium
{
    int n, l; 
    Disarium()
    {
        n=0; 
        l=0;
    }

    void Input()
    {
        Scanner sc = new Scanner (System.in); 
        System.out.println("Enter the number: "); 
        n=sc.nextInt();
        l=Integer.toString(n).length(); 
    }

    int Sum()
    {
        int copy=n, s=0,a, d; 
        while (copy>0)
        {
            d=copy%10;   //digit
            a=(int)Math.pow(d,l);   //digit raised
            s+=a;  //sum of digit raised
            copy/=10;   //new num
            l=l-1;   //new length
        }
        return s; 
    }

    void Print ()
    {
        int b= Sum(); 
        if (b==n)
            System.out.println("\nYes."+"\n"+n+" is a Disarium number.");
        else 
            System.out.println("\nNo."+"\n"+n+" is not a Disarium number.");
    }

    public static void main ()
    {
        Disarium D = new Disarium (); 
        D.Input(); 
        D.Print();
    }
}


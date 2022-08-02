import java.util.*; 
public class Perfect_Constructor 
{
    int num,a,s,i;

    void Input ()
    {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the number: "); 
        num=sc.nextInt();
    }

    Perfect_Constructor ()
    {
        num=0;
    }

    int SumofFactors()
    {
        for (i=1; i<num; i++)
            if (num%i==0)
                a+=i;
        return a;
    }

    void display()
    {
        int s=SumofFactors(); 
        if (num==s)
            System.out.println(num+"is a perfect number.");
        else System.out.println(num+"is not a perfect number.");
    }

    public static void main (String [] scgs)
    {
        Scanner sc = new Scanner (System.in); 
        Perfect_Constructor P=new Perfect_Constructor(); 
        P.Input() ;
        P.display();
    }
}


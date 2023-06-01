import java.util.*; 
public class FillPrimes
{
    private int arr[][],r,c; 
    
    FillPrimes()
    {
        Scanner sc=new Scanner (System.in); 
        System.out.print("Enter the number of rows: "); 
        r=sc.nextInt(); 
        System.out.print("Enter the number of columns of the array: "); 
        c=sc.nextInt(); 
        arr= new int[r][c];
    }

    int isprime(int p)
    {
        int count=0; 
        for (int i=1; i<=p; i++)
            if (p%i==0)
                count++; 
        return count==2 ? 1: 0; 
    }
    
    void fill()
    {
        for (int i=0, k=1; i<r; i++)
            for (int j=0; j<c; j++)
            {
                while(isprime(++k)==0);     //single-line powerful while loop produces primes
                arr[i][j]= k;
            }
    }

    void print()
    {
        for (int i=0; i<r; i++)
        {
            for (int j=0; j<c; j++)
                System.out.print(arr[i][j]+"\t"); 
            System.out.println(); 
        }
    }

    public static void main()
    {
        FillPrimes obj=new FillPrimes(); 
        obj.fill(); 
        System.out.println("\nThe array after filling it with primes:");
        obj.print(); 
    }
}
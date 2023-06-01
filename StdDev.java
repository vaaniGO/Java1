import java.util.*; 
public class StdDev 
{
    private int x[], n; 

    StdDev(int nn)
    {
        n=nn; 
        x=new int [n]; 
    }

    void input()
    {
        Scanner sc = new Scanner (System.in); 
        System.out.println("\nEnter the elements of the array: "); 
        for (int i=0; i<n; i++)
            x[i]=sc.nextInt(); 
    }

    void display()
    {
        for (int i=0; i<n; i++)
            System.out.print(x[i]+", ");
        System.out.println(); //what does this mean ?
    }

    float mean()
    {
        float mean=0; 
        for (int i=0; i<n; i++)
            mean+= x[i]; 
        mean/= n;
        return mean;  
    }

    float stddev()
    {
        float sum= 0, mean= mean();
        for(int i=0; i<n; i++)
            sum+= (x[i] - mean)*(x[i] - mean);
        return (float)Math.sqrt(sum/n); 
    }

    public static void main ()
    {
        Scanner sc = new Scanner(System.in); 
        
        System.out.print("Enter the size of the array: ");
        int n=sc.nextInt(); 
        StdDev obj= new StdDev(n); 
        obj.input(); 
        
        float stdDev= obj.stddev();
                
        System.out.println("\nThe elements of the array are: ");
        obj.display();
        System.out.println("The standard deviation: "+stdDev); 
    }
}
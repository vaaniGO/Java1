import java.util.*; 
public class Swapper 
{
    private int elem[], n; 
    
    Swapper (int nn)
    {
        n= nn; //The computer is considered as a 'left-handed lady'. She accepts things with the left hand.
        elem= new int [n]; 
    }

    void read()
    {
        Scanner sc = new Scanner (System.in); 
        System.out.println("\nEnter the "+n+" elements for the array below: "); 
        for (int i=0; i<n; i++)
            elem[i]=sc.nextInt(); 
    }

    void display()
    {
        for (int i=0; i<n; i++)
            System.out.print(elem[i]+", "); 
        System.out.println();
    }

    boolean isEvenOddPair (int p, int q)
    {
        return (p+q)%2==1? true : false; 
    }

    void swapEvenOdd()
    {
        int i, temp;
        for (i=0; i<n-1; i+=2)
        {
            if(isEvenOddPair(elem[i], elem[i+1]))
            {
                temp= elem[i];
                elem[i]= elem[i+1];
                elem[i+1]= temp;
            }
        }
    }

    public static void main ()
    {
        Scanner sc = new Scanner (System.in); 
        
        System.out.print("Enter the size of the array: "); 
        int n=sc.nextInt(); 
        
        Swapper obj= new Swapper (n); 
        obj.read(); 
        
        System.out.println("\nThe elements of the array as given are: "); 
        obj.display(); 
        
        obj.swapEvenOdd();
        System.out.println("\nThe elements of the array after swapping the even odd elemens: "); 
        obj.display();
    }
}

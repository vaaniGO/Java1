import java.util.*; 
public class EqMat
{
    private int a[][], m,n; 

    EqMat(int mm, int nn)
    {
        m= mm; 
        n= nn; 
        a= new int [m][n]; 
    }

    void readarray()
    {
        Scanner sc=new Scanner (System.in); 
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                a[i][j]=sc.nextInt();
    }

    int check (EqMat P, EqMat Q) //these are two matrices actually in the form of two OBJECTS.
    {
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                if(P.a[i][j] != Q.a[i][j])
                    return 0;
        return 1;
    }

    void print()
    {
        for (int i=0; i<m; i++)
        {
            for (int j=0; j<n; j++)
                System.out.print(a[i][j]+"\t"); 
            System.out.println(); 
        }
    }

    public static void main()
    {
        Scanner sc=new Scanner (System.in); 
        int r1, c1, r2, c2;
        
        System.out.println("Enter the dimensions (row and columns) of the first matrix: ");
        r1= sc.nextInt(); 
        c1= sc.nextInt(); 
        System.out.println("Enter the dimensions (row and columns) of the second matrix: ");
        r2= sc.nextInt(); 
        c2= sc.nextInt(); 
        
        EqMat P=new EqMat(r1, c1), Q=new EqMat(r2, c2); 
        
        System.out.println("\nEnter the elements for the first matrix:");
        P.readarray();
        System.out.println("\nEnter the elements for the second matrix:");
        Q.readarray();
        
        System.out.println("\nThe elements of the first matrix (as given):");
        P.print(); 
        System.out.println("\nThe elements of the second matrix (as given):");
        Q.print(); 
        System.out.println("\nThese are "+(P.check(P, Q)==1?"equal": "unequal")+" matrices.");
    }
}
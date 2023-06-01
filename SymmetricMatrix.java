import java.util.Scanner; 
class SymmetricMatrix
{
    private int A[][], M; 
    
    void input ()
    {
        Scanner sc= new Scanner (System.in); 
        System.out.print("Enter the number of rows/columns for the square matrix: "); 
        M= sc.nextInt(); 
        if (M<2 || M>10)
        {
            System.out.println("\nTHE MATRIX SIZE IS OUT OF RANGE!"); 
            System.exit(0);
        }
        A= new int [M][M];
        System.out.println("\nEnter the elements of the matrix:"); 
        for (int i=0; i<M; i++)
            for (int j=0; j<M; j++)
                A[i][j]= sc.nextInt();
    }
    
    void display()
    {
        System.out.println("\nORIGINAL MATRIX:");
        for (int i=0; i<M; i++)
        {
            for (int j=0; j<M; j++)
                System.out.print(A[i][j]+"\t");
            System.out.println(); 
        }
    }
    
    boolean isSymmetric()
    {
        for (int i=0; i<M; i++)
            for (int j=0; j<M; j++)
                if (A[i][j] != A[j][i])
                    return false; 
        return true;
    }
    //Use ONE LOOP to finalize the below method code
    void diagonalSum() 
    {
        int leftSum=0, rightSum= 0; 
        for (int i=0; i<M; i++) {    
            leftSum+= A[i][i];
            rightSum+= A[i][M-1-i];
        }
        System.out.println("\nTHE SUM OF THE LEFT DIAGONAL: "+leftSum+
            "\nTHE SUM OF THE RIGHT DIAGONAL: "+rightSum);
    }
    
    public static void main() 
    {
        SymmetricMatrix obj= new SymmetricMatrix(); 
        obj.input(); 
        obj.display(); 
        if (obj.isSymmetric())
            System.out.print("\nTHE GIVEN MATRIX IS SYMMETRIC!"); 
        else 
            System.out.print("\nTHE GIVEN MATRIX IS NOT SYMMETRIC."); 
        obj.diagonalSum(); 
    }
}
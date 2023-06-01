import java.util.Scanner; 
class MatrixColumnSorter
{
    private int A[][], M, N;

    void input ()
    {
        Scanner sc= new Scanner (System.in); 
        System.out.println("Enter the number of rows and columns for the matrix below: "); 
        M= sc.nextInt(); 
        N= sc.nextInt();
        if (M<2 || M>10 || N<2 || N>10)
        {
            System.out.println("\nTHE MATRIX SIZE IS OUT OF RANGE!"); 
            System.exit(0);
        }
        A= new int [M][N];
        System.out.println("\nEnter the elements of the matrix:"); 
        for (int i=0; i<M; i++)
            for (int j=0; j<N; j++)
                A[i][j]= sc.nextInt();
    }

    void display()
    {
        for (int i=0; i<M; i++)
        {
            for (int j=0; j<N; j++)
                System.out.print(A[i][j]+"\t");
            System.out.println(); 
        }
    }

    void sort()
    {
        for (int i=0; i<N; i++)
            for (int j=0; j<M-1; j++)
                for (int k=0; k<M-j-1; k++)
                    if (A[k][i]>A[k+1][i])  
                    {
                        int temp= A[k][i]; 
                        A[k][i]= A[k+1][i]; 
                        A[k+1][i]= temp;
                    }
    }

    public static void main()
    {
        MatrixColumnSorter obj= new MatrixColumnSorter(); 
        obj.input(); 
        System.out.println("\nORIGINAL MATRIX:");
        obj.display(); 
        System.out.println("\nSORTED MATRIX:");
        obj.sort();
        obj.display();
    }
}
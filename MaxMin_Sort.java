import java.util.Scanner; 
class MaxMin_Sort 
{
    private int A[][], r, c;
    
    void input()
    {
        Scanner sc= new Scanner (System.in); 
        System.out.println("Enter the no. of rows and columns:"); 
        r= sc.nextInt(); 
        c= sc.nextInt(); 
        if (r<2 || c<2 || r>19 || c>19)
        {
            System.out.println("INVALID INPUT"); 
            System.exit(0);
        }
        A= new int [r][c];
        System.out.println("Enter the elements of the array:"); 
        for (int i=0; i<r; i++)
            for (int j=0; j<c; j++)
                A[i][j]= sc.nextInt(); 
    }
    
    void findMaxMinWithPos()
    {
        int max= A[0][0], min= A[0][0], Rmax=0, Cmax=0, Rmin=0, Cmin=0; 
        for (int i=0; i<r; i++)
            for (int j=0; j<c; j++)
                if (A[i][j]>max)
                {
                    max= A[i][j]; 
                    Rmax=i; Cmax=j;
                }
                else if (A[i][j]<min)
                {
                    min= A[i][j]; 
                    Rmin= i; Cmin=j; 
                }
        System.out.println("\nLargest Number: "+max+"\nRow: "+Rmax+"\nColumn: "+Cmax);
        System.out.println("Smallest Number: "+min+"\nRow: "+Rmin+"\nColumn: "+Cmin);
    }
    /* True it is a different kind of sorting involving BOTH the rows and columns.
     * But for that simple odd thing, SIX LOOPS, and that too in 2023 (US std.)?
     * Can you not reduce the loops down to std. ONE PAIR of loops only?
     */
    void sort()
    {
        int arr[]= new int [r*c], k=0; 
        for (int i=0; i<r; i++)
            for (int j=0; j<c; j++)
                arr[k++]= A[i][j];
        
        for (int i=0; i<r*c; i++)
            for (int j=0; j<r*c-i-1; j++)
                if (arr[j]>arr[j+1])
                {
                    int temp= arr[j]; 
                    arr[j]= arr[j+1]; 
                    arr[j+1]= temp;
                }
        k=0; 
        for (int i=0; i<r; i++)
            for (int j=0; j<c; j++)
                A[i][j]= arr[k++];
    }
    
    void display()
    {
        for (int i=0; i<r; i++)
        {
            for (int j=0; j<c; j++)
                System.out.print(A[i][j]+"\t"); 
            System.out.println();
        }
    }
    
    public static void main()
    {
        MaxMin_Sort obj= new MaxMin_Sort(); 
        obj.input();
        System.out.println("\nOriginal Matrix:"); 
        obj.display();
        obj.findMaxMinWithPos(); 
        obj.sort();
        System.out.println("\nRearranged matrix:"); 
        obj.display();
    }
}
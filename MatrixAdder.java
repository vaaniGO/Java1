/*
Write a program to store ‘n’ x ‘n’ elements in a two-dimensional squared array and then make 
provision to find the sum of each row, each column and each diagonal. Also find the sum of 
all the elements of the array.
Note: All the sums should be calculated in a single traversal of the array. In other words, 
only one pair of loops should be taken to calculate all the sums.
 */
import java.util.*; 
class MatrixAdder
{
    private int arr[][], n;

    MatrixAdder(int nn) 
    {
        n=nn; 
        arr= new int [n][n]; 
        Scanner sc = new Scanner (System.in); 
        System.out.println("\nEnter the elements of the array: "); 
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                arr[i][j]= sc.nextInt(); 
    }

    void display() //displays the 2-D array in the matrix format
    {
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<n; j++)
                System.out.print(arr[i][j]+"\t"); 
            System.out.println();
        }
    }

    void findSums() 
    {
        int sumLD=0, sumRD=0, sumR, sumC;
        for (int i=0; i<n; i++) 
        {
            sumLD+= arr[i][i]; 
            sumRD+= arr[i][n-1-i];
            sumR= sumC= 0; 
            for (int j=0; j<n; j++)
            { 
                sumR+=arr[i][j]; 
                sumC+=arr[j][i]; 
            }
            System.out.println("\nSum of row "+(i+1)+" = "+sumR); 
            System.out.println("Sum of column "+(i+1)+" = "+sumC); 
            System.out.println(); 
        }
        System.out.println("\nSum of elements of left diagonal: "+sumLD+
            "\nSum of elements of right diagonal: "+sumRD);
    }
    
    public static void main()
    {
        Scanner sc = new Scanner (System.in); 
        System.out.println("\nEnter the number of rows and columns: "); 
        int a=sc.nextInt(); 
        MatrixAdder obj= new MatrixAdder(a); 
        System.out.println("\nThe elements of the array are produced below: "); 
        obj.display(); 
        
        System.out.println("\nThe sums are printed below: "); 
        obj.findSums(); 
    }
}
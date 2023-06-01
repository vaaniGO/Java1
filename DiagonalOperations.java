/* Write a program to accept the no. of rows for a square matrix. Validate the rows to be 
 * even. Make provision to to perform the following taskes:
 * the following jobs with respect to the two diagonals of the matrix:
 * (i) Sum of the elements of the left and right diagonals (to be printed separately)
 * (ii) Highest and Lowest of the two diagonals (to be printed separately)
 * (iii) Arrange the elements of both the diaginals.
 */
import java.util.*;
class DiagonalOperations
{
    private int arr[][], n;

    DiagonalOperations(int nn)
    {
        n= nn;
        arr= new int [nn][nn]; 
    }

    void input()
    {
        Scanner sc = new Scanner (System.in);
        System.out.println("\nEnter the elements of the matrix:  ");
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)            
                arr[i][j]= sc.nextInt();
    }

    void display()  //- displays the 2-D array  elements
    {
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<n; j++)
                System.out.print(arr[i][j]+"\t"); 
            System.out.println(); 
        }
    }
    //Below method displays the elements of the two diagonals in the matrix format like an X 
    void showDiagonals()
    {
        for (int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
                System.out.print(i==j || i+j==n-1 ? arr[i][j]+"\t" : "\t");    
            System.out.println();
        }
    }

    void sumofDiagonals() //- extracts the elements of each diagonal and does sum+=
    {
        int sumL=0, sumR=0; 
        for (int i=0; i<n; i++)
        {
            sumL+= arr[i][i];  
            sumR+= arr[i][n-1-i]; 
        }
        System.out.println("\nSum of elements of the left diagonal: "+sumL+
            "\nSum of elements of the right diagonal: "+sumR);
    }

    void maxMinOfDiagonals()   //- extracts elements of each diagonal and updates the value of 'max' and min 
    //does this for both right and left diagonals and prints seperately
    {
        int maxL= arr[0][0], minL= maxL, maxR= arr[0][n-1], minR= maxR, i;
        for (i=0; i<n; i++)
        {
            if (arr[i][i] > maxL)
                maxL= arr[i][i]; 
            if (arr[i][i] < minL)
                minL=arr[i][i]; 
            if (arr[i][n-1-i] > maxR)
                maxR=arr[i][n-1-i]; 
            if (arr[i][n-1-i] < minR)
                minR=arr[i][n-1-i]; 
        }
        System.out.println("\nHighest value of Left diagonal: "+maxL+
            "\nLowest value of left diagonal: "+minL+
            "\nHighest value of right diagonal: "+maxR+ 
            "\nLowest value of right diagonal: "+minR); 
    }

    public static void main ()
    {
        Scanner sc = new Scanner (System.in); 

        System.out.print("Enter the number of rows and columns of the square matrix: "); 
        int n=sc.nextInt(); 
        DiagonalOperations obj= new DiagonalOperations(n); 
        obj.input(); 

        System.out.println("\nThe elements of the 2-D array are: "); 
        obj.display(); 

        obj.sumofDiagonals(); 
        obj.maxMinOfDiagonals(); 
        
        System.out.println("\nThe diagonals of the 2-D array are:");
        obj.showDiagonals(); 
    }
}
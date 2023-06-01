/* Write a program to store r x c elements in a 2-d array and then make provision to create the
 * Transposed matrix from the given matrix. 
 * A matrix is said to have transposed if its rows are swapped with its columns.
 */
import java.util.*;
class TransposeMatrix
{
    private int mat[][], row, col;
    
    TransposeMatrix(int r, int c)
    {
        row=r; 
        col=c; 
        mat=new int [row][col]; 
    }
    
    void input()
    {
      Scanner sc = new Scanner (System.in); 
      System.out.println("\nEnter the elements of the matrix: "); 
      for (int i=0; i<row; i++)
            for (int j=0; j<col; j++)
                mat[i][j]= sc.nextInt(); 
    }
    
    void display()
    {
        for (int i=0; i<row; i++)
        {
            for (int j=0; j<col; j++)
                System.out.print(mat[i][j]+"\t"); 
            System.out.println();
        } 
    }
    
    void createTranspose()
    {
        TransposeMatrix trn= new TransposeMatrix(col, row);
        for (int i=0; i<row; i++)
            for (int j=0; j<col; j++)
                trn.mat[j][i] = mat[i][j]; 
                    
        System.out.println("\nThe elements of the transposed matrix are:");
        trn.display();
    }
    
    public static void main()
    {
        Scanner sc = new Scanner (System.in); 
        System.out.println("Enter the number of rows and columns: ");
        int a=sc.nextInt(); 
        int b=sc.nextInt(); 
        
        TransposeMatrix obj = new TransposeMatrix(a,b);
        obj.input(); 
        
        System.out.println("\nThe elements of the 2-D array are produced below: "); 
        obj.display(); 
        
        obj.createTranspose();
    }
}
/* What you tried is known as 'self-transpose' a matrix where a Square matrix is transposed 
 * within itself. 
 * You may try that in home as HW. Remember to keep only n as the no. of rows/cols for the matrix
 * as self-transposed can be implemented only in a Square Matrix.
 */
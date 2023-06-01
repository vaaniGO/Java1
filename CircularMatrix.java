/* To fill a square matrix in a circular manner from 1 till N^2 where N is user-provided as follows:
 * If N= 4, N^2 = 16, then the array will be:
 * 1    2   3   4
 * 12   13  14  5
 * 11   16  15  6
 * 10   9   8   7 
 */
import java.util.Scanner;
class CircularMatrix
{
    public static void main()
    {
        Scanner sc=new Scanner (System.in); 

        System.out.print("Enter the size of the array: "); 
        int n= sc.nextInt();

        int arr[][]=new int[n][n], p=1, a=0, b=1,copy= n;
        /* p stores the counter for numbers to be filled 
        a is the coutner for no. of rows filled 
        b is the counter for no. of cols filled 
        copy stores n such that its value does not get reduced, copy-- because every iteration the no. 
        of elements to be filled decreses in proportion to the size n */
        
        /*# FOUR LOOPS used in 2023, and that for US std. ??? */
        //Kindly use only ONE LOOP for the entire process done below
        for (int k=0; k<=n/2; k++)
        {
            for (int j=a++; j<copy; j++) //HORIZONTAL TOP ROW WISE
                arr[k][j]=p++;

            for (int i=b++; i<copy; i++) //VERTICAL RIGHT MOST COLUMN WISE
                arr[i][n-1-k]=p++; 

            for (int j=copy-2; j>=k; j--) //HORIZONTAL BOTTOM ROW WISE
                arr[copy-1][j]=p++; 

            for (int i=copy-2; i>k; i--) //VERTICAL LEFT MOST COLUMN WISE
                arr[i][k]=p++; 
            copy--; 
        }
        
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<n; j++)
                System.out.print(arr[i][j]+"\t");
            System.out.println(); 
        }
    }
}

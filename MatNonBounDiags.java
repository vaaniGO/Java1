import java.util.Scanner;
class MatNonBounDiags
{
    private int arr[][], n;
    
    void input()
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the size for the 2-D array:"); 
        n= sc.nextInt(); 
        if (n <3 || n>10 )
        {
            System.out.println("\nINVALID INPUT"); 
            System.exit(0);
        }
        arr= new int [n][n]; 
        System.out.println("Enter the array elements:"); 
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                arr[i][j]= sc.nextInt();
    }

    void display()
    {
        for(int i=0; i<n; i++)
        {
            for (int j=0; j<n; j++)
                System.out.print(arr[i][j]+"\t"); 
            System.out.println();
        }
    }
    /*# Wrong technique/algorithm used below to track the non-boundary elements. 
     * NOTE: In your way (i.e. tracking the diagonal elements), four of the boundary elements will
     * be considered.
     * Kindly adopt an algorithm SIMILAR (but opposite of Boaundary) ALGORITHM to finalize the code 
     * below.
     * Will check this in the next class...
     */
    void sort()
    {
        int copy1[]= new int[n], copy2[]= new int[n], k=0, l=0;
        for (int i=0; i<n; i++)
        {   
            copy1[k++]= arr[i][i];
            copy2[l++]= arr[i][n-i-1];
        }
        
        for (int i=0; i<copy1.length-1; i++)
            for (int j=0; j<copy1.length-i-1; j++)
                if (copy1[j] > copy1[j+1])
                {
                    int temp= copy1[j]; 
                    copy1[j]= copy1[j+1]; 
                    copy1[j+1]= temp;
                }
                
        for (int i=0; i<copy2.length-1; i++)
            for (int j=0; j<copy2.length-i-1; j++)
                if (copy2[j]>copy2[j+1])
                {
                    int temp= copy2[j]; 
                    copy2[j]= copy2[j+1]; 
                    copy2[j+1]= temp;
                }
        k=0; l=0;
        for (int i=0; i<n; i++)
        {   
            arr[i][i]= copy1[k++];
            arr[i][n-i-1]= copy2[l++];
        }
    }
    
    void showDiagonals()
    {
        int sum=0, i, j; 
        System.out.println("\nDIAGONAL ELEMENTS:");
        for (i=0; i<n; i++)
        {
            for (j=0; j<n; j++)
            {
                if (i==j || i==n-j-1)
                {    
                    System.out.print(arr[i][j]+"\t");
                    sum+= arr[i][j];
                }
                else 
                    System.out.print(" "+"\t"); 
            }
            System.out.println();
        }
        System.out.println("\nSUM OF THE DIAGONAL ELEMENTS = "+sum);
    }
    
    public static void main()
    {
        MatNonBounDiags obj= new MatNonBounDiags(); 
        obj.input(); 
        System.out.println("\nORIGINAL MATRIX");
        obj.display();
        System.out.println("\nREARRANGED MATRIX");
        obj.sort(); 
        obj.display(); 
        obj.showDiagonals();
    }
}
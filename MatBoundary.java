import java.util.Scanner;
class MatBoundary
{
    private int arr[][], r, c;

    void input()
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of rows and columns for the 2-D array:"); 
        r= sc.nextInt(); 
        c= sc.nextInt();
        if (r <2 || c<2 || r>19 || c>19)
        {
            System.out.println("\nINVALID INPUT"); 
            System.exit(0);
        }
        arr= new int [r][c]; 
        System.out.println("Enter the array elements:"); 
        for (int i=0; i<r; i++)
            for (int j=0; j<c; j++)
                arr[i][j]= sc.nextInt();
    }

    void display()
    {
        for(int i=0; i<r; i++)
        {
            for (int j=0; j<c; j++)
                System.out.print(arr[i][j]+"\t"); 
            System.out.println();
        }
    }

    /*# "The boundary must appear as a boundary." As per this FIX the below code. */
    void displayBoundarySum()
    {
        int i, j, sum=0;
        System.out.println("\nBOUNDARY ELEMENTS:");
        for(i=0; i<r; i++)
        {
            for(j=0; j<c; j++)
                if (i==0 || i==r-1 || j==0  || j==c-1)
                {   
                    System.out.print(arr[i][j]+"\t"); 
                    sum+= arr[i][j];
                }
                else 
                    System.out.print(" \t");
            System.out.println(); 
        }
        System.out.println("\nSUM OF THE OUTER ROW AND COLUMN ELEMENTS = "+sum);
    }

    void sortBoundary()
    {
        int copy[]= new int[r*2+(c-2)*2], i, j, k=0;
        for (i=0; i<r; i++)
            for (j=0; j<c; j++)
                if (i==0 || i==r-1 || j==0  || j==c-1)
                    copy[k++]= arr[i][j];

        for (i=0; i<copy.length-1; i++)
            for (j=0; j<copy.length-1-i; j++)
                if (copy[j]>copy[j+1])
                {
                    int temp= copy[j]; 
                    copy[j]= copy[j+1]; 
                    copy[j+1]= temp;
                }
        k=0;
        for (i=0; i<2*r-2; i++)
        {    
            if (i==0 || i==r-1)
            {
                for(j=0; j<c; j++)
                    if(i==0)
                        arr[i][j]= copy[k++];
                    else if(i==r-1)
                        arr[i][c-j-1]= copy[k++];
            }
            else if(i>r-1)
                arr[r-i+(r-2)][0]= copy[k++];
            else if(i<r-1)
                arr[i][c-1]= copy[k++];
        }
    }

    public static void main()
    {
        MatBoundary obj= new MatBoundary(); 
        obj.input(); 
        System.out.println("\nORIGINAL MATRIX:"); 
        obj.display(); 
        
        obj.sortBoundary();
        System.out.println("\nREARRANGED MATRIX:"); 
        obj.display();
        obj.displayBoundarySum(); 
    }
}
import java.util.Scanner; 
class SaddlePoint_ISC
{
    private int A[][], n; 

    void input()
    {
        Scanner sc= new Scanner (System.in); 
        System.out.print("Enter the size of the square matrix: "); 
        n= sc.nextInt(); 
        if (n<0 || n>=20)
        {
            System.out.println("\nINVALID INPUT!"); 
            System.exit(0);
        }
        A= new int [n][n]; 

        System.out.println("\nEnter the elements of the array:"); 
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                A[i][j]= sc.nextInt();
    }

    void display()
    {
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<n; j++)
                System.out.print(A[i][j]+"\t"); 
            System.out.println();
        }
    }

    void findSaddlePoint()
    {
        int count=1;
        for (int j=0; j<n; j++)     //counter for the no. of rows and cols
        {
            int min= A[j][0], max= A[0][j];
            for (int i=1; i<n; i++) //finding min of row Why k-loop????? K-- Kalima Have respect
            {
                if (A[j][i]<min)
                    min= A[j][i]; 
                if (A[i][j]>max)
                    max= A[i][j];
            }
            if (min==max)
            {   
                System.out.println("\nSADDLE POINT:"+min);
                count=0;
                break;   
            }
        }
        System.out.println(count==1?"NO SADDLE POINT": "");
    }

    void sort()
    {
        for (int i=0; i<n-1; i++)
            for (int j=0; j<n-i-1; j++)
                if (A[j][j]>A[j+1][j+1])
                {
                    int temp= A[j+1][j+1]; 
                    A[j+1][j+1]= A[j][j]; 
                    A[j][j]= temp;
                }
    }
    
    public static void main()
    {
        SaddlePoint_ISC obj= new SaddlePoint_ISC(); 
        obj.input(); 
        
        System.out.println("\nGIVEN MATRIX ELEMENTS:");
        obj.display(); 
        obj.findSaddlePoint();
        
        obj.sort();
        System.out.println("MATRIX AFTER SORTING PRINCIPLE DIAGONAL:");
        obj.display(); 
    }
}
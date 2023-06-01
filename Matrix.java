import java.util.*; 
public class Matrix 
{
    private int mat[][], row, col; 

    static int max;

    Matrix (int r, int c)
    {
        row= r; 
        col= c; 
        mat= new int[r][c];
    }

    void input()
    {
        Scanner sc = new Scanner (System.in); 
        System.out.println("\nEnter the elements of the "+row+" x "+col+" matrix: "); 
        for (int i=0; i<row; i++)
            for (int j=0; j<col; j++)
            {
                mat[i][j]= sc.nextInt(); 
                if ((i==0 && j==0) || mat[i][j] > max)
                    max= mat[i][j]; 
            }
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

    void checkRows()
    {
        String rows= "";
        int i, j;
        for ( i=0; i<row; i++)
        {
            for ( j=0; j<col; j++)
                if (mat[i][j] != 0)
                    break; 
            if(j==col)
                rows+= (i+1)+", ";
        }
        if(rows=="")
            System.out.println("\nThere is no row found with all elements as 0!"); 
        else
            System.out.println("\nThe following row(s) have all the elements as zeros:\n"+rows);
    }

    void findSecMax()
    {
        int max2= -max, i, j, maxR=0, maxC= 0; 
        for (i=0; i<row; i++)
            for (j=0; j<col; j++)
                if (mat[i][j] < max && mat[i][j] > max2)
                {
                    max2= mat[i][j]; 
                    maxR= i;
                    maxC= j;
                }

        System.out.println("\nThe second highest element is "+max2+" occuring at ("+
            (maxR+1)+", "+(maxC+1)+")"); 
    }

    public static void main ()
    {
        Scanner sc = new Scanner (System.in); 
        Matrix obj; 

        System.out.println("Enter the number of rows and columns: "); 
        int r=sc.nextInt(); 
        int c=sc.nextInt(); 

        obj=new Matrix(r, c); 
        obj.input();
        System.out.println("\nThe elements of the given matrix are:");
        obj.display(); 
        obj.checkRows(); 
        obj.findSecMax(); 
    }
}
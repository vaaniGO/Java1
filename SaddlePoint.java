import java.util.*; 
public class SaddlePoint 
{
    private int mat[][], row, col;

    SaddlePoint(int r, int c)
    {
        row= r; 
        col= c;
        mat= new int [r][c]; 
    }

    void input()
    {
        Scanner sc = new Scanner (System.in); 
        System.out.println("\nEnter the elements of the "+row+" x "+col+" matrix: "); 
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

    int minOfRow(int r)
    {
        int min= mat[r][0], i;
        for (i=0; i<col; i++)
            if (mat[r][i] < min)
                min= mat[r][i]; 
        return min;
    }

    int maxOfCol(int c)
    {
        int max= mat[0][c]; 
        for (int i=0; i<row; i++)
            if (mat[i][c] > max)
                max= mat[i][c]; 
        return max;
    }

    void showSaddlePoint()
    {
        int count=0, i, j; 
        for (i=0; i<row; i++)
            for (j=0; j<col; j++)
                if (minOfRow(i) == maxOfCol(j))
                {
                    if(++count==1)
                        System.out.println("\nSaddle Point found! "+
                            "It exists at the following location(s): ");
                    System.out.println("("+(i+1)+", "+(j+1)+")");
                }
        if (count == 0)
            System.out.println("\nNo saddle points found!"); 
    }

    public static void main ()
    {
        Scanner sc = new Scanner (System.in); 
        System.out.println("Enter the number of rows and columns for the matrix: "); 
        int r=sc.nextInt(); 
        int c=sc.nextInt();
        
        SaddlePoint obj= new SaddlePoint(r, c); 
        obj.input(); 
        obj.display(); 
        obj.showSaddlePoint(); 
    }
}
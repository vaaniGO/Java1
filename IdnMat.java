import java.util.*; 
public class IdnMat
{
    private int mat[][], row; 

    IdnMat(int r)
    {
        row= r; 
        mat= new int [r][r];
        for(int i=0; i<r; i++)
            mat[i][i]= 1;
    }

    void input()
    {
        Scanner sc = new Scanner (System.in); 
        System.out.println("\nEnter the elements of the "+row+" x "+row+" matrix: "); 
        for (int i=0; i<row; i++)
            for (int j=0; j<row; j++)
                mat[i][j]=sc.nextInt(); 
    }

    void display()
    {
        for (int i=0; i<row; i++)
        {
            for (int j=0; j<row; j++)
                System.out.print(mat[i][j]+"\t");
            System.out.println();
        }
    }

    boolean isIdentity()
    {
        for (int i=0; i<row; i++)
            for (int j=0; j<row; j++)
                if (i==j && mat[i][j]!=1 || i!=j && mat[i][j] != 0)
                    return false;
        return true; 
    }

    public static void main ()
    {
        Scanner sc = new Scanner (System.in); 
        System.out.print("Enter the no. of rows/columns for the square matrix: "); 
        int n=sc.nextInt();

        IdnMat obj= new IdnMat(n); 
        obj.input();

        System.out.println("\nThe matrix is produced below: "); 
        obj.display(); 

        if (obj.isIdentity())
            System.out.println("\nYes, the given matrix is an Identity matrix.");
        else 
        {
            System.out.println("\nNo, the given matrix is NOT an Identitiy matrix."); 
            System.out.println("\nAn Identity matrix of "+n+" x "+n+" dimensions appear as:");
            obj= new IdnMat(n);
            obj.display();
        }
    }
}
import java.util.*; 
public class MagicSquare 
{
    private int mat[][], n;

    MagicSquare(int n)
    {
        this.n= n; 
        mat= new int[n][n]; 
    }

    void input()
    {
        Scanner sc = new Scanner (System.in); 
        System.out.println("\nEnter the elements of the "+n+" x "+n+" matrix: "); 
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                mat[i][j]=sc.nextInt(); 
    }

    void display()
    {
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<n; j++)
                System.out.print(mat[i][j]+"\t");
            System.out.println(); 
        }
    }

    int sumOfRow(int r)
    {
        int sum=0, i; 
        for (i=0; i<n; i++)
            sum+= mat[r][i]; 
        return sum; 
    }

    int sumOfCol(int c)
    {
        int i, sum=0; 
        for (i=0; i<n; i++)
            sum+= mat[i][c]; 
        return sum; 
    }

    int sumOfDiag(int d)
    {
        /* Accidentally you have recreated the kind of coding that used to be prevalent in 1990!!
         * Kindly PRSERVE it as a fond memory  
        if (d==1)
        {
        for (i=0; i<n; i++)
        sum+=mat[i][i]; 
        }
        else if (d==2)
        {
        for (i=0; i<n; i++)
        sum+=mat[i][n-i-1]; 
        }
         */
        /** However in 2022, US codes the following way: */ //Checks are deadly things in code!! 
        int i, leftSum=0, riteSum=0;
        for(i=0; i<n; i++)
        {
            leftSum+= mat[i][i];
            riteSum+= mat[i][n-1-i];
        }
        return d==1 ? leftSum : riteSum; 
    }

    /** NOTE: Never Input or Print in a function or a method that has a return type. */
    boolean isMagicSquare()
    {
        int sumD= sumOfDiag(1), sumR;
        for (int i=0; i<n; i++)
        {
            sumR= sumOfRow(i);
            if(sumR != sumOfCol(i) && sumR != sumD)
                return false;
        }
        return sumD != sumOfDiag(2) ? false: true;
    }

    public static void main ()
    {
        Scanner sc = new Scanner (System.in); 
        MagicSquare obj;

        System.out.print("Enter the number of rows or columns for the square matrix: "); 
        int n=sc.nextInt();

        obj= new MagicSquare(n); 
        obj.input(); 
        System.out.println("\nThe original array is displayed below: "); 
        obj.display(); 
        if (obj.isMagicSquare())
            System.out.println("\nYes, the matrix is a Magic Square."); 
        else 
            System.out.println("\nNO, the matrix is NOT a Magic Square."); 
    }
}
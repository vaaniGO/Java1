import java.util.*;
public class NumTable
{
    private int T[][], r, c;

    NumTable(int r, int c)
    {
        this.r= r; 
        this.c= c;
        T = new int[r][c];
        int elem=0;
        for (int i=0; i<r; i++)
            for (int j=0; j<c; j++)
            {
                elem= (int)Math.pow(i+1,3)+ (int)Math.pow(j+1,3); 
                T[i][j] = elem;  
            }
    }

    void display()
    {
        for (int i=0; i<r; i++)
        {
            for (int j=0; j<c; j++)
                System.out.print(T[i][j]+"\t");
            System.out.println(); 
        }
    }

    float norm()
    {
        int sum=0; 
        float norm=0; 
        for (int i=0; i<r; i++)
            for (int j=0; j<c; j++)
                sum+= T[i][j]*T[i][j];
        norm= (float)Math.sqrt(sum);
        return norm;
    }

    int sum()
    {
        int sum=0;
        for (int i=2; i<r && i<c; i+=2)
            sum+= T[i][i]; 
        return sum;
    }

    public static void main ()
    {
        Scanner sc = new Scanner (System.in); 
        int a, b;
        
        System.out.println("Enter the number of rows and columns: "); 
        a=sc.nextInt(); 
        b=sc.nextInt();
        
        NumTable obj= new NumTable (a,b);
        float norm= obj.norm(); 
        int sum= obj.sum(); 
        
        System.out.println("\nThe array is produced below: "); 
        obj.display();
        System.out.println("\nThe norm of this table is: "+norm);
        System.out.println("\nThe sum of required elements: "+sum);
    }
}
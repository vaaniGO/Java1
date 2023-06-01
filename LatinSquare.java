import java.util.Scanner;
class LatinSquare
{
    private int arr[][], n; 

    void input()
    {
        Scanner sc= new Scanner (System.in); 
        System.out.print("Enter the size of the 2D Array:"); 
        n= sc.nextInt(); 
        arr= new int[n][n]; 
        System.out.println("Enter the array elements:"); 
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                arr[i][j]= sc.nextInt();
    }

    void display()
    {
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<n; j++)
                System.out.print(arr[i][j]+"\t"); 
            System.out.println();
        }
    }
    //10 30 20 0 0 20 30 10 30 0 10 20 20 10 0 30
    boolean isLatinSquare() 
    {
        int freqInRow, freqInCol;
        for (int l=0; l<n; l++)
        {   
            freqInRow= freqInCol= 0;
            for (int i=0; i<n; i++)          
            {    
                for (int j=0; j<n; j++)    /*# Is the 3rd loop NECESSARY? Think and work. */
                {                       
                    if (arr[0][i]==arr[freqInRow][j++])
                        freqInCol++;
                    if (arr[0][i] == arr[j++][freqInRow])
                        freqInCol++;
                }
                freqInRow++;
            }
            if (freqInCol != n*2)
                return false;
        }
        return true;
    }

    public static void main()
    {
        LatinSquare obj= new LatinSquare(); 
        obj.input(); 
        System.out.println("\nORIGINAL ARRAY");
        obj.display();
        if (obj.isLatinSquare())
            System.out.println("\nYes, it is a Latin Square."); 
        else 
            System.out.println("\nNo, it is NOT a Latin Square."); 
    }
}
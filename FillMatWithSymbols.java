import java.util.Scanner;
class FillMatWithSymbols
{
    private char M[][], ch1, ch2, ch3; 
    private int n; 

    void input()
    {
        Scanner sc= new Scanner (System.in); 
        System.out.print("Enter the size of the array:"); 
        n= sc.nextInt(); 
        if (n<0 || n>10)
        {
            System.out.println("SIZE OUT OF RANGE!"); 
            System.exit(0);
        }
        M= new char[n][n]; 
        System.out.println("\nEnter the three symbols to fill the matrix with below:"); 
        ch1= sc.next().charAt(0); 
        ch2= sc.next().charAt(0); 
        ch3= sc.next().charAt(0); 
    }

    void display()
    {
        for (int i=0; i<n; i++)
        {
            System.out.println(); 
            for (int j=0; j<n; j++)
                System.out.print(M[i][j]+"\t");
        }
    }

    void fill()
    {
        for (int i=0; i<n; i++)
        {
            M[i][i]= ch3; 
            M[i][n-1-i]= ch3; 
            for (int j=i+1; j<n-i-1; j++) {    
                M[i][j]= ch1; 
                M[j][i]= ch2;
            }
            for (int j=n-i; j<i; j++) {
                M[i][j]= ch1;
                M[j][i]= ch2;
            }
        }
    }

    public static void main()
    {
        FillMatWithSymbols obj= new FillMatWithSymbols(); 
        obj.input(); 
        obj.fill();
        obj.display(); 
    }
}
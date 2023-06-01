import java.util.Scanner; 
class Wondrous 
{
    private int arr[][], n; 

    void input()
    {
        Scanner sc= new Scanner (System.in); 
        System.out.print("Enter the size of the square matrix:"); 
        n= sc.nextInt(); 
        if (n<0 || n>=20)
        {
            System.out.println("\nINVALID INPUT!"); 
            System.exit(0);
        }
        arr= new int [n][n]; 

        System.out.println("\nEnter the elements of the array:"); 
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                arr[i][j]= sc.nextInt();
    }
    //16 15 1 2 6 4 10 14 9 8 12 5 3 7 11 13
    void display()
    {
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<n; j++)
                System.out.print(arr[i][j]+"\t"); 
            System.out.println();
        }
    }

    int freqOf(int ele) //returns the frequency of the element 'ele' in the matrix
    {
        int count=0;
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                if (arr[i][j]==ele)
                    count++;
        return ele>=1 && ele<=n*n ? count : -1; 
    }

    /* Checks THREE ATTRIBUTES:
     * 1. That no element repeats
     * 2. That the row and col sum do not cross the designated sum.
     * 3. That each element lies b/w 1 - n^2
     * ???? !!!!
     * sir but if it has all the elements from 1- n2 then automatically condition 1 will be true...
     * GOD!!!!!
     * The matrix still can 1, 1, 2, 2, these are ALL b/w 1 and n^2!!!
     * Repetition is a SEPARATE CLAU
     * i thought it contains ALL the integers from 1 - n2. NO. ok
     */
    boolean isWondrous()
    {
        int sum= n/2*(n*n+1), rowSum=0, colSum=0;

        for (int i=0; i<n; i++)
        {   
            rowSum= colSum= 0;
            for (int j=0; j<n; j++)
            {
                if (freqOf(arr[i][j]) > 1)
                    return false;
                if(arr[i][j] < 1 || arr[i][j] > n*n)
                    return false;
                rowSum+= arr[i][j]; 
                colSum+= arr[j][i];
            }
            if (rowSum!=colSum && rowSum!= sum)
                return false;
        }
        return  true; 
    }

    boolean isPrime(int n)
    {
        if(n < 2)
            return false;
        for(int i=2; i<=n/2; i++)
            if (n%i==0)
                return false; 
        return true;
    }

    void primePrint()
    {
        String primes= "";
        System.out.println("Prime"+"\tRow index"+"\tColumn index");
        for (int num=2; num<n*n; num++)
            for(int i=0; i<n; i++)
                for (int j=0; j<n; j++)
                    if (isPrime(num) && num==arr[i][j])
                    {
                        primes+= arr[i][j]+" ";
                        if(primes.indexOf(arr[i][j])==-1)
                            System.out.println(arr[i][j]+"\t\t"+i+"\t\t"+j);
                    }
    }

    public static void main()
    {
        Wondrous obj= new Wondrous(); 
        obj.input();
        System.out.println("\nThe given elements of the square matrix:");
        obj.display(); 
        if (obj.isWondrous())
            System.out.println("Yes, it represents a wondrous square.");
        else 
            System.out.println("Not a wondrous square");
        obj.primePrint();
    }
}

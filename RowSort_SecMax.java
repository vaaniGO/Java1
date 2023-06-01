import java.util.Scanner; 
class RowSort_SecMax
{
    public static void main()
    {
        Scanner sc= new Scanner (System.in); 
        System.out.print("Enter the size of the square matrix: "); 
        int n=sc.nextInt();
        if (n>20)
        {
            System.out.println("INVALID INPUT!");
            System.exit(0);
        }
        int list[][]= new int[n][n], i=0, j=0, rowMax=0, colMax=0, row2Max=0, col2Max=0; 

        System.out.println("Enter the elements of the list:"); 
        for (i=0; i<n; i++)
            for (j=0; j<n; j++)
                list[i][j]= sc.nextInt();  
        int max= list[0][0], secMax=list[0][0];

        System.out.println("\nGiven list:");
        for (i=0; i<n; i++)
        {
            for (j=0; j<n; j++)
                System.out.print(list[i][j]+"\t"); 
            System.out.println();
        }
        /*# Reduce the checks and limit to TWO only (if possible).*/
        for (i=0; i<n; i++)
            for (j=0; j<n; j++)
                if (list[i][j]>max)
                {
                    secMax= max; 
                    row2Max= rowMax; col2Max= colMax; 
                    max= list[i][j];
                    rowMax= i; colMax= j; 
                }
                else if (list[i][j]> secMax) 
                {
                    secMax= list[i][j]; 
                    row2Max=i; col2Max= j;
                }
                else if (secMax==max)
                {
                    secMax= list[i][j]; 
                    row2Max=i; col2Max=j;
                }
        System.out.println("\nThe largest element "+max+" is in row "+(rowMax+1)+
            " and column "+(colMax+1));
        System.out.println("The second largest element "+secMax+" is in row "+(row2Max+1)
            +" and column "+(col2Max+1)); 
        /*
        Given list:
        12    12    12    
        12    3    5    
        4    8    10    

        The largest element 12 is in row 1 and column 1
        The second largest element 12 is in row 1 and column 1
        */
        for (i=0; i<n; i++)
            for (j=0; j<n-1; j++)
                for (int k=0; k<n-j-1; k++)
                    if (list[i][k]>list[i][k+1])  
                    {
                        int temp= list[i][k]; 
                        list[i][k]= list[i][k+1]; 
                        list[i][k+1]= temp;
                    }
        System.out.println("\nSorted list:");
        for (i=0; i<n; i++)
        {
            for (j=0; j<n; j++)
                System.out.print(list[i][j]+"\t"); 
            System.out.println();
        }
    }
}
import java.util.Scanner; 
class Sorter
{
    private int arr[];
    
    Sorter()
    {
        arr= new int [10];
    }
    
    void readList()
    {
        Scanner sc= new Scanner (System.in); 
        System.out.println("Enter the 10 integers:"); 
        for (int i=0; i<10; i++)
            arr[i]= sc.nextInt();
    }
    
    void displayList()
    {
        for (int i=0; i<10; i++)
            System.out.print(arr[i]+"\t");
        System.out.println();
    }
    
    int indexOfMin (int startIndex)
    {
        int i, minInd= startIndex; 
        for (i=startIndex+1; i<10; i++)
            if (arr[i] < arr[minInd])
                    minInd= i; 
        return minInd;
    }
    
    void selectionSort()
    {
        for (int i=0; i<9; i++)
        {
            int minIn= indexOfMin(i);
            int temp= arr[minIn]; 
            arr[minIn]= arr[i]; 
            arr[i]= temp;
        }
    }
    
    public static void main()
    {
        Sorter obj= new Sorter(); 
        obj.readList(); 
        System.out.println("\nOriginal array:"); 
        obj.displayList(); 
        obj.selectionSort(); 
        System.out.println("\nSorted array:"); 
        obj.displayList();
    }
}
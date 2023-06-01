import java.util.Scanner; 
class Sort
{
    private int arr[], item; 

    static Scanner sc= new Scanner (System.in);

    void inpData()
    {
        arr= new int [10]; 
        System.out.println("Enter the 10 elements of the array:");
        for (int i=0; i<10; i++)
        {
            arr[i]= sc.nextInt();
            for (int j=0; j<i; j++)
                if (arr[j]==arr[i])
                {
                    System.out.println("Duplicate number found! Kindly reenter."); 
                    i--;
                }
        }
    }
  
    void bubSort()
    {
        for (int i=0; i<10; i++)    //i<size
            for (int j=0; j<9-i; j++)   //j<size-i-1
                if (arr[j]>arr[j+1])    
                {
                    int temp= arr[j];   //swap arr[j] and arr[j+1]
                    arr[j]= arr[j+1]; 
                    arr[j+1]= temp; 
                }
        System.out.println("\nThe elements of the array after sorting in ascending order:");
        for (int i=0; i<10; i++)    
            System.out.print(arr[i]+"\t");
        System.out.println();
    }

    void binSearch()
    {
        int lb=0, ub= 9, mid=(lb+ub)/2; 
        System.out.println("Enter the element to search for:");
        item= sc.nextInt();
        while (lb<=ub)
        {
            mid=(lb+ub)/2;
            if (item==arr[mid])
                break; 
            else if (item > arr[mid])
                lb= mid+1; 
            else 
                ub= mid-1; 
        }
        if (lb>ub)
            System.out.println("\n"+item+" was not found in the array!"); 
        else
            System.out.println("\n"+item+" found at position "+(mid+1)); 
    }

    public static void main()
    {
        Sort obj= new Sort(); 
        obj.inpData(); 
        obj.bubSort(); 
        obj.binSearch();
    }
}
import java.util.*; 
public class Searcher 
{
    private int arr[], n; 

    Searcher (int nn)
    {
        n=nn; 
        arr=new int[nn]; 
    }

    void read()
    {
        Scanner sc = new Scanner (System.in); 
        System.out.println("\nEnter the "+n+" integers (one after another) below:");
        for (int i=0; i<n; i++)
            arr[i]=sc.nextInt(); 
    }

    void show()
    {
        for (int i=0; i<n; i++)
            System.out.print(i==n-1? arr[i] : arr[i]+", "); 
        System.out.println(); 
    }

    int sortOrder()
    {
        int ascCnt=0, descCnt=0; 
        for (int i=0; i<n-1; i++) 
        {
            if (arr[i] <= arr[i+1])
                ascCnt++; 
            if (arr[i] >= arr[i+1])
                descCnt++;
        } 
        return ascCnt == n-1 ? 1: descCnt == n-1 ? 2 : 0;
    }

    int linearSearch (int x)
    {
        for (int i=0; i<n; i++)
            if (arr[i]==x)
                return i;
        return -1;
    }

    int binarySearch(int x)
    {
        int lb=0, ub=n-1, mid=0, order= sortOrder(); 
        while (lb <= ub)
        {
            mid = (lb+ub)/2;
            if(arr[mid] == x)
                break;
            else if (order==1 && arr[mid] < x || order==2 && arr[mid] > x)
                lb = mid+1; 
            else 
                ub= mid-1;
        }
        return lb<=ub ? mid : -1; 
    }

    void showSearchResults(int x)
    {
        int order= sortOrder(), matchIndex;
        if(order == 0)
        {
            System.out.println("\nArray found unsorted! Hence Linear Search technique is adopted.");
            matchIndex= linearSearch(x);
        }
        else 
        {
            String ord= order==1 ? "ascending": "descending";
            System.out.println("\nArray found sorted in "+ord+" order!"+
                " Hence Binary Search technique is adopted.");
            matchIndex= binarySearch(x);
        }
        if(matchIndex == -1)
            System.out.println("\nThe search element '"+x+"' was not found.");
        else
            System.out.println("\nThe search element '"+x+"' was found at position "+(matchIndex+1)+".");
    }

    public static void main(String[] args)
    {
        Scanner sc= new Scanner (System.in); 
        int n, srchElem, order;
        
        System.out.print("Enter the number of elements: "); 
        n=sc.nextInt();
        
        Searcher obj= new Searcher (n);
        obj.read();
        
        System.out.println("\nThe elements of the array are:");
        obj.show(); 
        
        System.out.print("\nEnter the search element: "); 
        srchElem=sc.nextInt();
        obj.showSearchResults(srchElem); 
    }
}
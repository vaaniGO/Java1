import java.util.Scanner; 
class Set   //although the name is Set, yet assume there might be repetitive elements in them
{
    private int arr[], n; 

    Set (int nn)
    {
        n= nn; 
        arr= new int [n];
    }

    void readElements()
    {
        Scanner sc= new Scanner (System.in); 
        for (int i=0; i<n; i++)
            arr[i]= sc.nextInt();
    }

    void displayElements()
    {
        for (int i=0; i<n; i++)
            System.out.print(arr[i]+", ");
        System.out.println();
    }

    int getSize()
    {
        return n;
    }

    int has (int ele)
    {
        for (int i=0; i<n; i++)
            if (arr[i]==ele)
                return 1;
        return 0;
    }
    
    Set intersection (Set d)
    {
        Set intersec= new Set(n<d.n? n: d.n); //intersection array's size is lesser of the two multi-sets 
        intersec.n= 0;;        
        for (int i=0; i<n; i++)
            if (d.has(arr[i])==1 && intersec.has(arr[i])==0)
                intersec.arr[intersec.n++]= arr[i];
        return intersec; 
    }   

    Set union (Set d)
    {
        Set unObj= new Set(this.getSize()+d.getSize()); 
        int k, i; 
        
        for (i=0, k=0; i<unObj.n; i++)
        {
            if (i<this.n && unObj.has(this.arr[i])==0)
                unObj.arr[k++]= this.arr[i];
            if (i<d.n && unObj.has(d.arr[i])==0)
                unObj.arr[k++]= d.arr[i]; 
        }
        unObj.n= k; 
        return unObj; 
    }
  
    public static void main()
    {
        Scanner sc= new Scanner (System.in); 
        Set a, b, intersec, union; 
        int na, nb; 
        
        System.out.print("Size of set A: "); 
        na= sc.nextInt();
        a= new Set (na);
        System.out.print("Size of set B: "); 
        nb= sc.nextInt();
        b= new Set (nb);
        
        System.out.print("\nEnter elements of set A: "); 
        a.readElements(); 
        System.out.print("\nEnter elements of set B: "); 
        b.readElements();
         
        System.out.print("\nElements of set A: "); 
        a.displayElements(); 
        System.out.print("\nEnter elements of set B: "); 
        b.displayElements(); 
        
        System.out.print("\nIntersection of A and B: "); 
        intersec= a.intersection(b); 
        intersec.displayElements();
        
        System.out.print("\nUnion of A and B: "); 
        union= a.union(b); 
        union.displayElements();
    }
}
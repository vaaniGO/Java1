import java.util.Scanner; 
class Rearrange
{
    private int a[], n, pos1, pos2, item;
    
    void enter()
    {
        Scanner sc= new Scanner(System.in); 
        System.out.println("Enter the size of the array:"); 
        n= sc.nextInt();
        a= new int[n+1]; 
        System.out.println("\nEnter the "+n+ " elements for the array:"); 
        for (int i=0; i<n; i++)
            a[i]= sc.nextInt(); 
        System.out.println("\nOriginal array:"); 
        for (int i=0; i<n; i++)
            System.out.print(a[i]+"\t");
    }
    
    void insert()
    {
        Scanner sc= new Scanner (System.in); 
        System.out.println("\nEnter element to be inserted:"); 
        item= sc.nextInt(); 
        System.out.println("Enter position of insertion:"); 
        pos1= sc.nextInt();
        int i= a.length-1; 
        while (i >= pos1-1 && i>0)
        {
            a[i]= a[i-1]; 
            i--;
        }
        a[pos1-1]= item; 
    }
    
    void disp1()
    {
        System.out.println("\nThe array after inserting:");
        for (int i=0; i<a.length; i++)
            System.out.print(a[i]+"\t");
    }
    
    void remove()
    {
        Scanner sc= new Scanner (System.in); 
        System.out.println("\nEnter position of removal:"); 
        pos2= sc.nextInt();
        int i= pos2-1; 
        while (i<a.length-1)
        {
            a[i]= a[i+1]; 
            i++;
        }
    }
    
    void disp2()
    {
        System.out.println("The array after deleting:");
        for (int i=0; i<n; i++)
            System.out.print(a[i]+"\t");
    }
    
    public static void main()
    {
        Rearrange obj= new Rearrange(); 
        obj.enter(); 
        obj.insert(); 
        obj.disp1(); 
        obj.remove(); 
        obj.disp2();
    }
}
import java.util.*; 
public class Kaprekar
{
    public static void main (String []scgs)
    {
        Scanner sc = new Scanner (System.in); 
        int num, left, right, sq, len; 
        
        System.out.println("Enter the number: "); 
        num=sc.nextInt(); 
        
        sq=num*num; 
        
        len = (num+"").length();
        
        right=sq%((int)Math.pow(10,len)); 
        left=sq/((int)Math.pow(10,len)); 
        
        if (right+left==num) 
          System.out.println(num+" squared= "+sq+"\n"+left+" + "+right+" = "+num); 
        else 
          System.out.println("Not a Kaprekar."); 
    }
}
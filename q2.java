import java.util.*;
class lab
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        String[] names = new String[n];
        
        for(int i =0;i<n;i++)
        {
            names[i] = sc.nextLine();
        }
        
        System.out.println("Original Array: Apple Banana");
        System.out.print("Array after adding new elements: Apple Banana");
        for(int i =0;i<n;i++)
        {
            System.out.print(names[i]+" ");
        }
        
    }
}

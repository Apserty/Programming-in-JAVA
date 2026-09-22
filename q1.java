import java.util.Scanner;

// You are using Java
class LetterBuffer
{
    private final StringBuilder result = new StringBuilder();
    
    public void append(char c)
    {
        if(result.length() > 0)
        {
            result.append(" ");
        }
        
        result.append(c);
    }
    
    public String getResult()
    {
        return result.toString();
    }
}



class VowelThread extends Thread 
{
    private final LetterBuffer buffer;
    private final int n;
    private final char[] vowels = {'A','E','I','O','U'};
    
    public VowelThread(LetterBuffer buffer, int n)
    {
        this.buffer = buffer;
        this.n = n;
    }
    
    @Override
    public void run()
    {
        for(int i=0;i<n;i++)
        {
            synchronized (buffer)
            {
                buffer.append(vowels[i%5]);
                buffer.notify();
                
                if(i<n-1)
                {
                    try
                    {
                        buffer.wait();
                    }
                    catch(InterruptedException e)
                    {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}



class ConsonantThread extends Thread
{
    private final LetterBuffer buffer;
    private final int n;
    private final char[] consonants = {
        'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 
        'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'
    };
    
    public ConsonantThread(LetterBuffer buffer,int n)
    {
        this.buffer = buffer;
        this.n = n;
    }
    
    @Override
    public void run()
    {
        for(int i=0;i<n;i++)
        {
            synchronized(buffer)
            {
                buffer.append(consonants[i]);
                buffer.notify();
                
                if(i<n-1)
                {
                    try
                    {
                        buffer.wait();
                    }
                    catch(InterruptedException e)
                    {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        LetterBuffer buffer = new LetterBuffer();
        Thread t1 = new VowelThread(buffer, n);
        Thread t2 = new ConsonantThread(buffer, n);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(buffer.getResult());
    }
}

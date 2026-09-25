Problem Statement



Kevin is building a simple data pipeline using the classic Producer-Consumer pattern. A Producer thread generates integers from 1 to n, one at a time, and 
  places each into a shared buffer of capacity 1. A Consumer thread removes each integer from the buffer as soon as it is produced and prints it.



The producer must wait if the buffer is currently full (i.e., the previous value hasn't been consumed yet), and the consumer must wait if the buffer is currently empty,
  ensuring no integer is ever lost or consumed twice.

Note: The solution must use Java multithreading concepts (Thread, wait(), notify()/notifyAll()) for proper synchronization between the producer and consumer.

Input format :
A single integer n, representing how many integers the producer will generate.

Output format :
For each integer from 1 to n, print Produced: <value> immediately followed by Consumed: <value> on the next line.



Refer to the sample output for formatting specifications.

Code constraints :
The given test cases fall under the following constraints:

1 ≤ n ≤ 50

Sample test cases :


      Input 1 :
          5
      Output 1 :
          Produced: 1
          Consumed: 1
          Produced: 2
          Consumed: 2
          Produced: 3
          Consumed: 3
          Produced: 4
          Consumed: 4
          Produced: 5
          Consumed: 5

  
      Input 2 :
          3
      Output 2 :
          Produced: 1
          Consumed: 1
          Produced: 2
          Consumed: 2
          Produced: 3
          Consumed: 3

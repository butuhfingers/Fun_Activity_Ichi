import java.sql.Time;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
/**
 * Created by derek on 1/27/17.
 */
public class Index {
    public static void main(String[] args){
        //Move the stack to the queue
        Index myIndex = new Index();
        int size = 10000000;

        long startTime = System.currentTimeMillis();

        //Create a stack
        Stack<Integer> myStack = myIndex.createRandomStack(size);
        Queue<Integer> myQueue = new LinkedList<Integer>();
        Integer[] myArray = new Integer[myStack.getSize()];

        //Put into array
        for(int i = 0;i < myStack.getSize();i++){
            myArray[i] = myStack.pop();
        }

        //Put back into stack and QUeue
        for(int i = 0;i< myStack.getSize();i++){
            int placeHolder = ((myStack.getSize() - 1) - i);

            myQueue.add(myArray[placeHolder]);
            myStack.push(myArray[placeHolder]);
        }

        System.out.println((System.currentTimeMillis() - startTime));
    }

    //Create a random stack of intengers of [size]
    private Stack<Integer> createRandomStack(int size){
        //Create the stack of integers
        Stack<Integer> stack = new Stack<Integer>(size);

        Random randomGenerator = new Random();
        //Foreach part of the stack
        for(int i = 0;i < size;i++){
            //Push a random number
            stack.push(new Integer(randomGenerator.nextInt(size + 1)));
        }

        return stack;
    }
}

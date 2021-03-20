//TODO Activity 4.x
//Implement this class.  Refer to the participant guide for the instructions

/*
 * Created on Aug 11, 2005
 * Accenture Manila Delivery Center
 * Technology Managed Services
 * Makati Stock Exchange Bldg
 * Makati City, Philippines
 */
//
package d1.datastore;

import d1.cardgame.Card;

public class ArrayStore extends AbstractArrayStore {
    
    //You have a free hand in implementing the requirements of this class.  You may declare any
    //additional members that you deem necessary.  The only restriction again is that you do not
    //violate the encapsulation of the class.
    
    //HINT: This class has direct access to the protected and public members of AbstractArrayStore
    
    public ArrayStore(int size) { 
        super(size);
    }

    public ArrayStore(){
        super();
    }

    @Override
    public boolean add(Object arg) {
        if(arg == null){
            throw new IllegalArgumentException("arraystore.method.argument.invalid");
        }

        //start solution
        if (!isFull()){
            store[currentCount] = arg;
            currentCount++;
            return true;
        }

        return false;

    }

    @Override
    public boolean remove(Object arg) {

        if(arg == null){
            throw new IllegalArgumentException("arraystore.method.argument.invalid");
        }

        int index = find(arg);
        if (index != NOT_IN_STRUCTURE){
            for (int i = index+1;i<currentCount;i++){
                store[i-1] = store[i];
            }
            store[currentCount-1] = null;
            currentCount--;
            return true;
        }
        return false;

    }

    @Override
    public Object remove(int index) {

        Object arg = store[index];
        remove(arg);
        return arg;
    }

    @Override
    public boolean insert(Object arg, int index) {
        if(arg == null || index<0 || index>=currentCount){
            throw new IllegalArgumentException("arraystore.method.argument.invalid");
        }


        if (!isFull()){
            currentCount++;
            for (int i = currentCount-1;i>index;i--){
                store[i] = store[i-1];
            }
            store[index] = arg;
            return true;
        }



        return false;
    }
}

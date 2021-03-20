/*
 * Created on Aug 11, 2005
 * Accenture Manila Delivery Center
 * Technology Managed Services
 * Makati Stock Exchange Bldg
 * Makati City, Philippines
 */
package d1.datastore;

import d1.cardgame.Card;

public abstract class AbstractArrayStore {
    
    //HINT: The following are class constants.  
    
    //You are not allowed to declare any additional class members. 
    
    //This is a constant that represents the code value returned when an object cannot be found in the array
    public static final int NOT_IN_STRUCTURE=-1;
    //This is a constant that represents the default size of the array
    protected static final int DEFAULT_SIZE = 5;

    
    //HINT: The following are instance variables and are accessible directly by all the methods in this class
    //This is the actual structure that the class uses to store objects
    protected Object store[];
    //Counts the number of objects currently inside the array
    protected int currentCount;
    
    
    //The implementation of the following methods are delegated to subclasses.  By default they will 
    //throw an exception to signal that they are not supported.
    
    public boolean add (Object arg) {
        throw new UnsupportedOperationException("arraystack.method.unsupported");
    }
    public Card remove(Object arg) {
        throw new UnsupportedOperationException("arraystack.method.unsupported");
    }

    public boolean insert(Object arg, int index) {
        throw new UnsupportedOperationException("arraystack.method.unsupported");
    }
    
    public Object remove (int index) {
        throw new UnsupportedOperationException("arrayqueue.method.unsupported");
    }


   
    public AbstractArrayStore(){
        
        //TODO Activity 2.0
        //Initialize the instance variable 'store' that it can hold a number of objects specified by DEFAULT_SIZE
        this.store = new Object[DEFAULT_SIZE];
        
        
    }
    
    public AbstractArrayStore(int size){
        
        //TODO Activity 2.1 
        //Initialize the instance variable 'store' so that it can hold a number of objects specified by 'size'.
        //If the variable 'size' is in anyway illegal for an array, then use DEFAULT_SIZE instead
        if (size<0){
            this.store = new Object[DEFAULT_SIZE];
        }
        else {
            this.store = new Object[size];
        }
        
    }
    
    public boolean isEmpty() {
        
        if(getCount() == 0){
            return true;
        }
        
        return false;    
    }
    
    public int getSize(){
        
        return store.length;
    }
    
    public int getCount(){
        
        return currentCount;
    }
    
    
    public Object[] toArray() {
                
        Object[] temp = new Object[currentCount];
        System.arraycopy(store, 0, temp, 0, currentCount);
        
        return temp;
    }
    
    public void clear() {
        
        currentCount = 0;
        store = new Object[store.length];
    }
    
    public boolean isFull() {

        if (currentCount == store.length) {
            return true;
        } else {
            return false;
        }
    }
    
    
    
    public int find(Object arg) {
        
        //TODO Activity 2.3
        //Search through the current contents of the array 'store' and determine if there is any object
        //in the array that is equal to 'arg' according to equals() method. Return the index where that 
        //object is located or NOT_IN_STRUCTURE, if the object is not within
        //the array.
     
        //HINT: All objects have a method named equals() that returns a boolean. 
        //Ex: This tests if obj1 is "equal to" obj2
        // if(obj1.equals(obj2)){
        //    ...
        // }

        for (int i=0;i<store.length;i++ ){
            if (store[i]!= null && store[i].equals(arg)){
                return i;
            }
        }
         return NOT_IN_STRUCTURE;

    }
    
    
    public boolean contains(Object arg) {

            if(find(arg) != NOT_IN_STRUCTURE){
                return true;
            }
           return false;
    }
    
    public Object check(int index){
        
        //TODO Activity 2.2 
        //Return the object inside 'store' at the array location specified by 'index'
        if (index>=0 && index<store.length) {
            return store[index];
        }
        return null;
    }

   
    
}

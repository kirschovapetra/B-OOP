package runnerspackage;

import java.util.List;
import java.util.Random;

public class Runner {
    private int distance;
    private int velocity;
    private String name;

    public Runner(){}

    public Runner(int distance, int velocity, String name) {
        this.distance = distance;
        this.velocity = velocity;
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getVelocity() {
        return velocity;
    }
    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void move(){
        this.distance+=velocity;
    }
    public boolean isObstacle(){
        return this.distance % 50 == 0 && this.distance!=400 && this.distance!=0;
    }

    public void printRunner(){
        System.out.println("Runner: "+this.name+" Velocity: "+this.velocity+" Distance:"+this.distance);
    }

    public void updateVelocity(){
        Random rand = new Random();
        if(this.distance==0){
            this.velocity = rand.nextInt()%101+350;
        }
        else{
            this.velocity+=rand.nextInt()%26-5;
        }
    }

}

public class Runner {
    private int velocity;
    private int distance;
    private String name;

    public Runner(String n){
        this.velocity = 0;
        this.distance = 0;
        this.name = n;
    }
    public void set_velocity(int v){this.velocity = v;}
    public void set_distance(int d){this.distance = d;}
    public void set_name(String n){this.name = n;}

    public int get_velocity(){return this.velocity;}
    public int get_distance(){return this.distance;}
    public String get_name(){return this.name;}

    public boolean isFinished(){
        return (distance>=400);
    }



}

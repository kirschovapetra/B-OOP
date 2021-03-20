public class Processor{
    public int prikon;
    private int cores;
    public Processor(int prikon_, int cores_){
        this.prikon = prikon_;
        this.cores = cores_;
    }
    public int get_prikon(){
        return this.prikon;
    }
}
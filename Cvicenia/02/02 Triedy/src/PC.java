import java.util.List;

public class PC {
    private Source source;
    private Motherboard motherboard;
    private Processor processor;
    private HDD hdd;
    private RAM ram;

    public PC(){}
    public PC(Source s, Motherboard m, Processor p, HDD h, RAM r){
        this.source = s;
        this.motherboard = m;
        this.processor = p;
        this.hdd = h;
        this.ram = r;

    }

    public void set_Source(Source s){
        this.source = s;
    }
    public void set_Motherboard(Motherboard m){
        this.motherboard = m;
    }
    public void set_Processor(Processor p){
        this.processor = p;
    }
    public void set_HDD(HDD h){
        this.hdd = h;
    }
    public void set_RAM(RAM r){
        this.ram = r;
    }

    public Source get_Source(){
        return this.source;
    }
    public Motherboard get_Motherboard(){
        return this.motherboard;
    }
    public Processor get_Processor(){
        return this.processor;
    }
    public HDD get_HDD(){
        return this.hdd;
    }
    public RAM get_RAM(){
        return this.ram;
    }

    public void turnOn(){
        boolean end = false;

        //existuju komponenty?
        if (this.source == null){
            System.out.println("Chyba zdroj");
            end = true;
        }
        if (this.motherboard == null){
            System.out.println("Chyba motherboard");
            end = true;
        }
        if (this.processor == null){
            System.out.println("Chyba procesor");
            end = true;
        }
        if (this.hdd == null){
            System.out.println("Chyba HDD");
            end = true;
        }
        if (this.ram == null){
            System.out.println("Chyba RAM");
            end = true;
        }

        if (end){
           return;
        }

        int Vykon = this.source.get_vykon();
        int m_prikon = this.motherboard.get_prikon();
        int p_prikon = this.processor.get_prikon();
        int h_prikon = this.hdd.get_prikon();
        int r_prikon = this.ram.get_prikon();

        //vykon>prikon?
        if (Vykon < m_prikon){
            System.out.println("chyba - vysoky prikon Motherboard. Treba +"+(m_prikon-Vykon)+"wattov.");
            end = true;
        }
        if (Vykon < p_prikon){
            System.out.println("chyba - vysoky prikon procesora. Treba +"+(p_prikon-Vykon)+"wattov.");
            end = true;
        }
        if (Vykon < h_prikon){
            System.out.println("chyba - vysoky prikon HDD. Treba +"+(h_prikon-Vykon)+"wattov.");
            end = true;
        }
        if (Vykon < r_prikon){
            System.out.println("chyba - vysoky prikon RAM. Treba +"+(r_prikon-Vykon)+"wattov.");
            end = true;
        }

        if (end){
            return;
        }

        //print
        System.out.println(source.get_vykon());
        System.out.println(motherboard.get_prikon());
        System.out.println(processor.get_prikon());
        System.out.println(hdd.get_prikon());
        System.out.println(ram.get_prikon());
    }
}

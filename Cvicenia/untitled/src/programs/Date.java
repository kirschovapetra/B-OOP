package programs;

public class Date {
    protected int day;
    protected int month;
    protected int year;

    public Date(){}
    public Date(int d, int m, int y){
        if (y<0)
            throw new IllegalArgumentException("Incorrect year");
        if (m<1 || m>12)
            throw new IllegalArgumentException("Incorrect month");
        if (m<1)
            throw new IllegalArgumentException("Incorrect day");

        switch (m){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (d>31)
                    throw new IllegalArgumentException("Incorrect day");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (d>30)
                    throw new IllegalArgumentException("Incorrect day");
                break;
            case 2:
                if (d>28)
                    throw new IllegalArgumentException("Incorrect day");
                break;


        }
        this.day = d;
        this.month = m;
        this.year = y;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void printDate(){
        System.out.println(this.day + "."+this.month+"."+this.year);
    }


}


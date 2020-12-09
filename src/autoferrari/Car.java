package autoferrari;

public class Car {
    String constructor;
    String model;
    String releaseDate;
    int availability;
    String color;
    int cubism;
    String fuel;
    double price;
    
    Car() {
        
    }
    
    Car(String con, String mo, String re, int av, String col, int cu, String fu, double pr) {
        constructor = con;
        model = mo;
        releaseDate = re;
        availability = av;
        color = col;
        cubism = cu;
        fuel = fu;
        price = pr;
    }
    
    Car(String con, String mo, String col, int av) {
        this(con,mo,null,av,col,0,null,0);
    }
}

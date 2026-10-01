import java.time.LocalTime;
import java.time.LocalDate;


/*
 * WARNING: This is given to you, DO NOT CHANGE or you might get a 0!!!!
 */

public class MailPackage {
    public final LocalDate date;
    public final LocalTime time;
    public final String building;
    public final String apartment;
    public final double width;
    public final double height;
    public final double depth;
    public final double weight;

    public MailPackage(LocalDate date, LocalTime time, String building, String apartment, double width, double height,
                       double depth, double weight){
        this.date = date;
        this.time = time;
        this.building = building;
        this.apartment = apartment;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.weight = weight;
    }

    public String getResidentKey(){
        return this.building + "-" + this.apartment;
    }

}

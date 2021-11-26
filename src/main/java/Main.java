import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vehicles.Vehicle;
import vehicles.repos.NoMatchException;
import vehicles.repos.VehicleRepo;
import java.util.Scanner;

public class Main {
    static VehicleRepo vehicleRepo = new VehicleRepo();
    static Boolean exit = Boolean.FALSE;
    private static final Logger logger = LogManager.getLogger();

    private static void start() throws NoMatchException  {
        logger.info("Wybierz pojazd : CAR, SHIP, PLANE, BICYCLE, ALL, EXIT");
        Scanner scanner = new Scanner(System.in);
        String chosen = scanner.next();
        if(chosen.equalsIgnoreCase("exit")) exit = Boolean.TRUE;
        else {
            chosen=chosen+"s";
            Vehicle vehicle = vehicleRepo.getFastest(chosen.toLowerCase());
            logger.info("Pojazd " + vehicle.getMarka() + " " + vehicle.getModel() + " jest najszybszy. " +"Prędkość maksymalna wynosi : " + vehicle.getVmax()+" km/h");
        }
    }

    public static void main(String[] args) {
        while(!exit){
            try {
                start();
            } catch (NoMatchException e) {
                logger.warn("Podaj prawidłową opcję.");
            }
    }
}
}
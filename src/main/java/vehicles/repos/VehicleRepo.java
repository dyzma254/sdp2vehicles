package vehicles.repos;
import vehicles.*;
import java.util.*;

public class VehicleRepo {

    private HashMap<String, List<? extends Vehicle>>vehicles = new HashMap<>();


    public VehicleRepo() {
        List<Car> cars = new ArrayList<>(Arrays.asList(
        new Car("Fiat", "Ducato", 250F),
        new Car("Citroen", "Berlingo", 120F)));
        this.vehicles.put("cars", cars);

        List<Bicycle> bicycles = new ArrayList<>(Arrays.asList(
        new Bicycle("Kross", "Vento 5.0", 60F),
        new Bicycle("Speedster", "20M", 59F)));

        List<Plane> planes = new ArrayList<>(Arrays.asList(
        new Plane("Tupolev", "Tu-154", 850F),
        new Plane("Boeing", "737", 876F)));

        List<Ship> ships = new ArrayList<>(Arrays.asList(
        new Ship("RMS", "Titanic", 44.45F),
        new Ship("Seadoo", "Challenger", 80F)));

        this.vehicles.put("bicycles", bicycles);

        this.vehicles.put("ships", ships);
        this.vehicles.put("planes", planes);
    }

    public Vehicle getFastest(String type) throws NoMatchException  {
        if(type.equals("alls")) return getFastestFromAll();
        Set<String> keys = this.vehicles.keySet();
        boolean answer = keys.stream().noneMatch(s -> s.equalsIgnoreCase(type));
        //System.out.println(answer);
        if(answer) throw new NoMatchException() ;
        Optional<? extends Vehicle> optional = this.vehicles.get(type).stream().max(Comparator.comparing(Vehicle::getVmax));

        if(optional.isEmpty()) ;

        return optional.get();
    }

    private Vehicle getFastestFromAll()  {
        Collection<List<? extends Vehicle>> values = this.vehicles.values();
        List<Vehicle> vehicles = new ArrayList<>();
        values.forEach(list -> list.forEach(v -> vehicles.add(v)));
        Optional<Vehicle> optionalVehicle = vehicles.stream().max(Comparator.comparing(Vehicle::getVmax));
        if(optionalVehicle.isEmpty()) ;
        return optionalVehicle.get();
    }
}

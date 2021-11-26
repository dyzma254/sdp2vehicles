package vehicles;

public abstract class Vehicle implements Comparable<Vehicle>{
    private final String marka;
    private final String model;
    private final Float vmax;

     Vehicle(final String manufacture, final String model, final Float maxSpeed){
        this.marka = manufacture;
        this.model = model;
        this.vmax = maxSpeed;
    }

    public Float getVmax() {
        return vmax;
    }
    public String getMarka() {
        return marka;
    }
    public String getModel() {
        return model;
    }
        @Override
    public int compareTo(Vehicle other){
         return (int) (this.getVmax() - other.getVmax());
    }
}

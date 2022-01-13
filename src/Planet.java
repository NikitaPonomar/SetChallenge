import java.util.Set;

public final class Planet extends HeavenlyBody{

    public Planet(String name, double orbitalPeriod) {
        super(name, BodyTypes.PLANET, orbitalPeriod);
    }


    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if (moon.getBodyType()==BodyTypes.MOON) {
            return super.addSatellite(moon);
        }
        System.out.println("you can not add satellite " + moon.getName() +" to planet "+ this.getName() + ", cause it is not the moon");
        return false;
    }
}

import java.util.Set;

public final class Planet extends HeavenlyBody{

    public Planet(String name, double orbitalPeriod) {
        super(name, BodyTypes.PLANET, orbitalPeriod);
    }


    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if (moon.getKey().getBodyType()==BodyTypes.MOON) {
            return super.addSatellite(moon);
        }
          return false;
    }
}

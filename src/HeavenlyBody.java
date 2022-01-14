import javax.management.ObjectInstance;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public enum BodyTypes {
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }

    public HeavenlyBody(String name, BodyTypes bodyType, double orbitalPeriod) {
        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public Key getKey() {
        return key;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellite(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }


    @Override
    public final boolean  equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if (obj instanceof HeavenlyBody) {
            HeavenlyBody theObj = (HeavenlyBody) obj;
            if (this.key.getName().equals(theObj.key.getName())) {
                return this.key.getBodyType().equals(theObj.key.getBodyType());
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
 //       System.out.println("hashcode called");
        return (this.key.getName().hashCode() + this.key.getBodyType().hashCode());
    }

    @Override
    public final String toString() {
        if (this.getSatellites()==null || (this.getSatellites().size()==0)) {
            return (key.getName()+ ", " + this.getClass() +", "  + this.getOrbitalPeriod());
        }
        return (key.getName()+ ", " + this.getClass() +", " + this.getOrbitalPeriod() + " with satellites: " + this.getSatellites().toString());
    }

    public final class Key {
        private final String name;
        private final BodyTypes bodyType;

        public Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public String toString() {
            return (this.getName()+": "+this.getBodyType());
        }
    }
}

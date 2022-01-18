
import java.util.HashSet;
import java.util.Set;


public abstract class HeavenlyBody {
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
        this.key = makeKey(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public Key getKey() {
        return key;
    }

    public static Key makeKey (String name,BodyTypes bodyType ){
        return new Key(name, bodyType);
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
                return this.key.equals(theObj.getKey());
        }
        return false;
    }

    @Override
    public final int hashCode() {
 //       System.out.println("hashcode called");
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        if (this.getSatellites()==null || (this.getSatellites().size()==0)) {
            return (key.getName()+ ": " + this.getClass() +", "  + this.getOrbitalPeriod());
        }
        return (key.getName()+ ": " + this.getClass() +", " + this.getOrbitalPeriod() + " with satellites: " + this.getSatellites().toString());
    }

    public static final class Key {
        private final String name;
        private final BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType) {
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;

            if (!getName().equals(key.getName())) return false;
            return getBodyType() == key.getBodyType();
        }

        @Override
        public int hashCode() {
            int result = getName().hashCode();
            result =  result + getBodyType().hashCode();
            return result;
        }
    }
}

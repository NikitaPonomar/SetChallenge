public  final class Moon extends HeavenlyBody {
    public Moon(String name,  double orbitalPeriod) {
        super(name, BodyTypes.MOON, orbitalPeriod);
    }

    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if (moon.getKey().getBodyType()==BodyTypes.MOON) {
            return super.addSatellite(moon);
        }
         return false;
    }
}

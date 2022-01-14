public final class Star extends HeavenlyBody {
    public Star(String name, double orbitalPeriod) {
        super(name, BodyTypes.STAR, orbitalPeriod);
    }

    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if (moon.getKey().getBodyType()==BodyTypes.MOON) {
            System.out.println("you can not add MOON to STAR");
            return false;
        }
        return super.getSatellites().add(moon);
    }
}

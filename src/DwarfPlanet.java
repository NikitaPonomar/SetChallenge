public final class DwarfPlanet extends HeavenlyBody{

    public DwarfPlanet(String name, double orbitalPeriod) {
        super(name, BodyTypes.DWARF_PLANET, orbitalPeriod);
    }


    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if (moon.getKey().getBodyType()==BodyTypes.MOON) {
            return super.addSatellite(moon);
        }
          return false;
    }
}

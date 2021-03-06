import java.awt.event.HierarchyEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<HeavenlyBody.Key, HeavenlyBody>  solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        HeavenlyBody tempPlanet = new Planet("Mercury",  88);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        planets.add(tempPlanet);

        tempPlanet = new Planet ("Venus", 225);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        planets.add(tempPlanet);

        tempPlanet = new Planet ("Earth", 365);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        planets.add(tempPlanet);

        Moon tempMoon = new Moon("Moon",  27);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        tempPlanet.addSatellite(tempMoon);

        // creating one more Earth planet, to check equal method
        // Checking equals function
        Planet earth = new Planet ("Earth", 365);
        earth.addSatellite(tempMoon);

        System.out.println("is Earth1 equal to Earth2?");
        System.out.println(earth.equals(tempPlanet));
        System.out.println("is Earth2 equal to Earth1?");
        System.out.println(tempPlanet.equals(earth));

        tempPlanet = new Planet("Mars", 687);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        planets.add(tempPlanet);

        tempMoon = new Moon("Deimos",  1.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        tempPlanet.addSatellite(tempMoon); // temp is still Mars

        tempMoon = new Moon("Phobos",  0.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        tempPlanet.addSatellite(tempMoon); // temp is still Mars

        HeavenlyBody mars = tempPlanet;
        tempPlanet = new Planet ("Jupiter", 4332);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        planets.add(tempPlanet);

        tempMoon = new Moon("Io",  1.8);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        tempPlanet.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Europa",  3.5);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        tempPlanet.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Ganymede",  7.1);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        tempPlanet.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Callisto",  16.7);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        tempPlanet.addSatellite(tempMoon); // temp is still Jupiter

        tempPlanet = new Planet("Saturn", 10759);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        planets.add(tempPlanet);

        tempPlanet = new Planet("Uranus", 30660);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        planets.add(tempPlanet);

        tempPlanet = new Planet("Neptune", 165);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        planets.add(tempPlanet);

        tempPlanet = new Planet("Pluto", 248);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        planets.add(tempPlanet);

//         Attempting to add a duplicate to a Set must result in no change to the set (so
//                the original value is not replaced by the new one).
        planets.add(new Planet ("Pluto", 100));

        // Attempting to add a duplicate to a Map results in the original being replaced
        // by the new object.
        solarSystem.put(tempPlanet.getKey(), new Planet ("Pluto", 1));

        Star tempStar = new Star("Sun", 730000);
        solarSystem.put(tempStar.getKey(), tempStar);

        // trying to add Sun as satellite of the planet
        tempPlanet.addSatellite(tempStar);

        // Adding one more moon Pluto with the same name as planet Pluto
        Moon pluto = new Moon("Pluto",  842);
        System.out.println("Pluto2");
        System.out.println(tempPlanet.getKey());
        tempPlanet.addSatellite(pluto);
        solarSystem.put(pluto.getKey(), pluto);

        System.out.println("Planets");
        for(HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getKey() + ": " + planet.getOrbitalPeriod() );
        }
        HeavenlyBody body = solarSystem.get(mars.getKey());
        System.out.println("Moons of " + solarSystem.get(mars.getKey()).getKey().getName());
        for(HeavenlyBody satellite: body.getSatellites()) {
            System.out.println("\t" + satellite);
        }

        Set<HeavenlyBody> moons = new HashSet<>();
        for(HeavenlyBody planet : planets) {
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All Moons");
        for(HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getKey() + ": "+ moon.getOrbitalPeriod());
        }



        System.out.println("The whole Solar system");
        for (Map.Entry <HeavenlyBody.Key, HeavenlyBody> entry: solarSystem.entrySet()){
            System.out.println("\t"+entry.getValue());
        }



    }
}

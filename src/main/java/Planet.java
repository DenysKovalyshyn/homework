public enum Planet {
    JUPITER(5,500, 10,"Mars", "Saturn");

    int numberFromSun;
    int lengthFromPrev;
    int lengthFromSun;
    int radius;
    String previousPlanet;
    String nextPlanet;

    private Planet (int numberFromSun, int lengthFromPrev, int radius, String previousPlanet, String nextPlanet){
        this.numberFromSun = numberFromSun;
        this.lengthFromPrev = lengthFromPrev;
        this.lengthFromSun = numberFromSun*lengthFromPrev;
        this.radius = radius;
        this.previousPlanet = previousPlanet;
        this.nextPlanet = nextPlanet;

    }

}

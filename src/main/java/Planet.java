public enum Planet {
    JUPITER(5,500, 0, 10, "Mars", "Saturn");

    int numberFromSun;
    int lengthFromPrev;
    int lengthFromSun;
    int radius;
    String previousPlanet;
    String nextPlanet;

    private Planet (int numberFromSun, int lengthFromPrev, int lengthFromSun, int radius, String previousPlanet, String nextPlanet){
        this.numberFromSun = numberFromSun;
        this.lengthFromPrev = lengthFromPrev;
        this.lengthFromSun = lengthFromSun;
        this.radius = radius;
        this.previousPlanet = previousPlanet;
        this.nextPlanet = nextPlanet;

    }

    public int getLengthFromSun() {
        lengthFromSun = lengthFromPrev * numberFromSun;
        return lengthFromSun;
    }
}

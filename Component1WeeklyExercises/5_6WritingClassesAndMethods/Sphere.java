public class Sphere {

    double diameter;

    Sphere(double d) {
        diameter = d;
    }

    double getDiameter() {
        return diameter;
    }

    void setDiameter(double d) {
        diameter = d;
    }

    double getVolume() {
        double radius = diameter / 2.0;
        double volume = (4.0 / 3.0) * Math.PI * radius * radius * radius;
        return volume;
    }

    double getSurface() {
        double radius = diameter / 2.0;
        double surface = 4.0 * Math.PI * radius * radius;
        return surface;
    }

    public String toString() {
        return "Diameter: " + diameter +
                " Surface: " + getSurface() +
                " Volume: " + getVolume();
    }
}
package ua.edu.ucu.apps.flower;

public enum FlowerColor {
    RED("#FF0000"), BLUE("0000FF"), GREEN("#00FF00"),
     YELLOW("#00FFFF"), WHITE("#FFFFFF");

    private final String colorCode;

    FlowerColor(String colorCode) {
        this.colorCode = colorCode;
    }

    @Override
    public String toString() {
        return colorCode;
    }

    public static FlowerColor getColor(String color) {
        for (FlowerColor flowerColor : FlowerColor.values()) {
            if (flowerColor.toString().equals(color)) {
                return flowerColor;
            }
        }
        return null;
    }
    
}

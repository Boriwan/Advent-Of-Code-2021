package day_2;

public record Coordinates(String direction, int amount) {

    public String getDirection() {
        return direction;
    }

    public int getAmount() {
        return amount;
    }
}

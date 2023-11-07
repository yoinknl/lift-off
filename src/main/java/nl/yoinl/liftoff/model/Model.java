package nl.yoinl.liftoff.model;

import java.util.Arrays;
import java.util.List;

public final class Model {

    public static final int DEFAULT_NUMBER_OF_FLOORS = 5;
    public static final Floor GROUND_FLOOR = Floor.of(0);

    public enum Direction {
        UP,
        DOWN
    }

    public record Floor(int floor) {
        public static Floor of(int floor) {
            return new Floor(floor);
        }

        @Override
        public String toString() {
            return "Floor[" + floor + "]";
        }
    }

    public record Timestamp(int timestamp) {
        @Override
        public String toString() {
            return "Timestamp[" + timestamp + "]";
        }
    }

    public record Call(Direction direction, Floor from, Floor to, Timestamp time) {
        public static Call of(Direction direction, Floor from, Floor to) {
            return new Call(direction, from, to, null);
        }

        public static Call of(Direction direction, Floor from, Floor to, Timestamp time) {
            return new Call(direction, from, to, time);
        }
    }

    public record Input(List<Call> calls, Floor start, int numberOfFloors) {
        public static Input of(Call... calls) {
            return new Input(Arrays.asList(calls), GROUND_FLOOR, DEFAULT_NUMBER_OF_FLOORS);
        }
    }
}

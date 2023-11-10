package nl.yoink.liftoff.model;

import java.util.Arrays;
import java.util.List;

public final class Model {

    public static final int DEFAULT_NUMBER_OF_FLOORS = 5;
    public static final Floor GROUND_FLOOR = Floor.of(0);

    public enum Direction {
        UP,
        DOWN;

        public Direction reverse() {
            return this == UP ? DOWN : UP;
        }
    }

    public record Floor(int floor) implements Comparable<Floor> {
        public static Floor of(int floor) {
            return new Floor(floor);
        }

        public Floor above() {
            return new Floor(floor + 1);
        }

        public Floor below() {
            return new Floor(floor - 1);
        }

        @Override
        public String toString() {
            return "Floor[" + floor + "]";
        }

        @Override
        public int compareTo(Floor o) {
            return Integer.compare(floor(), o.floor());
        }
    }

    public record Time(int boops) implements Comparable<Time> {
        public static Time of(int boops) {
            return new Time(boops);
        }

        public Time tick() {
            return new Time(boops + 1);
        }

        public boolean isBefore(Time other) {
            return boops < other.boops();
        }

        public boolean isAfter(Time other) {
            return boops > other.boops();
        }

        @Override
        public String toString() {
            return "Boop[" + boops + "]";
        }

        @Override
        public int compareTo(Time o) {
            return Integer.compare(boops(), o.boops());
        }
    }

    public record Call(Direction direction, Floor from, Floor to, Time time) {
        public static Call of(Direction direction, Floor from, Floor to) {
            return new Call(direction, from, to, null);
        }

        public static Call of(Direction direction, Floor from, Floor to, Time time) {
            return new Call(direction, from, to, time);
        }
    }

    public record Input(List<Call> calls, Floor start, int numberOfFloors) {
        public static Input of(Call... calls) {
            return new Input(Arrays.asList(calls), GROUND_FLOOR, DEFAULT_NUMBER_OF_FLOORS);
        }
    }

    public record FloorTime(Floor floor, Time time) {
        public static FloorTime of(Floor floor, Time time) {
            return new FloorTime(floor, time);
        }
    }
}

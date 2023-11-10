package nl.yoink.liftoff.puzzle;

import static nl.yoink.liftoff.assertions.Assert.assertEquals;

import nl.yoink.liftoff.elevator.Operator;
import nl.yoink.liftoff.model.Model.*;
import nl.yoink.liftoff.solutions.SecretSolutions;

import java.util.List;

/*
 * In Level 3, we'll introduce a time component, the Boop. Time moves from Boop 0 forward.
 * Moving from one floor to another takes 1 Boop.
 * Every call happens at a specific time, defined in number of Boops after 0.
 * The elevator does not move when it has no passengers to transport; otherwise it behaves as in Level 2.
 */
public class Level3 {

    private static final Operator<FloorTime> operator = new Operator<>() {
        @Override
        public List<FloorTime> run(Input input) {
            // TODO: Remove call to hidden solution and implement this method
            return SecretSolutions.level3(input);
        }
    };

    public static void main(String... args) {
        var input = Input.of(
            Call.of(Direction.UP, Floor.of(0), Floor.of(5), Time.of(1)),
            Call.of(Direction.UP, Floor.of(1), Floor.of(5), Time.of(5)),
            Call.of(Direction.DOWN, Floor.of(3), Floor.of(2), Time.of(3)),
            Call.of(Direction.UP, Floor.of(2), Floor.of(4), Time.of(2))
        );

        var output = operator.run(input);

        assertEquals(
            List.of(
                FloorTime.of(Floor.of(0), Time.of(2)),
                FloorTime.of(Floor.of(2), Time.of(4)),
                FloorTime.of(Floor.of(4), Time.of(6)),
                FloorTime.of(Floor.of(5), Time.of(7)),
                FloorTime.of(Floor.of(3), Time.of(9)),
                FloorTime.of(Floor.of(2), Time.of(10)),
                FloorTime.of(Floor.of(1), Time.of(11)),
                FloorTime.of(Floor.of(5), Time.of(15))),
            output
        );

        System.out.println("Success!");
    }
}

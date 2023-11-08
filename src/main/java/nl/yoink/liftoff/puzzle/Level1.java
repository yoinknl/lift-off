package nl.yoink.liftoff.puzzle;

import static nl.yoink.liftoff.assertions.Assert.assertEquals;

import nl.yoink.liftoff.elevator.Operator;
import nl.yoink.liftoff.model.Model.*;
import nl.yoink.liftoff.solutions.SecretSolutions;

import java.util.List;

/*
 * In Level 1, the elevator is very unintelligent. It follows these rules:
 *
 * - The elevator starts on the ground floor (0).
 * - It proceeds directly to the floor of the first call, ignoring intermediate stops.
 * - After serving the first request by going to the passenger's desired floor, it immediately answers the next call.
 * - It continues this process, serving one call at a time, taking passengers directly to their requested floor without intermediate stops.
 */
public class Level1 {

    private static final Operator operator = new Operator() {
        @Override
        public List<Floor> run(Input input) {
            // TODO: Remove call to hidden solution and implement this method
            return SecretSolutions.level1(input);
        }
    };

    public static void main(String... args) {
        var input = Input.of(
            Call.of(Direction.UP, Floor.of(0), Floor.of(5)),
            Call.of(Direction.UP, Floor.of(1), Floor.of(5)),
            Call.of(Direction.DOWN, Floor.of(3), Floor.of(2)),
            Call.of(Direction.UP, Floor.of(2), Floor.of(4))
        );

        var output = operator.run(input);

        assertEquals(
            List.of(Floor.of(0), Floor.of(5), Floor.of(1), Floor.of(5), Floor.of(3), Floor.of(2), Floor.of(4)),
            output
        );

        System.out.println("Success!");
    }
}

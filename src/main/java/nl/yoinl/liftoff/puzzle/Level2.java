package nl.yoinl.liftoff.puzzle;

import static nl.yoinl.liftoff.assertions.Assert.assertEquals;

import nl.yoinl.liftoff.elevator.Operator;
import nl.yoinl.liftoff.model.Model.*;
import nl.yoinl.liftoff.solutions.SecretSolutions;

import java.util.List;

/*
 * In Level 2, the elevator becomes a little smarter. It follows the same rules as in Level 1,
 * but now it also makes intermediate stops, both to pick up passengers and to drop them off.
 * However, it will never change direction if it still has stops scheduled in the direction it's going.
 *
 * Hints:
 * - use `new ArrayList<>(input.calls())` to make a copy of the list of calls.
 * - a TreeSet can store items in their natural order, intead of the order in which they were inserted. You can even give it a Comparator.
 */
public class Level2 {

    private static final Operator operator = new Operator() {
        @Override
        public List<Floor> run(Input input) {
            // TODO: Remove call to hidden solution and implement this method
            return SecretSolutions.level2(input);
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
            List.of(Floor.of(0), Floor.of(1), Floor.of(2), Floor.of(4), Floor.of(5), Floor.of(3), Floor.of(2)),
            output
        );

        System.out.println("Success!");
    }
}

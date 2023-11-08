package nl.yoink.liftoff.assertions;

import java.util.Objects;

public final class Assert {

    public static <T> void assertEquals(T expected, T actual) {
        if (!Objects.equals(expected, actual)) {
            var message =
                """
                Unexpected output!
                Expected: %s
                Actual  : %s""".stripIndent();
            throw new AssertionError(String.format(message, expected, actual));
        }
    }
}

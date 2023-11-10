package nl.yoink.liftoff.elevator;

import nl.yoink.liftoff.model.Model.Input;

import java.util.List;

public interface Operator<T> {
    List<T> run(Input input);
}

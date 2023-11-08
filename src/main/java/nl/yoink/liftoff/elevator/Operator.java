package nl.yoink.liftoff.elevator;

import nl.yoink.liftoff.model.Model.Floor;
import nl.yoink.liftoff.model.Model.Input;

import java.util.List;

public interface Operator {
    List<Floor> run(Input input);
}

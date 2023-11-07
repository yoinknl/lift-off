package nl.yoinl.liftoff.elevator;

import nl.yoinl.liftoff.model.Model.Floor;
import nl.yoinl.liftoff.model.Model.Input;

import java.util.List;

public interface Operator {
    List<Floor> run(Input input);
}

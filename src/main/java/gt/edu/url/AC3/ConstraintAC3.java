package gt.edu.url.AC3;

import java.util.List;

public interface ConstraintAC3 {
    List<Variable> getScope();

    boolean isSatisfiedWith(Assignment assignment);
}

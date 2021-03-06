package dashbase.meta;

import bnfgenast.bnf.BnfCom;
import lombok.Getter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class Dependency {

    @Getter
    private Map<String, Dependency> dependencies;

    @Getter
    private final BindMethod bindMethod;

    public Dependency(BindMethod bindMethod) {
        this.bindMethod = bindMethod;

        if (bindMethod.getMode() == GrammarMode.PRIMARY) {
            this.dependencies = Collections.emptyMap();
        } else {
            this.dependencies = new HashMap<>();
        }
    }

    public abstract BnfCom create();
}

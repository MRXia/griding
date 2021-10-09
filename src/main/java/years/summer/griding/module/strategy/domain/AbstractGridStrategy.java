package years.summer.griding.module.strategy.domain;

import java.math.BigDecimal;
import java.util.stream.IntStream;

import lombok.Setter;
import years.summer.griding.module.plan.domain.PlanConfig;

/**
 * @author xiazijian
 */
public abstract class AbstractGridStrategy implements GridStrategy {

    @Setter
    protected PlanConfig planConfig;

    public AbstractGridStrategy(PlanConfig planConfig) {
        this.planConfig = planConfig;
    }

    @Override
    public PlanConfig getPlanConfig() {
        return planConfig;
    }

    @Override
    public BigDecimal pressureTest() {

        return null;
    }


}

package years.summer.griding.module.strategy.domain.v1;

import java.util.Collection;

import years.summer.griding.module.plan.domain.PlanConfig;
import years.summer.griding.module.plan.domain.PlanItem;
import years.summer.griding.module.strategy.domain.AbstractGridStrategy;

/**
 * 网格 1.0 版本
 * @author xiazijian
 */
public class BaseStrategy extends AbstractGridStrategy {

    public BaseStrategy(PlanConfig planConfig) {
        super(planConfig);
    }

    @Override
    protected Collection<PlanItem> targetGridItems(int depth) {
        return null;
    }
}

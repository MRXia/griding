package years.summer.griding.module.strategy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;
import years.summer.griding.module.plan.domain.PlanConfig;
import years.summer.griding.module.strategy.domain.GridStrategy;
import years.summer.griding.module.strategy.domain.v1.BaseStrategy;
import years.summer.griding.module.strategy.domain.v2.AdvanceStrategy;
import years.summer.griding.module.strategy.domain.v3.FinalStrategy;

/**
 * 策略版本
 * @author xiazijian
 */
@AllArgsConstructor
@Getter
public enum StrategyVersion {

    /**
     * 基础策略
     */
    V1(BaseStrategy.class),

    /**
     * 进阶策略
     */
    V2(AdvanceStrategy.class),

    /**
     * 最终策略
     */
    V3(FinalStrategy.class);

    private final Class<? extends GridStrategy> strategyClass;

    @SneakyThrows
    public GridStrategy newStrategy(PlanConfig config) {
        return strategyClass.getDeclaredConstructor(PlanConfig.class).newInstance(config);
    }
}

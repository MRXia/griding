package years.summer.griding.module.strategy.domain;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.Setter;
import years.summer.griding.module.plan.domain.PlanConfig;
import years.summer.griding.module.plan.domain.PlanItem;

/**
 * 抽象网格策略，实现网格策略的基本功能
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

    @Override
    public List<PlanItem> gridItems() {
        return IntStream.range(0, planConfig.getGridDepth())
                .mapToObj(this::targetGridItems)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    /**
     * 通过网格深度得到网格项列表，在高级策略下，同一深度会区分【大，中，小】网格
     * @param depth 网格深度
     * @return 深度对应的网格项列表
     */
    protected abstract Collection<PlanItem> targetGridItems(int depth);


}

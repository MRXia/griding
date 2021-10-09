package years.summer.griding.module.plan.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import years.summer.griding.common.domain.Percentile;
import years.summer.griding.module.strategy.domain.GridStrategy;
import years.summer.griding.module.strategy.enums.StrategyVersion;

/**
 * 投资计划
 * @author xiazijian
 */
public class PlanConfig {

    /**
     * 产品代码
     */
    @Getter
    private final String code;

    /**
     * 产品名称
     */
    @Getter
    private final String name;

    /**
     * 基准价
     */
    @Getter
    private final BigDecimal basePrice;

    /**
     * 网格大小（百分比）
     */
    @Getter
    private final Percentile gridSize;

    /**
     * 网格深度
     */
    @Getter
    private final Integer gridDepth;


    private List<PlanItem> planItems;

    private final GridStrategy strategy;

    public Percentile getRisePercent() {
        return gridSize;
    }

    public Percentile getfallPercent() {
        return gridSize;
    }


    /*public BigDecimal nextBuyingPrice(PlanItem item) {

    }

    public BigDecimal nextSellingPrice(PlanItem item) {

    }*/

    @Builder
    private PlanConfig(@NonNull String code,
                       @NonNull String name,
                       @NonNull Double basePrice,
                       @NonNull Integer gridSize,
                       @NonNull Integer gridDepth,
                       @NonNull StrategyVersion strategyVersion) {

        this.code = code;
        this.name = name;
        this.basePrice = BigDecimal.valueOf(basePrice);
        this.gridSize = new Percentile(gridSize);
        this.gridDepth = gridDepth;
        this.strategy = strategyVersion.newStrategy(this);
    }

    public List<PlanItem> getPlanItems() {

        if (planItems == null) {
            initItems();
        }

        return planItems;
    }


    /**
     * 初始化计划列表
     */
    public synchronized void initItems() {
        if (planItems != null) {
            return;
        }
        planItems = strategy.gridItems();
    }
}

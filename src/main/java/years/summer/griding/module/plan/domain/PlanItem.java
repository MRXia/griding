package years.summer.griding.module.plan.domain;

import lombok.Data;
import years.summer.griding.common.domain.Percentile;

/**
 * 网格计划条目
 * @author xiazijian
 */
@Data
public class PlanItem {

    private PlanConfig planConfig;

    /**
     * 计划档位
     */
    private Percentile level;

    /**
     * 交易状态
     */
    private TradingStatus status;

    /**
     * 买入操作
     */
    private PlanOperation buying;

    /**
     * 卖出操作
     */
    private PlanOperation selling;

    /**
     * 计划留存数量
     */
    private Integer retained;

    /**
     * 实际留存数量
     */
    private Integer actualRetained;

    /**
     * 交易状态
     */
    public enum TradingStatus {
        /**
         * 未买入
         */
        NOT_TO_BUY,

        /**
         * 已买入
         */
        HAVE_TO_BUY,

        /**
         * 已卖出
         */
        HAVE_TO_SELL
    }

    public PlanItem(PlanConfig planConfig) {
        this.planConfig = planConfig;
        this.status = TradingStatus.NOT_TO_BUY;
    }
}

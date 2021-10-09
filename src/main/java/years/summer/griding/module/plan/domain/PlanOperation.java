package years.summer.griding.module.plan.domain;

import java.math.BigDecimal;

import lombok.Data;

/**
 * 计划操作数值
 * @author xiazijian
 */
@Data
public class PlanOperation {

    /**
     * 计划价格
     */
    private BigDecimal price;

    /**
     * 计划数量
     */
    private Integer count;

    /**
     * 实际价格
     */
    private BigDecimal actualPrice;

    /**
     * 实际数量
     */
    private Integer actualCount;

    /**
     * @return 计划卖出金额
     */
    public BigDecimal getAmount() {
        return price.multiply(BigDecimal.valueOf(count));
    }

    /**
     * @return 实际卖出金额
     */
    public BigDecimal getActualAmount() {
        return actualPrice.multiply(BigDecimal.valueOf(actualCount));
    }
}

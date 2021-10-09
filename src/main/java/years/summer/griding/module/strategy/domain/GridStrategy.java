package years.summer.griding.module.strategy.domain;

import java.math.BigDecimal;

import years.summer.griding.module.plan.domain.PlanConfig;

/**
 * 网格策略
 * @author xiazijian
 */
public interface GridStrategy {

    /**
     * @return 配置该策略的计划
     */
    PlanConfig getPlanConfig();

    /**
     * 进行压力测试
     * @return 压力测试后的最大投入金额
     */
    BigDecimal pressureTest();
}

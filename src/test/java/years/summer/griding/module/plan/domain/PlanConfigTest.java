package years.summer.griding.module.plan.domain;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import years.summer.griding.module.strategy.enums.StrategyVersion;

class PlanConfigTest {

    @Test
    public void testPlanConfig() {
        PlanConfig config = PlanConfig.builder()
                .name("华宝油气")
                .code("00500")
                .basePrice(0.45d)
                .strategyVersion(StrategyVersion.V1)
                .gridSize(5)
                .gridDepth(12)
                .build();
        Assertions.assertEquals(config.getBasePrice(), new BigDecimal("0.45"));
    }

}
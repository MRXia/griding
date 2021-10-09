package years.summer.griding.common.domain;

import java.math.BigDecimal;

public class Percentile extends BigDecimal {

    public static final int PERCENT = 100;

    public Percentile(double val) {
        super(val / PERCENT);
    }

    public Percentile(int val) {
        super(val / PERCENT);
    }

}

package io.accelerate.solutions.CHK.SUM;

import io.accelerate.solutions.CHK.CheckoutSolution;
import io.accelerate.solutions.SUM.SumSolution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutSolutionTest {
    private CheckoutSolution checkoutSolution;

    @BeforeEach
    public void setUp() {
        checkoutSolution = new CheckoutSolution();
    }

    @Test
    public void compute_AAAB_checkout() {
        assertThat( checkoutSolution.checkout("AAAB"), equalTo(160));
    }

    @Test
    public void compute_ABCD_checkout() {
        assertThat( checkoutSolution.checkout("ABCD"), equalTo(115));
    }

    @Test
    public void compute_AAAABB_checkout() {
        assertThat( checkoutSolution.checkout("AAAABB"), equalTo(225));
    }

    @Test
    public void compute_AAAAABBBCCD_checkout() {
        assertThat( checkoutSolution.checkout("AAAAABBBCCD"), equalTo(360));
    }
}


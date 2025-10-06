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
    public void compute_AAAABBBCCD_checkout() {
        assertThat( checkoutSolution.checkout("AAAABBBCCD"), equalTo(310));
    }

    @Test
    public void compute_AAAAA_checkout() {
        assertThat( checkoutSolution.checkout("AAAAA"), equalTo(200));
    }

    @Test
    public void compute_AAAAAAAA_checkout() {
        assertThat( checkoutSolution.checkout("AAAAAAAA"), equalTo(330));
    }

    @Test
    public void compute_AAAAAAAAA_checkout() {
        assertThat( checkoutSolution.checkout("AAAAAAAAA"), equalTo(380));
    }

    @Test
    public void compute_E_checkout() {
        assertThat( checkoutSolution.checkout("E"), equalTo(40));
    }

    @Test
    public void compute_EE_checkout() {
        assertThat( checkoutSolution.checkout("EE"), equalTo(80));
    }

    @Test
    public void compute_EEE_checkout() {
        assertThat( checkoutSolution.checkout("EEE"), equalTo(120));
    }

    @Test
    public void compute_BBEEE_checkout() {
        assertThat( checkoutSolution.checkout("BBEEE"), equalTo(150));
    }

    @Test
    public void compute_BBBEEE_checkout() {
        assertThat( checkoutSolution.checkout("BBBEEE"), equalTo(165));
    }

    @Test
    public void compute_FF_checkout() {
        assertThat( checkoutSolution.checkout("FF"), equalTo(20));
    }

    @Test
    public void compute_FFF_checkout() {
        assertThat( checkoutSolution.checkout("FFF"), equalTo(20));
    }

    @Test
    public void compute_FFFF_checkout() {
        assertThat( checkoutSolution.checkout("FFFF"), equalTo(30));
    }

}

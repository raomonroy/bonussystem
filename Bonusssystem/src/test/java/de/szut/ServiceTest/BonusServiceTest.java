package de.szut.ServiceTest;

import de.szut.Service.BonusService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BonusServiceTest {

    private final BonusService bonusService = new BonusService();

    @Test
    void returnBonusUnchangedWhenWithinLimits() {
        assertThat(bonusService.applyCompanyRestrictions((4000.0))).isEqualTo(4000.0);
    }

    @Test
    void capBonusAtMaximum() {
        assertThat(bonusService.applyCompanyRestrictions((15000.0))).isEqualTo(10000.0);
    }

    @Test
    void raiseBonusToMinimum() {
        assertThat(bonusService.applyCompanyRestrictions((100.0))).isEqualTo(500.0);
    }
}

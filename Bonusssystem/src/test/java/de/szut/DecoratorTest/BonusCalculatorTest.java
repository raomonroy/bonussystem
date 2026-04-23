package de.szut.DecoratorTest;

import de.szut.Model.Employee;
import de.szut.Service.BonusCalculator;
import de.szut.Service.BonusService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BonusCalculatorTest {

    @Mock
    private BonusService bonusService;

    @InjectMocks
    private BonusCalculator bonusCalculator;

    @Test
    void applyCompanyRestrictionsOnCalculatedBonus() {
        Employee employee = new Employee("Darlene", 0, 50, 0, 5, false);
        when(bonusService.applyCompanyRestrictions(anyDouble())).thenReturn(650.0);

        double result = bonusCalculator.calculateTotalBonus(employee);

        assertThat(result).isEqualTo(650.0);
        verify(bonusService).applyCompanyRestrictions(650.0);
    }
}

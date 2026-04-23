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

    @Test
    void passRawBonusToServiceAndReturnCappedValue() {
        Employee highPerformer = new Employee("Torsten", 20, 95, 10, 0, true);
        when(bonusService.applyCompanyRestrictions(anyDouble())).thenReturn(10000.0);

        double result = bonusCalculator.calculateTotalBonus(highPerformer);

        assertThat(result).isEqualTo(10000.0);
        verify(bonusService, times(1)).applyCompanyRestrictions(anyDouble());
    }

    @Test
    void shouldEnsureServiceIsCalledExactlyOnce() {
        Employee employee = new Employee("Tanja", 3, 70, 2, 8, false);
        when(bonusService.applyCompanyRestrictions(anyDouble())).thenReturn(800.0);

        bonusCalculator.calculateTotalBonus(employee);

        verify(bonusService, times(1)).applyCompanyRestrictions(anyDouble());
    }
}

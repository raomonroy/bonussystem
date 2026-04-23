package de.szut.DecoratorTest;

import de.szut.Decorator.PerformanceMultiplierDecorator;
import de.szut.Interface.BonusComponentInterface;
import de.szut.Model.Employee;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PerformanceMultiplierDecoratorTest {

    BonusComponentInterface bonusComponent = mock(BonusComponentInterface.class);

    @Test
    void multiplyBy1_5ForScoreAtLeast90() {
        Employee employee = new Employee("Leonidas", 3, 90, 0, 5, false);
        when(bonusComponent.calculateBonus(employee)).thenReturn(1000.0);

        BonusComponentInterface performanceMultiplierDecorator = new PerformanceMultiplierDecorator(bonusComponent);

        assertThat(performanceMultiplierDecorator.calculateBonus(employee)).isEqualTo(1500.0);
    }

    @Test
    void multiplyBy1_25ForScoreAtLeast75() {
        Employee employee = new Employee("Leonidas", 3, 75, 0, 5, false);
        when(bonusComponent.calculateBonus(employee)).thenReturn(1000.0);

        BonusComponentInterface performanceMultiplierDecorator = new PerformanceMultiplierDecorator(bonusComponent);

        assertThat(performanceMultiplierDecorator.calculateBonus(employee)).isEqualTo(1250.0);
    }

    @Test
    void multiplyBy1_1ForScoreAtLeast60() {
        Employee employee = new Employee("Leonidas", 3, 60, 0, 5, false);
        when(bonusComponent.calculateBonus(employee)).thenReturn(1000.0);

        BonusComponentInterface performanceMultiplierDecorator = new PerformanceMultiplierDecorator(bonusComponent);

        assertThat(performanceMultiplierDecorator.calculateBonus(employee)).isEqualTo(1100.0);
    }

}

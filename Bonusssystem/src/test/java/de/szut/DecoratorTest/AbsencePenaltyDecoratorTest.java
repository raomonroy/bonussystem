package de.szut.DecoratorTest;

import de.szut.Decorator.AbsencePenaltyDecorator;
import de.szut.Decorator.SeniorityBonusDecorator;
import de.szut.Interface.BonusComponentInterface;
import de.szut.Model.Employee;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AbsencePenaltyDecoratorTest {

    BonusComponentInterface bonusComponent = mock(BonusComponentInterface.class);

    @Test
    void deduct600ForMoreThan25AbsenceDays() {
        Employee employee = new Employee("Rebecca", 3, 70, 0, 26, false);
        when(bonusComponent.calculateBonus(employee)).thenReturn(1000.0);

        BonusComponentInterface absencePenaltyDecorator = new AbsencePenaltyDecorator(bonusComponent);

        assertThat(absencePenaltyDecorator.calculateBonus(employee)).isEqualTo(400.0);
    }

    @Test
    void deduct300ForMoreThan15AbsenceDays() {
        Employee employee = new Employee("Rebecca", 3, 70, 0, 16, false);
        when(bonusComponent.calculateBonus(employee)).thenReturn(1000.0);

        BonusComponentInterface absencePenaltyDecorator = new AbsencePenaltyDecorator(bonusComponent);

        assertThat(absencePenaltyDecorator.calculateBonus(employee)).isEqualTo(700.0);
    }

}

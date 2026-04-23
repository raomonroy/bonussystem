package de.szut.DecoratorTest;

import de.szut.Decorator.LowAbsenceBonusDecorator;
import de.szut.Decorator.ProjectCompletionBonusDecorator;
import de.szut.Interface.BonusComponentInterface;
import de.szut.Model.Employee;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LowAbsenceBonusDecoratorTest {

    BonusComponentInterface bonusComponent = mock(BonusComponentInterface.class);

    @Test
    void add300ForAtMost3AbsenceDays() {
        Employee employee = new Employee("Linda", 3, 70, 0, 3, false);
        when(bonusComponent.calculateBonus(employee)).thenReturn(500.0);

        BonusComponentInterface lowAbsenceBonusDecorator = new LowAbsenceBonusDecorator(bonusComponent);

        assertThat(lowAbsenceBonusDecorator.calculateBonus(employee)).isEqualTo(800.0);
    }

    @Test
    void add150ForAtMost7AbsenceDays() {
        Employee employee = new Employee("Lara", 3, 70, 0, 7, false);
        when(bonusComponent.calculateBonus(employee)).thenReturn(500.0);

        BonusComponentInterface lowAbsenceBonusDecorator = new LowAbsenceBonusDecorator(bonusComponent);

        assertThat(lowAbsenceBonusDecorator.calculateBonus(employee)).isEqualTo(650.0);
    }

    @Test
    void addNoBonusAbove7AbsenceDays() {
        Employee employee = new Employee("Lisa", 3, 70, 0, 10, false);
        when(bonusComponent.calculateBonus(employee)).thenReturn(500.0);

        BonusComponentInterface lowAbsenceBonusDecorator = new LowAbsenceBonusDecorator(bonusComponent);

        assertThat(lowAbsenceBonusDecorator.calculateBonus(employee)).isEqualTo(500.0);
    }

}

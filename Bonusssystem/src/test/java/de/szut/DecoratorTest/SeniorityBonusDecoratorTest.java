package de.szut.DecoratorTest;

import de.szut.Decorator.SeniorityBonusDecorator;
import de.szut.Interface.BonusComponentInterface;
import de.szut.Model.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SeniorityBonusDecoratorTest {

    BonusComponentInterface bonusComponent = mock(BonusComponentInterface.class);

    @Test
    void addNoBonusBelow5Years() {
        Employee employee = new Employee("Max", 4, 70, 0, 0, false);
        when(bonusComponent.calculateBonus(employee)).thenReturn(500.0);

        BonusComponentInterface seniorityBonusDecorator = new SeniorityBonusDecorator(bonusComponent);

        assertThat(seniorityBonusDecorator.calculateBonus(employee)).isEqualTo(500.0);
    }

    @Test
    void add150PerEvery5Years() {
        Employee employee = new Employee("Tonny", 10, 70, 0, 0, false);
        when(bonusComponent.calculateBonus(employee)).thenReturn(500.0);

        BonusComponentInterface seniorityBonusDecorator = new SeniorityBonusDecorator(bonusComponent);

        assertThat(seniorityBonusDecorator.calculateBonus(employee)).isEqualTo(800.0);
    }

    @Test
    void handleExactInterval() {
        Employee employee = new Employee("Carlo", 5, 70, 0, 0, false);
        when(bonusComponent.calculateBonus(employee)).thenReturn(500.0);

        BonusComponentInterface seniorityBonusDecorator = new SeniorityBonusDecorator(bonusComponent);

        assertThat(seniorityBonusDecorator.calculateBonus(employee)).isEqualTo(650.0);
    }

}

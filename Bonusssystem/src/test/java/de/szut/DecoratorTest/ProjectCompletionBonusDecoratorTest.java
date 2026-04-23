package de.szut.DecoratorTest;

import de.szut.Decorator.ProjectCompletionBonusDecorator;
import de.szut.Interface.BonusComponentInterface;
import de.szut.Model.Employee;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProjectCompletionBonusDecoratorTest {

    BonusComponentInterface bonusComponent = mock(BonusComponentInterface.class);

    @Test
    void add50PerProject() {
        Employee employee = new Employee("Karsten", 3, 70, 4, 5, false);
        when(bonusComponent.calculateBonus(employee)).thenReturn(500.0);

        BonusComponentInterface projectCompletionBonusDecorator = new ProjectCompletionBonusDecorator(bonusComponent);

        assertThat(projectCompletionBonusDecorator.calculateBonus(employee)).isEqualTo(700.0);
    }

}

package de.szut.DecoratorTest;

import de.szut.Decorator.ProjectCompletionBonusDecorator;
import de.szut.Interface.BonusComponentInterface;
import de.szut.Model.Employee;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TeamLeaderBonusDecoratorTest {

    BonusComponentInterface bonusComponent = mock(BonusComponentInterface.class);

    @Test
    void add500ForTeamLeader() {
        Employee employee = new Employee("Elke", 3, 70, 0, 5, false);
        when(bonusComponent.calculateBonus(employee)).thenReturn(500.0);

        BonusComponentInterface projectCompletionBonusDecorator = new ProjectCompletionBonusDecorator(bonusComponent);

        assertThat(projectCompletionBonusDecorator.calculateBonus(employee)).isEqualTo(1000.0);
    }

}

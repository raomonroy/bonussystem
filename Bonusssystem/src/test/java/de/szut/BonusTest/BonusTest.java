package de.szut.BonusTest;

import de.szut.Bonus.BasePerformanceBonus;
import de.szut.Interface.BonusComponentInterface;
import de.szut.Model.Employee;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BonusTest {
    private final Employee employee = new Employee("Max", 3, 50, 2, 5, false);

    @Test
    void returnBaseBonusOf500(){
        BonusComponentInterface baseComponent = new BasePerformanceBonus();
        assertThat(baseComponent.calculateBonus(employee)).isEqualTo(500.0);
    }
}

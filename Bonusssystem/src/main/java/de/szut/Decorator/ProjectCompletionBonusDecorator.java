package de.szut.Decorator;

import de.szut.Interface.BonusComponentInterface;
import de.szut.Model.Employee;

public class ProjectCompletionBonusDecorator extends BonusDecorator {

    private static final double BONUS_PER_PROJECT = 50.0;

    public ProjectCompletionBonusDecorator(BonusComponentInterface bonusComponent) {
        super(bonusComponent);
    }

    @Override
    public double calculateBonus(Employee employee) {
        return super.calculateBonus(employee) + employee.getCompletedProjects() * BONUS_PER_PROJECT;
    }
}

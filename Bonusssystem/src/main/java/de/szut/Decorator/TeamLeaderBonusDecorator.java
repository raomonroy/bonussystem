package de.szut.Decorator;

import de.szut.Interface.BonusComponentInterface;
import de.szut.Model.Employee;

public class TeamLeaderBonusDecorator extends BonusDecorator {

    private static final double TEAM_LEADER_BONUS = 500.0;

    public TeamLeaderBonusDecorator(BonusComponentInterface bonusComponent) {
        super(bonusComponent);
    }

    @Override
    public double calculateBonus(Employee employee) {
        double bonus = super.calculateBonus(employee);

        if (employee.isTeamLeader()) {
            bonus += TEAM_LEADER_BONUS;
        }

        return bonus;
    }
}

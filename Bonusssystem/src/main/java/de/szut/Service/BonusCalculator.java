package de.szut.Service;

import de.szut.Bonus.BasePerformanceBonus;
import de.szut.Decorator.*;
import de.szut.Interface.BonusComponentInterface;
import de.szut.Model.Employee;

public class BonusCalculator {

    private final BonusService bonusService;

    public BonusCalculator(BonusService bonusService) {
        this.bonusService = bonusService;
    }

    public double calculateTotalBonus(Employee employee) {
        BonusComponentInterface basePerformanceBonus = new BasePerformanceBonus();
        basePerformanceBonus = new SeniorityBonusDecorator(basePerformanceBonus);
        basePerformanceBonus = new ProjectCompletionBonusDecorator(basePerformanceBonus);
        basePerformanceBonus = new TeamLeaderBonusDecorator(basePerformanceBonus);
        basePerformanceBonus = new LowAbsenceBonusDecorator(basePerformanceBonus);
        basePerformanceBonus = new AbsencePenaltyDecorator(basePerformanceBonus);
        basePerformanceBonus = new PerformanceMultiplierDecorator(basePerformanceBonus);

        double bonus = basePerformanceBonus.calculateBonus(employee);
        return this.bonusService.applyCompanyRestrictions(bonus);
    }
}

package com.gmail.nossr50.config.experience;

import com.gmail.nossr50.config.AutoUpdateConfigLoader;
import com.gmail.nossr50.datatypes.skills.SkillType;
import com.gmail.nossr50.util.StringUtils;

public class ExperienceConfig extends AutoUpdateConfigLoader {
    private static ExperienceConfig instance;

    private ExperienceConfig() {
        super("experienceFormula.yml");
    }

    public static ExperienceConfig getInstance() {
        if (instance == null) {
            instance = new ExperienceConfig();
        }

        return instance;
    }

    @Override
    protected void loadKeys() {}

    /* XP Formula Multiplier */
    public boolean getFormulaExponential() {
        String curveShape = config.getString("Experience_Formula.Curve");
        if (curveShape.equalsIgnoreCase("EXPONENTIAL")) {
            return true;
        }
        return false;
    }

    public boolean getCumulativeCurveEnabled() { return config.getBoolean("Experience_Formula.Cumulative_Curve", false); }

    /* Linear curve values */
    public int getLinearBase() { return config.getInt("Experience_Formula.Linear_Values.base", 1020); }
    public int getLinearMultiplier() { return config.getInt("Experience_Formula.Linear_Values.multiplier", 20); }

    /* Exponential curve values */
    public int getExponentialMultiplier() { return config.getInt("Experience_Formula.Exponential_Values.multiplier", 3); }
    public double getExponentialExponent() { return config.getDouble("Experience_Formula.Exponential_Values.exponent", 1.85); }
    public int getExponentialBase() { return config.getInt("Experience_Formula.Exponential_Values.base", 20); }

    /* Skill modifiers */
    public double getFormulaSkillModifier(SkillType skill) { return config.getDouble("Experience_Formula.Modifier." + StringUtils.getCapitalized(skill.toString())); }
}

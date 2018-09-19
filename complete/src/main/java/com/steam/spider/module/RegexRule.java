package com.steam.spider.module;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by Maybe on 2018/09/19.
 */
public class RegexRule {
    public RegexRule() {

    }

    private ArrayList<String> positiveRule = new ArrayList<String>();
    private ArrayList<String> negativerule = new ArrayList<String>();



    public RegexRule addRule(String rule) {
        if (rule.length() == 0) {
            return this;
        }
        char pn = rule.charAt(0);
        String realrule = rule.substring(1);
        if (pn == '+') {
            addPositive(realrule);
        } else if (pn == '-') {
            addNegative(realrule);
        } else {
            addPositive(rule);
        }
        return this;
    }



    public RegexRule addPositive(String positiveregex) {
        positiveRule.add(positiveregex);
        return this;
    }


    public RegexRule addNegative(String negativeregex) {
        negativerule.add(negativeregex);
        return this;
    }


    public boolean regex(String str) {

        if (positiveRule.size() == 0) {
            return true;
        }

        for (String nregex : negativerule) {
            if (Pattern.matches(nregex, str)) {
                return false;
            }
        }

        int count = 0;
        for (String pregex : positiveRule) {
            if (Pattern.matches(pregex, str)) {
                count++;
            }
        }
        if (count == 0) {
            return false;
        } else {
            return true;
        }

    }
}

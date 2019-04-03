package com.ld.jwc.util;

import com.ld.jwc.model.GradeDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author mgq  2019.2.27
 * <p>
 * 优秀 -- 95
 * 良好 -- 85
 * 中等 -- 75
 * 及格 -- 60
 * 不及格 -- 55
 */
public class RegularUtil {
    static List<String> testClassesList = new ArrayList<>();
    static Map<String, String> testClassGradeMap = new HashMap<>();

    static {
        testClassesList.add("优秀");
        testClassesList.add("良好");
        testClassesList.add("中等");
        testClassesList.add("中");
        testClassesList.add("及格");
        testClassesList.add("不及格");
        testClassGradeMap.put("优秀", "95");
        testClassGradeMap.put("良好", "85");
        testClassGradeMap.put("中等", "75");
        testClassGradeMap.put("中", "75");
        testClassGradeMap.put("及格", "60");
        testClassGradeMap.put("不及格", "55");
    }

    public static List<GradeDto> doParse(String content) {
        Pattern p = getPattern("<TR[^>]*?>(\\n|.)*?</TR>");
        Matcher m = p.matcher(content);
        List<GradeDto> ls = new ArrayList<>();
        double i = 0;
        double sum = 0;
        while (m.find()) {
            GradeDto gt = new GradeDto();
            List<String> dataStringList = tdText(m.group());
            if (dataStringList.size() <= 0) {
                continue;
            }

            gt.setClassNumber(dataStringList.get(0));
            gt.setClassName(dataStringList.get(1));
            gt.setNo(dataStringList.get(2));
            gt.setCredit(Double.valueOf(dataStringList.get(3)));
            gt.setTime(dataStringList.get(4));
            if (testClassesList.contains(dataStringList.get(5))) {
                gt.setGrade(Double.valueOf(testClassGradeMap.get(dataStringList.get(5))));
            } else {
                gt.setGrade(Double.valueOf(dataStringList.get(5)));
            }
            i += gt.getCredit();
            sum += gt.getCredit() * gt.getGrade();
            ls.add(gt);
        }
        for (GradeDto gto : ls) {
            System.out.println(gto);
        }
        System.out.println(sum);
        System.out.println(i);
        System.out.println(sum / i);
        return ls;
    }

    public static Pattern getPattern(String pattern) {
        return Pattern.compile(pattern);
    }

    public static List<String> tdText(String s) {

        //td
        Pattern p = getPattern("<td[^>]*?>(\\n|.)*?</td>");
        Matcher m = p.matcher(s);
        List<String> stringList = new ArrayList<>();
        while (m.find()) {
            stringList.add(m.group().replaceAll("<td bgcolor=\"#EAE2F3\"><p align=\"center\">", "").replaceAll("</p></td>", ""));

        }

        //TD
        p = getPattern("<TD[^>]*?>(\\n|.)*?</TD>");
        m = p.matcher(s);
        while (m.find()) {
            stringList.add(m.group().replaceAll("<TD>", "").replaceAll("</TD>", ""));

        }
        return stringList;
    }

}

package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;

import java.util.ArrayList;
import java.util.List;

public class LanguageToolTests {

    @Test
    public void testLanguageTool() {
        WebDriver wd = new ChromeDriver();
        List<String> ids = new ArrayList<>();
        for (int page = 0; page < 4370; page=page+10) {
            wd.get("https://community.languagetool.org/rule/list?offset=" + page + "&max=10&lang=en&filter=&categoryFilter=&_action_list=Filter");
            for (int i = 1; i < 11; i++) {
                wd.findElement(By.cssSelector("#mainContent > div > div.list > table > tbody > tr:nth-child(" + i + ") > td:nth-child(1) > a")).click();
                String description = wd.findElement(By.cssSelector("#mainContent > div > table")).getText();
                String regex = "is not active in LanguageTool";
                if (description.contains(regex)) {
                    ids.add(wd.findElement(By.cssSelector("#mainContent > div > table > tbody")).getText());
                    wd.navigate().back();
                } else {
                    wd.navigate().back();
                }
            }
        }

        System.out.println(ids);
    }
}

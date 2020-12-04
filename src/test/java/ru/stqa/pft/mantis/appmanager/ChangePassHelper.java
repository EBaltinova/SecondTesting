package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.mantis.tests.TestBase;

public class ChangePassHelper extends HelperBase {

    public ChangePassHelper(ApplicationManager app) {
        super(app);
    }

    public void signIn(String username, String password) {
        type(By.name("username"), username);
        type(By.name("password"), password);
        click(By.cssSelector("input[value='Login']"));
    }
    public void manageUsers() {
        click(By.cssSelector("body > div:nth-child(4) > p > span:nth-child(1) > a"));
        click(By.cssSelector("body > table:nth-child(8) > tbody > tr:nth-child(7) > td:nth-child(1) > a"));
        click(By.cssSelector("input[value='Reset Password']"));
    }
    public void finish(String confirmationLink, String password) {
        wd.get(confirmationLink);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.cssSelector("input[value='Update User']"));
    }

}

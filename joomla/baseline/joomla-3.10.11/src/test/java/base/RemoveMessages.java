package base;

import org.junit.Test;
import org.openqa.selenium.By;

public class RemoveMessages extends BaseTest {

    @Test
    public void removeMessages() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        loginAsAdmin()
                .siteAdmin()
                .setUsername(adminUser)
                .setPassword(adminPsw)
                .login();
        driver.findElement(By.xpath("//*[@id=\"system-message-container\"]/div[3]/p[3]/a[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[2]/div[2]/div[1]/div/p[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"toolbar-unpublish\"]/button")).click();
    }
}

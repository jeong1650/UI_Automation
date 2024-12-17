package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MKT_02780 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-28
	 * @ ExpectedResult = 사전예약 > 공유하기 선택
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MKT_02780() throws Exception {
		TCID = "OSC700_08_마케팅_02780 [공유하기] 확인 (어드민에서 공유하기 제공하는 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").click();

		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.Button[@text='신규']").click();
		
		Thread.sleep(3000);
		downscroll(By.xpath("//*[@text='사전예약']")).click();
		
		Thread.sleep(5000);
		try {
			driver.findElementByXPath("//*[@text='공유']").click();
		} catch(Exception e) {
			driver.findElementByXPath("//*[@content-desc='공유']").click();
		}
		
		Thread.sleep(5000);
		try {
			driver.findElementById("android:id/icon").isDisplayed();
		} catch(Exception e) {
			driver.findElementById("com.lge:id/title_lg").isDisplayed();
		}
		Thread.sleep(5000);
		driver.navigate().back();
		
		Thread.sleep(5000);
		driver.navigate().back();
								
		result = "PASS";
	}
}
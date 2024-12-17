package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MKT_00290 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-22
	 * @ ExpectedResult = 사전예약 > 공유하기 선택시 안드로이드 기본 제공 레이어 제공
	 * @ Editor = 
	 * @ EditDate = 2020-10-20
	 * @ LG 단말 대응
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MKT_00290() throws Exception {
		TCID = "OSC700_08_마케팅_00290 [공유하기] 선택";
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
		} catch (Exception e) {
			driver.findElementByXPath("//*[@content-desc='공유']").click();
		}
		
		Thread.sleep(5000);
		try {
			driver.findElementById("android:id/icon").isDisplayed();
		} catch(Exception e) {
			driver.findElementById("com.lge:id/title_lg").isDisplayed();
		}
								
		result = "PASS";
	}
}
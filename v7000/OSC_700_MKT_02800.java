package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MKT_02800 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-28
	 * @ ExpectedResult = 사전예약 > 서비스 소개 및 혜택 수령 방법 안내 영역 정상 노출
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MKT_02800() throws Exception {
		TCID = "OSC700_08_마케팅_02800 서비스 소개 및 혜택 수령 방법 안내 영역";
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
			driver.findElementByXPath("//*[@text='사전예약하고\n" + "득템하세요!']").isDisplayed();
		} catch(Exception e) {
			driver.findElementByXPath("//*[@content-desc='사전예약하고']").isDisplayed();
			driver.findElementByXPath("//*[@content-desc='득템하세요!']").isDisplayed();
		}
						
		result = "PASS";
	}
}
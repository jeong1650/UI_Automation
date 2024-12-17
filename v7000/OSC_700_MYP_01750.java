package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_01750 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-10
	 * @ ExpectedResult = 마이페이지 > 구매내역 > 북스 외 > VOD 선택시 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_01750() throws Exception {
		TCID = "OSC700_04_MY_01750 4.VOD 카테고리";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_purchase_list")).click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='북스 외']").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='VOD']").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("구매내역", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		assertEquals("편집", driver.findElementById("com.skt.skaf.A000Z00040:id/appbar_edit_actionlayout").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/my_purchase_date").isDisplayed();
		assertEquals("기간선택", driver.findElementById("com.skt.skaf.A000Z00040:id/my_purchase_select_date").getText());
		
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='게임']").isDisplayed();
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='앱']").isDisplayed();
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='쇼핑']").isDisplayed();
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='북스 외']").isDisplayed();
		
		driver.findElementByXPath("//*[@text='북스']").isDisplayed();
		driver.findElementByXPath("//*[@text='VOD']").isDisplayed();
		driver.findElementByXPath("//*[@text='음악']").isDisplayed();
		
		driver.findElementByXPath("//*[@text='구매하신 영화, TV방송은\n" + 
				"원스토어 VOD에서 확인할 수 있습니다.']").isDisplayed();
		
		assertEquals("원스토어 VOD 구매내역 보기", driver.findElementById("com.skt.skaf.A000Z00040:id/my_purchase_show_vod").getText());
																		
		result = "PASS";

	}
}
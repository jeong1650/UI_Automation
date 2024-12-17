package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_00890 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-04
	 * @ ExpectedResult = 등록 된 긍정/부정 리뷰 존재하는 게임 / 앱 상품 상세 > 긍정 / 부정 리뷰 영역 [>] 선택 시 리스트로 이동
	 * @ Editor = 
	 * @ EditDate = 2020-10-26
	 * @ 단말 사이즈 대응
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_00890() throws Exception {
		TCID = "OSC700_03_APP_00890 [>] 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("캐시워크");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");
		
		Thread.sleep(3000);
		downscroll(By.id("com.skt.skaf.A000Z00040:id/text_affirm_title")).click();
		
		try {
			driver.findElementById("com.skt.skaf.A000Z00040:id/text_affirm_title").isDisplayed();
			
			upSwipe(0.50);
			
			driver.findElementById("com.skt.skaf.A000Z00040:id/text_affirm_title").click();
		} catch(Exception e) {}
		
		Thread.sleep(5000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/radio_affirm").getAttribute("checked").equals("true"));
		assertEquals("신뢰도순", driver.findElementById("com.skt.skaf.A000Z00040:id/text_order").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").click();
		
		Thread.sleep(3000);
		downscroll(By.id("com.skt.skaf.A000Z00040:id/text_deny_title")).click();
		
		try {
			driver.findElementById("com.skt.skaf.A000Z00040:id/text_deny_title").isDisplayed();
			
			upSwipe(0.50);
			
			driver.findElementById("com.skt.skaf.A000Z00040:id/text_deny_title").click();
		} catch(Exception e) {}
		
		Thread.sleep(5000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/radio_deny").getAttribute("checked").equals("true"));
		assertEquals("신뢰도순", driver.findElementById("com.skt.skaf.A000Z00040:id/text_order").getText());
		
		result = "PASS";

	}
}
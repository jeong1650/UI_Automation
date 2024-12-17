package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_00950 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-04
	 * @ ExpectedResult = 게임 / 앱 상품 상세 > 모든 리뷰 보기 화면 > 필터 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_00950() throws Exception {
		TCID = "OSC700_03_APP_00950 필터 영역 확인 (긍정/부정적 리뷰가 모두 있는 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("T map");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");
		
		Thread.sleep(3000);
		upSwipe(0.80);
		upSwipe(0.80);
		upSwipe(0.80);
		upSwipe(0.80);
		
		Thread.sleep(3000);
		upscroll(By.id("com.skt.skaf.A000Z00040:id/lay_more")).click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("리뷰", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText().substring(0, 2));
		assertEquals("전체", driver.findElementById("com.skt.skaf.A000Z00040:id/radio_all").getText());
		assertEquals("긍정적", driver.findElementById("com.skt.skaf.A000Z00040:id/radio_affirm").getText());
		assertEquals("부정적", driver.findElementById("com.skt.skaf.A000Z00040:id/radio_deny").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/radio_all").click();
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/radio_all").getAttribute("checked").equals("true"));
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/radio_affirm").click();
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/radio_affirm").getAttribute("checked").equals("true"));
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/radio_deny").click();
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/radio_deny").getAttribute("checked").equals("true"));
		
		result = "PASS";

	}
}
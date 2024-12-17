package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_01170 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-07
	 * @ ExpectedResult = 게임 / 앱 상품 상세 > 업데이트 내역 영역 선택 시 상세 페이지 이동
	 * @ Editor = 
	 * @ EditDate = 2020-10-15
	 * @ 상품 변경
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_01170() throws Exception {
		TCID = "OSC700_03_APP_01170 업데이트 내역 영역 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("T 전화");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");
		
		Thread.sleep(3000);
		downscroll(By.id("com.skt.skaf.A000Z00040:id/update_info_title_Text_view")).click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("업데이트 내역", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/text_date").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/text_desc").isDisplayed();
		
		result = "PASS";

	}
}
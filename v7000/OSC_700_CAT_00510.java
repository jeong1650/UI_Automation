package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_00510 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-03
	 * @ ExpectedResult = 게임 / 앱 상품 상세 > 게임 상세정보 페이지 > 스크롤 시 타이틀 바 고정 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_00510() throws Exception {
		TCID = "OSC700_03_APP_00510 스크롤 동작 (스크롤 발생)";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("대항해대전 : 오션 앤 엠파이어");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");
		
		Thread.sleep(3000);
		downscroll(By.id("com.skt.skaf.A000Z00040:id/detail_info_title_Text_view")).click();
				
		try {
			Thread.sleep(3000);
			driver.findElementById("com.skt.skaf.A000Z00040:id/detail_info_title_Text_view").isDisplayed();
			
			upSwipe(0.50);
			
			Thread.sleep(3000);
			driver.findElementById("com.skt.skaf.A000Z00040:id/detail_info_title_Text_view").click();
		} catch(Exception e) {}
		
		Thread.sleep(3000);		
		assertEquals("상세정보", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		
		upSwipe(0.70);
		assertEquals("상세정보", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
			
		result = "PASS";

	}
}
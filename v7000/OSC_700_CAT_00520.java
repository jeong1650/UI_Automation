package osc.v7000;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_00520 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-03
	 * @ ExpectedResult = 게임 / 앱 상품 상세 > 게임 상세정보 페이지 > 타이틀 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_00520() throws Exception {
		TCID = "OSC700_03_APP_00520 타이틀 영역 확인";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("상세정보", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/appbar_icon_actionlayout").isDisplayed();
			
		result = "PASS";

	}
}
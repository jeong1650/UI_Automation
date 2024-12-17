package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_00540 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-03
	 * @ ExpectedResult = 게임 / 앱 상품 상세 > 게임 상세정보 페이지 > 업데이트 내역 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_00540() throws Exception {
		TCID = "OSC700_03_APP_00540 업데이트 내역 영역 확인 (업데이트 내용이 3줄 이상)";
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
		assertEquals("업데이트 내역", driver.findElementById("com.skt.skaf.A000Z00040:id/detail_update_title_text_view").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/item_detail_update_date_text_view").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/item_detail_update_contents_text_view").isDisplayed();
		assertEquals("더보기", driver.findElementById("com.skt.skaf.A000Z00040:id/detail_more_update_text_view").getText());

		driver.findElementById("com.skt.skaf.A000Z00040:id/detail_more_update_text_view").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/detail_more_update_text_view")).size() == 0);
		
		result = "PASS";

	}
}
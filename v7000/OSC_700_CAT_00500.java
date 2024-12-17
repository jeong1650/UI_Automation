package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_00500 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-03
	 * @ ExpectedResult = 게임 / 앱 상품 상세 > 게임 상세정보 선택 시 상세정보 페이지로 이동
	 * @ Editor = 
	 * @ EditDate = 2020-10-23
	 * @ upscroll로 탐색
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_00500() throws Exception {
		TCID = "OSC700_03_APP_00500 [>] 선택";
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
		upSwipe(0.80);
		upSwipe(0.80);
		upSwipe(0.80);
		upSwipe(0.80);
		
		Thread.sleep(3000);
		upscroll(By.id("com.skt.skaf.A000Z00040:id/detail_info_title_Text_view")).click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("상세정보", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/appbar_icon_actionlayout").isDisplayed();
		
		assertEquals("게임소개", driver.findElementById("com.skt.skaf.A000Z00040:id/detail_intro_title_text_view").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/detail_intro_description_text_view").isDisplayed();
		
		assertEquals("업데이트 내역", driver.findElementById("com.skt.skaf.A000Z00040:id/detail_update_title_text_view").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/item_detail_update_date_text_view").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/item_detail_update_contents_text_view").isDisplayed();
		
		upSwipe(0.70);
		
		assertEquals("기타 정보", driver.findElementById("com.skt.skaf.A000Z00040:id/detail_etc_title_text_view").getText());
		assertEquals("장르", driver.findElementById("com.skt.skaf.A000Z00040:id/detail_genre_title_text_view").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/detail_genre_text_view").isDisplayed();
		assertEquals("용량", driver.findElementById("com.skt.skaf.A000Z00040:id/detail_size_title_text_view").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/detail_size_text_view").isDisplayed();
		assertEquals("다운로드 수", driver.findElementById("com.skt.skaf.A000Z00040:id/detail_download_title_text_view").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/detail_download_text_view").isDisplayed();
		assertEquals("출시일", driver.findElementById("com.skt.skaf.A000Z00040:id/detail_release_date_title_text_view").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/detail_release_date_text_view").isDisplayed();
		
		driver.findElementByXPath("//android.widget.TextView[@text='앱 권한 정보']").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/detail_permission_info_layout").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/detail_permission_info_layout")).size() == 0);
			
		result = "PASS";

	}
}
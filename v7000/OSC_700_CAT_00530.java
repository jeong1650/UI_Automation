package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_00530 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-03
	 * @ ExpectedResult = 게임 / 앱 상품 상세 > 게임 상세정보 페이지 > 게임 소개 영역 정상 노출 
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_00530() throws Exception {
		TCID = "OSC700_03_APP_00530 게임 소개 영역 확인 (한줄설명과 게임소개 합쳐서 7줄이 넘는 경우)";
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
			driver.findElementById("com.skt.skaf.A000Z00040:id/detail_intro_description_text_view").isDisplayed();
		} catch(Exception e) {
			upSwipe(0.50);
			
			Thread.sleep(3000);
			driver.findElementById("com.skt.skaf.A000Z00040:id/detail_info_title_Text_view").click();
		}
		
		Thread.sleep(3000);
		assertEquals("게임소개", driver.findElementById("com.skt.skaf.A000Z00040:id/detail_intro_title_text_view").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/detail_intro_description_text_view").isDisplayed();
		assertEquals("더보기", driver.findElementById("com.skt.skaf.A000Z00040:id/detail_more_introduce_text_view").getText());

		driver.findElementById("com.skt.skaf.A000Z00040:id/detail_more_introduce_text_view").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/detail_more_introduce_text_view")).size() == 0);
		
		result = "PASS";

	}
}
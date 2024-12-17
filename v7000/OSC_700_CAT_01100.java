package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_01100 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-07
	 * @ ExpectedResult = 게임 / 앱 상품 상세 > 판매자 정보 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_01100() throws Exception {
		TCID = "OSC700_03_APP_01100 판매자 정보 영역 확인";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("프로야구 H2");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");
		
		Thread.sleep(3000);
		assertEquals("판매자 정보", downscroll(By.id("com.skt.skaf.A000Z00040:id/seller_info_title_text_view")).getText());

		downscroll(By.id("com.skt.skaf.A000Z00040:id/seller_info_point_image_layout"));
		driver.findElementById("com.skt.skaf.A000Z00040:id/seller_info_point_image_layout").isDisplayed();
		assertEquals("문의하기", driver.findElementById("com.skt.skaf.A000Z00040:id/seller_info_contact_us_text_view").getText());
			
		result = "PASS";

	}
}
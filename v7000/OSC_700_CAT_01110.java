package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_01110 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-07
	 * @ ExpectedResult = 게임 / 앱 상품 상세 > 판매자명 [ⓘ] 선택 시 판매자 정보 팝업 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_01110() throws Exception {
		TCID = "OSC700_03_APP_01110 판매자명 [ⓘ] 선택 (개인/법인/해외 사업자, 웹페이지 방문 제공 , 개인정보 처리 방침 제공 )";
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
		downscroll(By.id("com.skt.skaf.A000Z00040:id/seller_info_point_image_layout"));
		
		upSwipe(0.80);
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/seller_info_point_image_layout").click();
		
		Thread.sleep(3000);
		assertEquals("판매자 정보", downscroll(By.id("com.skt.skaf.A000Z00040:id/title")).getText());
		
		assertEquals("상호", downscroll(By.id("com.skt.skaf.A000Z00040:id/product_name")).getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/product_name_disc").isDisplayed();
		assertEquals("대표자", downscroll(By.id("com.skt.skaf.A000Z00040:id/owner_name")).getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/owner_name_desc").isDisplayed();
		assertEquals("이메일", downscroll(By.id("com.skt.skaf.A000Z00040:id/email")).getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/email_desc").isDisplayed();
		assertEquals("대표전화", downscroll(By.id("com.skt.skaf.A000Z00040:id/owner_phone_number")).getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/owner_phone_number_desc").isDisplayed();
		assertEquals("주소", downscroll(By.id("com.skt.skaf.A000Z00040:id/address")).getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/address_desc").isDisplayed();
		assertEquals("통신판매업신고", downscroll(By.id("com.skt.skaf.A000Z00040:id/mail_order_number")).getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/mail_order_number_desc").isDisplayed();
		
		assertEquals("웹페이지 방문", downscroll(By.id("com.skt.skaf.A000Z00040:id/web_page_link")).getText());
		assertEquals("개인정보처리방침", downscroll(By.id("com.skt.skaf.A000Z00040:id/private_policy_link")).getText());
			
		result = "PASS";

	}
}
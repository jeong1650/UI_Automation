package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_01130 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-07
	 * @ ExpectedResult = 게임 / 앱 상품 상세 > [문의하기] 선택 시 팝업 노출
	 * @ Editor = 
	 * @ EditDate = 2020-10-26
	 * @ 단말 사이즈 대응
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_01130() throws Exception {
		TCID = "OSC700_03_APP_01130 [문의하기] 선택";
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
		downscroll(By.id("com.skt.skaf.A000Z00040:id/seller_info_contact_us_text_view"));
		
		upSwipe(0.80);
		
		Thread.sleep(2000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/seller_info_contact_us_text_view").click();
		
		Thread.sleep(3000);
		assertEquals("상품 문의를 위해 판매자에게 메일을 보냅니다. 원스토어 서비스에 대한 문의는 마이 내 고객센터를 이용해 주세요.", 
				driver.findElementById("com.skt.skaf.A000Z00040:id/description").getText());
		assertEquals("취소", driver.findElementById("com.skt.skaf.A000Z00040:id/btn1").getText());
		assertEquals("확인", driver.findElementById("com.skt.skaf.A000Z00040:id/btn2").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn1").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/btn2")).size() == 0);
		
		result = "PASS";

	}
}
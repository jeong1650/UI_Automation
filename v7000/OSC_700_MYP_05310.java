package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_05310 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-11
	 * @ ExpectedResult = 마이페이지 > 고객센터 > 메뉴 정상 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_05310() throws Exception {
		TCID = "OSC700_04_설정_05310 고객센터";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_customer_center")).click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("고객센터", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		
		assertEquals("어떤 도움이 필요하세요?", driver.findElementById("com.skt.skaf.A000Z00040:id/mycustom_searchbar_keyword_edittext").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/mycustom_searchbar_search_icon").isDisplayed();
		
		assertEquals("자주 찾는 FAQ", driver.findElementById("com.skt.skaf.A000Z00040:id/search_faq").getText());
		assertEquals("전체보기", driver.findElementById("com.skt.skaf.A000Z00040:id/custom_faq_allView").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/faq_lis_1").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/faq_lis_1_icon").isDisplayed();
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/indicator"));
				
		result = "PASS";

	}
}
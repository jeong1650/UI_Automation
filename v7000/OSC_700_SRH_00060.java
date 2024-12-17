package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_SRH_00060 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-15
	 * @ ExpectedResult = 상품상세 > 검색 > 검색어 입력 전 back 버튼 선택 시 상품상세 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_00060() throws Exception {
		TCID = "OSC700_05_검색_00060 상단 Back 버튼 선택 (검색어 입력 전인 상태)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/titleView")).click();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/action_detail_search").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").isDisplayed();
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/search_main_rank_section")).size() == 0);
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_gnb_back").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_product_name_text_view").isDisplayed();
		
		result = "PASS";
	}
}
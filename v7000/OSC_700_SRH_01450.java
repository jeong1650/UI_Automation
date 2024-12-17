package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_SRH_01450 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-18
	 * @ ExpectedResult = 메인 > 검색 > 쇼핑상품 부가정보 on / off 가능
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_01450() throws Exception {
		TCID = "OSC700_05_검색_01450 부가 정보 버튼 영역 확인";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		try {
			driver.findElementById("com.skt.skaf.A000Z00040:id/search_history_all_delete").click();
		} catch (Exception e) {}
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("핫후라이드+치즈볼+콜라1.25L");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		String tagXPath = "//*[@resource-id='com.skt.skaf.A000Z00040:id/search_result_tag_list_view']/*";
		driver.findElementByXPath(tagXPath + "/*[@index='0']/*[@resource-id='com.skt.skaf.A000Z00040:id/search_tag_keyword']").click();
		assertTrue(driver.findElementByXPath(tagXPath + "/*[@index='0']/*[@resource-id='com.skt.skaf.A000Z00040:id/search_tag_keyword']").isSelected());		
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_detail_shop_similar_icon").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_detail_shop_similar_product_name").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_detail_shop_similar_price").isDisplayed();
		
		driver.findElementByXPath(tagXPath + "/*[@index='0']/*[@resource-id='com.skt.skaf.A000Z00040:id/search_tag_keyword']").click();
		
		Thread.sleep(3000);
		assertFalse(driver.findElementByXPath(tagXPath + "/*[@index='0']/*[@resource-id='com.skt.skaf.A000Z00040:id/search_tag_keyword']").isSelected());		
		
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/search_result_detail_container")).isEmpty());
		
		result = "PASS";
	}
}
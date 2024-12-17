package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_SRH_01080 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-17
	 * @ ExpectedResult = 메인 > 검색 > 카테고리 1개 존재 시 카테고리 필터 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_01080() throws Exception {
		TCID = "OSC700_05_검색_01080 검색 필터 영역 (카테고리가 1개만 있는 경우)";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("SPEDOG");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@resource-id='com.skt.skaf.A000Z00040:id/search_result_category_list']/*[@index='0']/*[@text='전체']").isDisplayed();
		driver.findElementByXPath("//*[@resource-id='com.skt.skaf.A000Z00040:id/search_result_category_list']/*[@index='1']/*[@text='게임']").isDisplayed();
		
		assertTrue(driver.findElements(By.xpath("//*[@resource-id='com.skt.skaf.A000Z00040:id/search_result_category_list']/*[@index='2']")).isEmpty());
						
		result = "PASS";
	}
}
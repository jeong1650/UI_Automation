package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_SRH_01350 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-18
	 * @ ExpectedResult = 메인 > 검색 > 구글 아웃링크 상풍 > 부가 정보 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_01350() throws Exception {
		TCID = "OSC700_05_검색_01350 부가 정보 영역 확인";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("멜론");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		String srhResultXPath = "//*[@resource-id='com.skt.skaf.A000Z00040:id/search_result_root']/*[@index='1']";
		
		driver.findElementByXPath(srhResultXPath + "//*[@resource-id='com.skt.skaf.A000Z00040:id/search_result_item_app_img']").isDisplayed();
		driver.findElementByXPath(srhResultXPath + "//*[@resource-id='com.skt.skaf.A000Z00040:id/search_result_item_app_title']").isDisplayed();
		driver.findElementByXPath(srhResultXPath + "//*[@resource-id='com.skt.skaf.A000Z00040:id/search_result_item_app_seller']").isDisplayed();
		assertTrue(driver.findElements(By.xpath(srhResultXPath + "//*[@resource-id='com.skt.skaf.A000Z00040:id/search_result_item_app_price']")).isEmpty());
		assertTrue(driver.findElements(By.xpath(srhResultXPath + "//*[@resource-id='com.skt.skaf.A000Z00040:id/search_result_item_app_star_container']")).isEmpty());
		assertTrue(driver.findElements(By.xpath(srhResultXPath + "//*[@resource-id='com.skt.skaf.A000Z00040:id/search_result_item_download_button']")).isEmpty());
		driver.findElementByXPath(srhResultXPath + "//*[@resource-id='com.skt.skaf.A000Z00040:id/search_result_tag_list_view']").isDisplayed();
		
		result = "PASS";
	}
}
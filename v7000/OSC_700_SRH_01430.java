package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_SRH_01430 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-18
	 * @ ExpectedResult = 메인 > 검색 > 쇼핑상품 부가정보 off 처리되어 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_01430() throws Exception {
		TCID = "OSC700_05_검색_01430 부가 정보 영역 (최상위 결과인 경우)";
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
		assertFalse(driver.findElementByXPath(tagXPath + "/*[@index='0']/*[@resource-id='com.skt.skaf.A000Z00040:id/search_tag_keyword']").isSelected());
		assertFalse(driver.findElementByXPath(tagXPath + "/*[@index='1']/*[@resource-id='com.skt.skaf.A000Z00040:id/search_tag_keyword']").isSelected());
		assertFalse(driver.findElementByXPath(tagXPath + "/*[@index='2']/*[@resource-id='com.skt.skaf.A000Z00040:id/search_tag_keyword']").isSelected());
		
		result = "PASS";
	}
}
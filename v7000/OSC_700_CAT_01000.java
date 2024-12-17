package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_01000 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-07
	 * @ ExpectedResult = 게임 / 앱 상품 상세 > 비슷한 게임(앱) 영역 > [전체] 외 태그 선택 시 선택한 태그 활성화
	 * @ Editor = 
	 * @ EditDate = 2020-10-26
	 * @ 상품 변경
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_01000() throws Exception {
		TCID = "OSC700_03_APP_01000 [전체] 외 태그 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("백원짜리 쇼핑몰");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");
		
		Thread.sleep(3000);
		downscroll(By.xpath("//android.widget.TextView[@text='비슷한 앱']"));
		downscroll(By.id("com.skt.skaf.A000Z00040:id/rg_keyword"));
		driver.findElementByXPath("//android.widget.RadioButton[@text='전체']").isDisplayed();
		downscroll(By.id("com.skt.skaf.A000Z00040:id/hlistview"));
		
		driver.findElementByXPath("//*[@resource-id='com.skt.skaf.A000Z00040:id/rg_keyword']/*[@index='1']").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementByXPath("//*[@resource-id='com.skt.skaf.A000Z00040:id/rg_keyword']/*[@index='1']").getAttribute("checked").equals("true"));
		assertTrue(driver.findElementByXPath("//android.widget.RadioButton[@text='전체']").getAttribute("checked").equals("false"));
		
		result = "PASS";

	}
}
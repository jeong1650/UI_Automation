package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_02260 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-08
	 * @ ExpectedResult = 쇼핑 상품 상세 > 비슷한 상품 영역 > [전체]외 태그 선택 가능
	 * @ Editor = 
	 * @ EditDate = 2020-10-28
	 * @ 불필요 코드 삭제
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_02260() throws Exception {
		TCID = "OSC700_03_쇼핑_02260 [전체] 외 태그 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("SWITCH 본체 네온 + 매일매일 두뇌트레이닝*[LIVE]");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_shop_title").click();

		Thread.sleep(3000);
		downscroll(By.xpath("//*[@text='비슷한 상품']"));
		downscroll(By.id("com.skt.skaf.A000Z00040:id/rg_keyword"));
		driver.findElementByXPath("//android.widget.RadioButton[@text='전체']").isDisplayed();
		
		driver.findElementByXPath("//*[@resource-id='com.skt.skaf.A000Z00040:id/rg_keyword']/*[@index='1']").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementByXPath("//*[@resource-id='com.skt.skaf.A000Z00040:id/rg_keyword']/*[@index='1']").getAttribute("checked").equals("true"));
		assertTrue(driver.findElementByXPath("//android.widget.RadioButton[@text='전체']").getAttribute("checked").equals("false"));
				
		result = "PASS";

	}
}
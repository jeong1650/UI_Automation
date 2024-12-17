package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_02250 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-08
	 * @ ExpectedResult = 쇼핑 상품 상세 > 비슷한 상품 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_02250() throws Exception {
		TCID = "OSC700_03_쇼핑_02250 비슷한 상품 영역 확인";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("리얼오토 터치 자동 고속 무선충전 거치대*");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_shop_title").click();

		Thread.sleep(3000);
		downscroll(By.xpath("//android.widget.TextView[@text='비슷한 상품']"));
		downscroll(By.id("com.skt.skaf.A000Z00040:id/rg_keyword"));
		driver.findElementByXPath("//android.widget.RadioButton[@text='전체']").isDisplayed();
		downscroll(By.id("com.skt.skaf.A000Z00040:id/hlistview"));
				
		result = "PASS";

	}
}
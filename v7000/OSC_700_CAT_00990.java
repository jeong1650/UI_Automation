package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_00990 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-07
	 * @ ExpectedResult = 게임 / 앱 상품 상세 > 비슷한 게임(앱) 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_00980() throws Exception {
		TCID = "OSC700_03_APP_00990 비슷한 게임(앱) 영역 확인";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("T map");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");
		
		Thread.sleep(3000);
		downscroll(By.xpath("//android.widget.TextView[@text='비슷한 앱']"));
		downscroll(By.id("com.skt.skaf.A000Z00040:id/rg_keyword"));
		driver.findElementByXPath("//android.widget.RadioButton[@text='전체']").isDisplayed();
		downscroll(By.id("com.skt.skaf.A000Z00040:id/hlistview"));
		
		result = "PASS";

	}
}
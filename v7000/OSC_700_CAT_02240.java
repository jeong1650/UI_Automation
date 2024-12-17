package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_02240 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-08
	 * @ ExpectedResult = 쇼핑 상품 상세 > 연관상품 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_02240() throws Exception {
		TCID = "OSC700_03_쇼핑_02240 연관상품 영역 확인";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("SWITCH 링 피트 어드벤처*");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_shop_title").click();

		Thread.sleep(3000);
		downscroll(By.xpath("//android.widget.TextView[@text='비슷한 상품']"));
		downscroll(By.xpath("//android.widget.TextView[@text='닌텐도스위치  다른 상품']"));
		downscroll(By.xpath("//android.widget.TextView[@text='콘솔타이틀  인기 상품']"));
				
		result = "PASS";

	}
}
package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_01920 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-08
	 * @ ExpectedResult = 쇼핑 배송상품 상세 > 판매자가 등록한 상품이미지 및 상품 소개 텍스트 노출
	 * @ Editor = 
	 * @ EditDate = 2020-10-13
	 * @ 상품 변경
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_01920() throws Exception {
		TCID = "OSC700_03_쇼핑_01920 상품 정보 영역 확인";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("게이밍 헤드셋 GSP500");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_shop_title").click();

		Thread.sleep(3000);
		downscroll(By.id("com.skt.skaf.A000Z00040:id/product_info_image_container"));
					
		result = "PASS";

	}
}
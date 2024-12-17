package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_00640 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-04
	 * @ ExpectedResult = 구매 전 평점 및 리뷰 등록 없는 게임 / 앱 상품 상세 > 평점 및 리뷰 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 2020-10-20
	 * @ 상품 변경
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_00640() throws Exception {
		TCID = "OSC700_03_APP_00640 평점 및 리뷰 영역 확인 (구매 전 평점 및 리뷰 등록 없는 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("Mine Drive");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");
		
		Thread.sleep(3000);
		downscroll(By.xpath("//*[@text='평점 및 리뷰']"));
		shortdownscroll(By.xpath("//*[@text='입력된 평가 의견이 없습니다']"));
		
		result = "PASS";

	}
}
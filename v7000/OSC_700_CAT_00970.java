package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_00970 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-04
	 * @ ExpectedResult = 게임 상품 상세 > 연관 상품 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 2020-10-20
	 * @ 상품 변경
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_00970() throws Exception {
		TCID = "OSC700_03_APP_00970 연관상품 영역 확인";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("천령");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");
		
		Thread.sleep(3000);
		downscroll(By.xpath("//*[@text='비슷한 게임']"));
		downscroll(By.xpath("//*[@text='Shanghai youlu…의 다른 상품']"));
		downscroll(By.xpath("//*[@text='함께 구매한 게임']"));
		
//		downscroll(By.xpath("//android.widget.TextView[@text='이 상품은 어떠세요?']"));
		result = "PASS";

	}
}
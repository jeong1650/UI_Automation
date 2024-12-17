package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_CAT_01192 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-07
	 * @ ExpectedResult = 무료, 인앱 게임 / 앱 상품 상세 > 청약철회 및 통신판매 중개 사업자 안내 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_CAT_01192() throws Exception {
		TCID = "OSC700_03_APP_01192 2.청약철회 및 통신판매 중개 사업자 안내 영역 확인";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");

		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("별이되어라");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");

		Thread.sleep(3000);
		assertEquals("환불안내 : 상품 구매일로부터 7일 이내에 청약철회가 가능합니다. 디지털콘텐츠 상품은 청약철회가 제한될 수 있습니다. \n" + "자세히보기",
				downscroll(By.id("com.skt.skaf.A000Z00040:id/seller_info_withdrawal_text_view")).getText());
		downscroll(By.xpath(
				"//android.widget.TextView[@text='KT(주), (주)LG유플러스, 원스토어(주)는 통신판매중개자로서 상품의 등록정보, 판매, 문의답변에 대한 의무와 책임은 각 판매자에게 있습니다.']"));

		result = "PASS";

	}
}
package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_PAY_00011 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-29
	 * @ ExpectedResult = 결제 페이지 > 환불 안내 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_PAY_00011() throws Exception {
		TCID = "OSC600_09_APP_00011 구매하기 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("SPEDOG");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/text").click();
						
		Thread.sleep(3000);
		downscroll(By.xpath("//*[@text='환불 안내 : 상품 구매일로부터 7일 이내에 청약철회가 가능합니다. 디지털콘텐츠 상품은 청약 철회가 제한될 수 있습니다. ']"));
		downscroll(By.xpath("//*[@text='자세히 보기']"));
		downscroll(By.xpath("//*[@text='최종결제금액은 휴대폰 또는 신용카드 명세서에 합산 청구됩니다.']"));		
		downscroll(By.xpath("//*[@text='KT(주), (주)LG유플러스, 원스토어(주)는 통신판매중개자로서 상품의 등록정보, 판매, 문의 답변에 대한 의무와 책임은 각 판매자에게 있습니다.']"));
		
		result = "PASS";

	}
}
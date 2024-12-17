package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_SRH_01630 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-21
	 * @ ExpectedResult = 메인 > 검색 > 쇼핑 상품 연관 카테고리 인기상품 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_01630() throws Exception {
		TCID = "OSC700_05_검색_01630 쇼핑 연관 카테고리 인기상품 영역 확인";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		try {
			driver.findElementById("com.skt.skaf.A000Z00040:id/search_history_all_delete").click();
		} catch (Exception e) {}
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("뚜레쥬르");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		downscroll(By.xpath("//*[@text='교환권 TOP 20']"));		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/search_result_icon_card_kind"));
		downscroll(By.id("com.skt.skaf.A000Z00040:id/search_result_detail_shop_similar_icon"));
		downscroll(By.id("com.skt.skaf.A000Z00040:id/search_result_detail_shop_similar_product_name"));
		downscroll(By.id("com.skt.skaf.A000Z00040:id/search_result_detail_shop_similar_price"));
		
		result = "PASS";
	}
}
package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_PAD_00570 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-22
	 * @ ExpectedResult = 쇼핑 상세 > [선물하기] > 수신인 입력 완료 후 [확인] 선택 시 메시지 입력 팝업 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_PAD_00570() throws Exception {
		TCID = "OSC700_06_쇼핑_00570 [확인] 선택(수신인이 입력 완료된 경우)";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("CU 바나나우유");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_shop_title").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_gift_view").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_gift_view").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/contact_name").sendKeys("홍길동");
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/contact_number").sendKeys("010-1234-5678");
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/text_confirm").click();
				
		Thread.sleep(3000);
		assertEquals("선물 메시지를 입력해주세요", driver.findElementById("com.skt.skaf.A000Z00040:id/title").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/message_box_layout").isDisplayed();
		assertEquals("[CU] 바나나맛 우유을 원스토어 선물로 보냅니다.", driver.findElementById("com.skt.skaf.A000Z00040:id/gift_message").getText());
		assertEquals("(0/50 자)", driver.findElementById("com.skt.skaf.A000Z00040:id/limit_word").getText());
		assertEquals("취소", driver.findElementById("com.skt.skaf.A000Z00040:id/btn1").getText());
		assertEquals("확인", driver.findElementById("com.skt.skaf.A000Z00040:id/btn2").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn1").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/btn1")).size() == 0);
				
		result = "PASS";
	}
}
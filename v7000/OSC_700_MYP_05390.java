package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_05390 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-14
	 * @ ExpectedResult = 마이페이지 > 고객센터 > 라이브 채팅 > 상단 정보 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_05390() throws Exception {
		TCID = "OSC700_04_설정_05390 상단 정보 영역 확인";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_customer_center")).click();
		
		Thread.sleep(3000);
		downscroll(By.id("com.skt.skaf.A000Z00040:id/custom_live_kakaotalk_chatting")).click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='상담일']").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/tv_consultant_date_for_kakaotalk_consultant").isDisplayed();
		
		driver.findElementByXPath("//*[@text='모델명']").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/tv_phone_model_name_for_kakaotalk_consultant").isDisplayed();
		
		assertEquals("휴대폰 번호", driver.findElementById("com.skt.skaf.A000Z00040:id/tv_field_mdn_or_id").getText());
		driver.findElementById("com.skt.skaf.A000Z00040:id/tv_phone_number_for_kakaotalk_consultant").isDisplayed();
										
		result = "PASS";
	}
}
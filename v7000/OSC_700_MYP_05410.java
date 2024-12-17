package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_05410 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-14
	 * @ ExpectedResult = 마이페이지 > 고객센터 > 라이브 채팅 > 문의정보 미선택 > [상담하기] 시 팝업 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_05410() throws Exception {
		TCID = "OSC700_04_설정_05410 [상담하기] 선택 (제목 1번째 항목이 선택되지 않은 경우)";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/ll_consult").click();
		
		Thread.sleep(3000);
		assertEquals("알림", driver.findElementById("com.skt.skaf.A000Z00040:id/title").getText());
		assertEquals("문의 종류를 선택해 주세요.", driver.findElementById("com.skt.skaf.A000Z00040:id/description").getText());
		assertEquals("확인", driver.findElementById("com.skt.skaf.A000Z00040:id/btn1").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn1").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElements(By.id("com.skt.skaf.A000Z00040:id/description")).size() == 0);
												
		result = "PASS";
	}
}
package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_05630 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-14
	 * @ ExpectedResult = 마이페이지 > 고객센터 > 이메일 문의 > 상세항목 미선택 시 팝업 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_05630() throws Exception {
		TCID = "OSC700_04_설정_05630 상세 항목 미선택 후 [확인] 선택 (제목 2번째 항목이 선택되지 않은 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_customer_center")).click();
		
		Thread.sleep(3000);
		downscroll(By.id("com.skt.skaf.A000Z00040:id/custom_email")).click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/cs_email_content").sendKeys("park60312@hanmail.net");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_cs_type_question_dropdown").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.CheckBox[@text='기타']").click();
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/cs_button_confirm")).click();
		
		Thread.sleep(3000);
		assertEquals("알림", driver.findElementById("com.skt.skaf.A000Z00040:id/title").getText());
		assertEquals("상세 항목을 선택해 주세요.", driver.findElementById("com.skt.skaf.A000Z00040:id/description").getText());
		assertEquals("확인", driver.findElementById("com.skt.skaf.A000Z00040:id/btn1").getText());
										
		result = "PASS";
	}
}
package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_05580 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-14
	 * @ ExpectedResult = 마이페이지 > 고객센터 > 이메일 문의 > 내용 작성 후 취소 시 팝업 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_05580() throws Exception {
		TCID = "OSC700_04_설정_05580 [취소] 선택 or < 문의하기 or back 버튼 (문의 내용이 작성)";
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
		downscroll(By.xpath("//*[@text='제목']"));
		driver.findElementById("com.skt.skaf.A000Z00040:id/cs_etc_text").isDisplayed();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/cs_etc_text").sendKeys("Test");
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").click();
		
		Thread.sleep(3000);
		assertEquals("작성중인 내용이 삭제됩니다.", driver.findElementById("com.skt.skaf.A000Z00040:id/description").getText());
		assertEquals("취소", driver.findElementById("com.skt.skaf.A000Z00040:id/btn1").getText());
		assertEquals("확인", driver.findElementById("com.skt.skaf.A000Z00040:id/btn2").getText());
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn1").click();
		
		Thread.sleep(3000);
		downscroll(By.id("com.skt.skaf.A000Z00040:id/cs_button_cancel")).click();
		
		Thread.sleep(3000);
		assertEquals("작성중인 내용이 삭제됩니다.", driver.findElementById("com.skt.skaf.A000Z00040:id/description").getText());
		assertEquals("취소", driver.findElementById("com.skt.skaf.A000Z00040:id/btn1").getText());
		assertEquals("확인", driver.findElementById("com.skt.skaf.A000Z00040:id/btn2").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn1").click();
		
		Thread.sleep(3000);
		driver.navigate().back();
		
		Thread.sleep(3000);
		assertEquals("작성중인 내용이 삭제됩니다.", driver.findElementById("com.skt.skaf.A000Z00040:id/description").getText());
		assertEquals("취소", driver.findElementById("com.skt.skaf.A000Z00040:id/btn1").getText());
		assertEquals("확인", driver.findElementById("com.skt.skaf.A000Z00040:id/btn2").getText());
		
		Click("com.skt.skaf.A000Z00040:id/btn2");
		
		Thread.sleep(3000);
		assertEquals("고객센터", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		
		result = "PASS";
	}
}
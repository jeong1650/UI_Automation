package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_05730 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-15
	 * @ ExpectedResult = 마이페이지 > 고객센터 > 이메일 문의 > 이벤트 선택 시 내용 영역 자동 입력
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_05730() throws Exception {
		TCID = "OSC700_04_설정_05730 내용 영역 확인";
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
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_cs_type_question_dropdown").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.CheckBox[@text='이벤트']").click();
		
		assertEquals(
				"1.참여 이벤트명 :\n" + 
				"2.이벤트 참여 및 이벤트 상품 결제 일시(날짜,시간) :\n" + 
				"3.이벤트 참여로 구매한 상품명 : (게임 내 결제 상품일 경우 게임명기재)\n" + 
				"4.미지급 상품명 : (캐쉬/쿠폰)\n" + 
				"5.요청사항 :", 
				downscroll(By.id("com.skt.skaf.A000Z00040:id/cs_question_detail")).getText());
												
		result = "PASS";
	}
}
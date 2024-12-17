package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_05720 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-15
	 * @ ExpectedResult = 마이페이지 > 고객센터 > 이메일 문의 > 쇼핑 선택 시 내용 영역 자동 입력
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_05720() throws Exception {
		TCID = "OSC700_04_설정_05720 내용 영역 확인";
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
		driver.findElementByXPath("//android.widget.CheckBox[@text='쇼핑']").click();
		
		assertEquals(
				"1.상품명 :\n" + 
				"2.상품 금액 :\n" + 
				"3.발생 현상 및 팝업 문구 :\n" + 
				"4.배송지 입력여부 :\n" + 
				"5.상품 사용여부 : (교환권 및 상품권 등 사용여부)\n" + 
				"6.요청사항 :\n" + 
				"7.환불 요청 사유(상세 기재) :\n" + 
				"8.사용 통신사 및 요금제 정보 :", 
				downscroll(By.id("com.skt.skaf.A000Z00040:id/cs_question_detail")).getText());
												
		result = "PASS";
	}
}
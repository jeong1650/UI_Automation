package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_05680 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-14
	 * @ ExpectedResult = 마이페이지 > 고객센터 > 이메일 문의 > 이용문의 선택 시 내용 영역 자동 입력
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_05680() throws Exception {
		TCID = "OSC700_04_설정_05680 내용 영역 확인";
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
		driver.findElementByXPath("//android.widget.CheckBox[@text='이용문의']").click();
		
		assertEquals(
				"1.기존 사용 아이디 :\n" + 
				"2.기존 사용 휴대번호 :\n" + 
				"3.접속/다운로드 불가 상품명(서비스명) :\n" + 
				"4.접속/다운로드 불가 시 발생 현상 및 팝업 문구 :\n" + 
				"5.오류 발생 일시(날짜,시간) :\n" + 
				"6.접속 시 통신상태 : (Wi-Fi / LTE / VPN 사용여부)\n" + 
				"7.요청사항 :", 
				downscroll(By.id("com.skt.skaf.A000Z00040:id/cs_question_detail")).getText());
												
		result = "PASS";
	}
}
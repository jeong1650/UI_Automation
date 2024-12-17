package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_05690 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-14
	 * @ ExpectedResult = 마이페이지 > 고객센터 > 이메일 문의 > 구매/결제 선택 시 내용 영역 자동 입력
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_05690() throws Exception {
		TCID = "OSC700_04_설정_05690 내용 영역 확인";
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
		driver.findElementByXPath("//android.widget.CheckBox[@text='구매/결제']").click();
		
		assertEquals(
				"1.상품명(게임명) :\n" + 
				"2.결제 일시(날짜,시간) :\n" + 
				"3.게임 내 정보 : (서버명/캐릭터명/로그인 아이디/카카오회원번호 등)\n" + 
				"4.결제한 아이템명 :\n" + 
				"5.결제한 상품(아이템) 가격 :\n" + 
				"6.요청사항 : (아이템 지급/환불)\n" + 
				"7.환불 요청 사유 : (사유 상세 기재)\n" + 
				"8.아이템 사용여부 : (지급된 아이템 환불 요청 시 사용여부 기재)", 
				downscroll(By.id("com.skt.skaf.A000Z00040:id/cs_question_detail")).getText());
												
		result = "PASS";
	}
}
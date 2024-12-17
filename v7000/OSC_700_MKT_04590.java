package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_MKT_04590 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-29
	 * @ ExpectedResult = 혜택 > 쿠폰/캐쉬 등록 화면 > 입력창 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MKT_04590() throws Exception {
		TCID = "OSC700_08_마케팅_04590 쿠폰번호(난수) 입력부 영역";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_benefit").click();

		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='쿠폰/캐쉬 등록']").click();
		
		Thread.sleep(3000);
		assertEquals("쿠폰/캐쉬 번호를 입력해주세요.", driver.findElementById("com.skt.skaf.A000Z00040:id/et_cash_reg_number").getText());
		assertEquals("등록하기", driver.findElementById("com.skt.skaf.A000Z00040:id/bt_reg_done").getText());
						
		result = "PASS";
	}
}
package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;

public class OSC_700_MKT_04570 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-29
	 * @ ExpectedResult = 혜택 > [쿠폰 캐쉬 등록] 선택 시 화면 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MKT_04570() throws Exception {
		TCID = "OSC700_08_마케팅_04570 [쿠폰 캐쉬 등록] 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_benefit").click();

		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='쿠폰/캐쉬 등록']").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("쿠폰/캐쉬 등록", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		
		assertEquals("쿠폰/캐쉬 번호를 입력해주세요.", driver.findElementById("com.skt.skaf.A000Z00040:id/et_cash_reg_number").getText());
		assertEquals("등록하기", driver.findElementById("com.skt.skaf.A000Z00040:id/bt_reg_done").getText());
		
		assertEquals("유효기간이 만료된 쿠폰은 등록하실 수 없습니다. \n" + 
				"유효기간을 확인해 주세요.", driver.findElementById("com.skt.skaf.A000Z00040:id/msg_cash_tstore_cash_reg_description1").getText());
		assertEquals("등록된 쿠폰은 내 쿠폰에서 확인할 수 있습니다.", driver.findElementById("com.skt.skaf.A000Z00040:id/msg_cash_tstore_cash_reg_description2").getText());
		assertEquals("캐쉬 종류에 따라 사용처가 제한될 수 있습니다. \n" + 
				"자세한 내용은 FAQ를 참고해 주세요.", driver.findElementById("com.skt.skaf.A000Z00040:id/msg_my_coupon_cash_description3").getText());
				
		result = "PASS";
	}
}
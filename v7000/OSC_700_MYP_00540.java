package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_00540 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-10
	 * @ ExpectedResult = 마이페이지 > 내 쿠폰 > 운영자 쿠폰 상세 화면 진입
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_00540() throws Exception {
		TCID = "OSC700_04_MY_00540 임의의 쿠폰 선택 (운영자 쿠폰인 경우)";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();

		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/menu_my_coupon").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("내 쿠폰", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		assertEquals("편집", driver.findElementById("com.skt.skaf.A000Z00040:id/appbar_edit_actionlayout").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/titleTextView").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("쿠폰보기", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/titleTextView").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/couponTextView").isDisplayed();
		
		driver.findElementByXPath("//*[@text='쿠폰 할인 금액보다 적은 금액을 결제하셔도 쿠폰은 소진됩니다.']").isDisplayed();
		try {
			driver.findElementByXPath("//*[@text='쿠폰 한 장당 1회만 결제 가능합니다.']").isDisplayed();
		} catch(Exception e) {
			driver.findElementByXPath("//*[@text='멀티쿠폰은 표기된 잔여회수만큼 사용하실 수 있습니다.']").isDisplayed();
		}
		driver.findElementByXPath("//*[@text='내 쿠폰에서 삭제한 쿠폰은 복구되지 않습니다.']").isDisplayed();
		
		driver.findElementByXPath("//*[@text='유효기간']").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/validityTextView").isDisplayed();
		
		driver.findElementByXPath("//*[@text='이용안내']").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/coupon_guide_text").isDisplayed();
		
		assertEquals("대상상품", downscroll(By.id("com.skt.skaf.A000Z00040:id/coupon_bottom_layout")).getText());
		downscroll(By.id("com.skt.skaf.A000Z00040:id/item_title"));
				
		result = "PASS";

	}
}
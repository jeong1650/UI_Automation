package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_05780 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-15
	 * @ ExpectedResult = 마이페이지 > 이용안내 > 통신판매 사업자 안내 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_05780() throws Exception {
		TCID = "OSC700_04_설정_05780 통신판매 사업자 안내 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_use_guide")).click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='전자상거래법상 고지사항']").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("전자상거래법상 고지사항", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		
		driver.findElementByXPath("//*[@text='청약의 철회 및 계약의 해제의 기한, 행사방법 및 효과에 관한 사항, 재화등의 교환, 반품, 보증과 그 대금 환불의 조건 및 절차, 거래에 관한 약관은 www.onestore.co.kr 에서 확인할 수 있습니다']").click();
		
		result = "PASS";
	}
}
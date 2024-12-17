package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_05750 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-15
	 * @ ExpectedResult = 마이페이지 > 이용안내 페이지 정상 이동
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_05750() throws Exception {
		TCID = "OSC700_04_설정_05750 이용안내";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_use_guide")).click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("이용안내", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		
		driver.findElementByXPath("//*[@text='약관 및 정책']").isDisplayed();
		driver.findElementByXPath("//*[@text='이용 약관']").isDisplayed();
		driver.findElementByXPath("//*[@text='전자금융 거래약관']").isDisplayed();
		driver.findElementByXPath("//*[@text='개인정보 처리방침']").isDisplayed();
		driver.findElementByXPath("//*[@text='청소년 보호정책']").isDisplayed();
		driver.findElementByXPath("//*[@text='지적재산권 보호센터']").isDisplayed();
		driver.findElementByXPath("//*[@text='통신과금서비스 이용약관']").isDisplayed();
		driver.findElementByXPath("//*[@text='통신판매 사업자 안내']").isDisplayed();
		driver.findElementByXPath("//*[@text='전자상거래법상 고지사항']").isDisplayed();
		
		downscroll(By.xpath("//*[@text='버전정보']"));
		downscroll(By.xpath("//*[@text='버전 정보']"));
		downscroll(By.xpath("//*[@text='오픈소스 라이선스']"));
														
		result = "PASS";
	}
}
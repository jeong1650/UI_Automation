package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_GUH_04300 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-03
	 * @ ExpectedResult = 앱&라이프 추천 화면 > KT 통신 판매업 신고번호 선택 시 KT 공정위 사업자 정보 고지 화면 이동
	 * @ Editor = 
	 * @ EditDate = 2020-10-15
	 * @ 웹 기본앱 설정 팝업만 확인 / LG단말 아이콘 대응
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_GUH_04300() throws Exception {
		TCID = "OSC700_01_Home_04300  최하단 Footer 영역";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_app_life").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_app_life").isSelected());
		
		assertEquals("통신판매업신고 : 제2002-경기성남-0048호", downscroll(By.id("com.skt.skaf.A000Z00040:id/tv_seller_info_kt")).getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/tv_seller_info_kt").click();
		
		Thread.sleep(3000);
		try {
			driver.findElementById("android:id/icon").isDisplayed();
		} catch(Exception e) {
			try {
				driver.findElementById("com.lge:id/icon_lg").isDisplayed();
			} catch(Exception ee) {
				try {
					driver.findElementByXPath("//*[@package='com.sec.android.app.sbrowser']").isDisplayed();
				} catch(Exception eee) {
					driver.findElementByXPath("//*[@package='com.android.chrome']").isDisplayed();
				}
			}
		}
		
		driver.navigate().back();
		
		result = "PASS";

	}
}
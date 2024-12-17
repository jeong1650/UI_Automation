package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_05350 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-14
	 * @ ExpectedResult = 마이페이지 > 고객센터 화면 정상 노출
	 * @ Editor = 
	 * @ EditDate = 2020-10-23
	 * @ 확인 순서 변경
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_05350() throws Exception {
		TCID = "OSC700_04_설정_05350 고객센터";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_customer_center")).click();
		
		Thread.sleep(3000);
		downscroll(By.xpath("//*[@text='원스토어에 문의하기']"));
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/custom_live_kakaotalk_chatting"));
		driver.findElementById("com.skt.skaf.A000Z00040:id/custom_email").isDisplayed();
		driver.findElementById("com.skt.skaf.A000Z00040:id/custom_call").isDisplayed();
		
		downscroll(By.xpath("//*[@text='라이브 채팅']"));
		driver.findElementByXPath("//*[@text='이메일 문의']").isDisplayed();		
		driver.findElementByXPath("//*[@text='전화 상담']").isDisplayed();
		
		downscroll(By.xpath("//*[@text='아래 경우는 판매자에게 직접 문의하세요']"));
		
		downscroll(By.xpath("//*[@text='구매하신 게임(또는 앱)의 서비스 운영은 판매자가 담당하고 있습니다. "
				+ "효율적인 문제 해결을 위해 아래의 경우는 판매자에게 직접 문의하시길 권장합니다.']"));
		downscroll(By.xpath("//*[@text='게임(또는 앱)의 사용 방법을 자세히 알고 싶은 경우']"));
		downscroll(By.xpath("//*[@text='게임(또는 앱)이 정상 작동하지 않은 경우']"));
		downscroll(By.xpath("//*[@text='인앱구매 상품 결제 후 정상적으로 지급이 되지 않은 경우']"));
		
		downscroll(By.xpath("//*[@text='문의방법']"));
		downscroll(By.xpath("//*[@text='게임(또는 앱)을 탐색하거나 검색']"));
		downscroll(By.xpath("//*[@text='게임(또는 앱)을 선택해 상세 화면으로 이동']"));
		downscroll(By.xpath("//*[@text='가장 아래로 스크롤해 판매자 정보 옆 문의하기 버튼 선택']"));		
						
		result = "PASS";
	}
}
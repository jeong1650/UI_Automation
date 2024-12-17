package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MKT_02640 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-22
	 * @ ExpectedResult = 사전예약 > [사전예약 신청] > 전문보기 선택 시 개인정보 수집 페이지 이동
	 * @ Editor = 
	 * @ EditDate = 2020-10-26
	 * @ 모든 게임 예약 취소 동작 추가
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MKT_02640() throws Exception {
		TCID = "OSC700_08_마케팅_02640 [전문보기] 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		String textType = "text";
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_game").click();

		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.Button[@text='신규']").click();
		
		Thread.sleep(3000);
		downscroll(By.xpath("//*[@text='사전예약']")).click();
		
		Thread.sleep(3000);
		try {
			driver.findElementByXPath("//*[@text='모든 게임 예약']").isDisplayed();
			textType = "text";
		} catch (Exception e) {
			driver.findElementByXPath("//*[@content-desc='모든 게임 예약']").isDisplayed();
			textType = "content-desc";
		}
		
		try {
			driver.findElementByXPath("//*[@resource-id='btnAllReserveCancel']").isDisplayed();

			Thread.sleep(3000);
			driver.findElementByXPath("//*[contains(@" + textType + ", '모든 게임 예약하기')]").click();

			Thread.sleep(3000);
			driver.findElementByXPath(makeXPath(textType, "예약 취소")).click();

			Thread.sleep(3000);
			driver.findElementByXPath(makeXPath(textType, "확인")).click();
		} catch (Exception e) {}
		
		Thread.sleep(3000);
		downscroll(By.xpath(makeXPath(textType, "사전예약"))).click();
		
		Thread.sleep(5000);
		driver.findElementByXPath(makeXPath(textType, "전문보기")).click();
		
		Thread.sleep(3000);
		try {
			driver.findElementByXPath(makeXPath(textType, "이전페이지 개인정보 수집 및 이용 동의")).isDisplayed();
		} catch(Exception e) {
			driver.findElementByXPath(makeXPath(textType, "이전페이지")).isDisplayed();
			driver.findElementByXPath(makeXPath(textType, "개인정보 수집 및 이용 동의")).isDisplayed();
		}
		try {
		driver.findElementByXPath(makeXPath(textType, "원스토어(주), (주)엘지유플러스, (주)케이티는 고객님의 개인정보 보호를 소중하게 여기고, 고객님의 개인정보를 보호하기 위하여 항상 최선을 다하고 있습니다.\n" + 
				"본 이벤트 참여를 위해 아래와 같이 본인의 개인정보를 수집/이용하는 것에 동의합니다.")).isDisplayed();
		} catch(Exception e) {
			driver.findElementByXPath(makeXPath(textType, "원스토어(주), (주)엘지유플러스, (주)케이티는 고객님의 개인정보 보호를 소중하게 여기고, 고객님의 개인정보를 보호하기 위하여 항상 최선을 다하고 있습니다.")).isDisplayed();
			driver.findElementByXPath(makeXPath(textType, "본 이벤트 참여를 위해 아래와 같이 본인의 개인정보를 수집/이용하는 것에 동의합니다.")).isDisplayed();
		}
		driver.findElementByXPath(makeXPath(textType, "수집하는 개인정보 항목")).isDisplayed();
		driver.findElementByXPath(makeXPath(textType, "휴대전화번호")).isDisplayed();
		driver.findElementByXPath(makeXPath(textType, "수집/이용 목적")).isDisplayed();
		driver.findElementByXPath(makeXPath(textType, "이벤트 참여를 위한 휴대전화 인증, 게임 출시 후 원스토어를 통한 게임 자동 설치, 사전예약 혜택 지급, 고객 문의 응대")).isDisplayed();
		driver.findElementByXPath(makeXPath(textType, "보유/이용기간")).isDisplayed();
		driver.findElementByXPath(makeXPath(textType, "이벤트 종료 후 고객 문의 대응을 위해 3개월 간 보관 후 파기")).isDisplayed();
		driver.findElementByXPath(makeXPath(textType, "동의를 거부할 수 있으나, 동의하는 경우에만 이벤트 참여가 가능합니다.")).isDisplayed();
		
		result = "PASS";
	}
}
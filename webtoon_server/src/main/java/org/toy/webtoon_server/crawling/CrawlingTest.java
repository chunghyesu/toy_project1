package org.toy.webtoon_server.crawling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.toy.webtoon_server.util.FileInputOutputStream;

public class CrawlingTest {

	private WebDriver driver;

	private static final String url = "https://comic.naver.com/webtoon/finish";

	public void process() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\bobae\\Downloads\\chromedriver_win32\\chromedriver.exe");
		// 크롬 드라이버 셋팅 (드라이버 설치한 경로 입력)

		// driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-popup-blocking"); // 팝업안띄움
		options.addArguments("headless"); // 브라우저 안띄움
		options.addArguments("--disable-gpu"); // gpu 비활성화
		options.addArguments("--blink-settings=imagesEnabled=false"); // 이미지 다운 안받음
		driver = new ChromeDriver(options);

		try {
			getDataList();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.close(); // 탭 닫기
		driver.quit(); // 브라우저 닫기
	}

	/**
	 * data가져오기
	 */
	@SuppressWarnings("deprecation")
	private void getDataList() throws InterruptedException {
//		List<String> list = new ArrayList<>();

		driver.get(url); // 브라우저에서 url로 이동한다.
//		Thread.sleep(1000); // 브라우저 로딩될때까지 잠시 기다린다.
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//		System.out.println(driver.getPageSource());
		WebElement img_list = driver.findElement(By.className("img_list"));
		String path = FileInputOutputStream.saveFile(img_list.getAttribute("outerHTML"));
		System.out.println(path);
//		List<WebElement> elements = img_list.findElements(By.tagName("li"));
//		for (WebElement element : elements) {
//			System.out.println("----------------------------");
//			System.out.println(element.getText()); // ⭐
//		}
//
//		return list;
	}

	public static void main(String[] args) {
		CrawlingTest test = new CrawlingTest();
		test.process();
	}

}
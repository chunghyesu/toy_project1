package org.toy.webtoon_server.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//TODO. 로그 추가, config파일 생성

public class FileInputOutputStream {

	public static String saveFile(String data) {

		File file = new File("bin");
		String absolutePath = file.getAbsolutePath();

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		String formatDateTime = now.format(format);

		String savePath = absolutePath + "\\" + formatDateTime + ".txt";
		BufferedOutputStream bs = null;

		System.out.println(savePath);

		try {
			bs = new BufferedOutputStream(new FileOutputStream(savePath));
			bs.write(data.getBytes()); // Byte형으로만 넣을 수 있음

		} catch (Exception e) {
			e.printStackTrace();
			savePath = null;
		} finally {
			try {
				if (bs != null)
					bs.close();// 반드시 닫는다.
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return savePath;
	}

	public static String readFile(String path) {
		String context = null;

		try {
			// 바이트 단위로 파일읽기
			FileInputStream fileStream = null; // 파일 스트림
			fileStream = new FileInputStream(path);// 파일 스트림 생성
			// 버퍼 선언
			byte[] readBuffer = new byte[fileStream.available()];
			while (fileStream.read(readBuffer) != -1) {
			}
			context = new String(readBuffer);
			fileStream.close(); // 스트림 닫기

		} catch (Exception e) {
			e.printStackTrace();
		}

		return context;
	}

	public static void main(String[] args) {
		String path = FileInputOutputStream.saveFile("test");
		System.out.println(FileInputOutputStream.readFile(path));
	}
}

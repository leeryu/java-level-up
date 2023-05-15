package com.leeeryu.thread;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 예를 들어, 다음은 파일을 읽고 처리하는 스레드를 안전하게 종료시키는 방법을 보여줍니다.
 * 이 예제에서는 스레드가 파일을 읽으면서, 입력 스트림이 더 이상 읽을 데이터가 없을 경우 종료하도록 작성되었습니다.
 */
public class FileProcessingThread extends Thread {
    private String filePath;

    public FileProcessingThread(String filePath) {
        this.filePath = filePath;
    }

    public void run() {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String line = null;
            while ((line = br.readLine()) != null) {
                // 파일 내용을 처리하는 코드
            }

            br.close();
            isr.close();
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class FileProcessingThreadMain {
    public static void main(String[] args) {
        FileProcessingThread thread = new FileProcessingThread("test.txt");
        thread.start();

        // 스레드가 종료될 때까지 대기
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

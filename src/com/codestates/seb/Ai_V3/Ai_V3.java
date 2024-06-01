package com.codestates.seb.Ai_V3;

import java.util.Scanner;

public class Ai_V3 {
  public static void main(String[] args) {
    //TODO:
    /*
     * 프로그램에 필요한 변수 선언
     * xy_lists       : 데이터를 담을 2차원 배열
     * diff           : 편차
     * diff_pow       : 편차의 제곱(double)
     * diff_pow_float : 편차의 제곱(float)
     * sum_diff_pow   : 편차 제곱의 합
     * */

    // 프로그램 안내 문구 출력=
    Scanner sc = new Scanner(System.in);
    System.out.println("[인공지능 프로그램 V3]");
    System.out.println("=".repeat(30));
    System.out.printf("[System] a 값을 입력하여 주세요 : ");
    int a = sc.nextInt();
    System.out.printf("[System] b 값을 입력하여 주세요 : ");
    int b = sc.nextInt();
    System.out.println("=".repeat(30));

    //광고비를 받아서 배열에 넣기.
    System.out.printf("입력할 광고비의 갯수를 입력해주세요. : ");
    int advCount = sc.nextInt();
    double [] advArr = new double[advCount];
    for (int i = 0 ; i < advCount; i ++) {
      System.out.printf(i+1 + "번째 광고비 : ");
      advArr[i] = sc.nextDouble();
    }
    System.out.println("=".repeat(30));
    // 1단계: [실제 방문자 수, ai 방문자 수]를 2차원 배열로 받기.
    // 실제 방문자 수 받기
    System.out.println("광고비에 해당하는 실제 방문자의 수를 순서대로 입력해주세요.");
    double [][] xy_list = new double[advCount][2];
    for (int i = 0 ; i < advCount; i ++) {
      System.out.printf(i+1 + "번째 광고비에 해당하는 실제 방문자 수: ");
      xy_list[i][0] = sc.nextDouble();
    }
    System.out.println("=".repeat(30));

    // ai 예상 방문자 수 2차원 배열에 넣기
    for (int i = 0 ; i < advCount; i ++) {
      xy_list[i][1] = a * advArr[i] + b;
    }

    // 데이터 출력 안내 문구 생성
    System.out.println("[안내] 인공지능 프로그램에 할당된 데이터");
    for (int i = 0 ; i < advCount; i ++) {
      System.out.printf("%d 번째 데이터 ) [실제값] 방문자 수 : %f [인공지능 예측값] 웹 페이지 방문자 수 : %f \n", i+1, xy_list[i][0], xy_list[i][1]);
    }
    System.out.println("=".repeat(30));

    // 배열 속 값을 호출하며 편차 -> 제곱 -> 합산 과정을 수행합니다.
    // 2단계: 배열 값의 편차.
    // [100, 300] 편차: -200, 편차 제곱: (-200)^2 = 40,000
    // [200, 500] 편차: -300, 편차 제곱: (-300)^2 = 90,000
    double diff = 0.0;
    double diff_pow = 0.0;
    double sum_diff_pow = 0.0;
    for (int i = 0 ; i < advCount; i ++) {
      diff = xy_list[i][0] - xy_list[i][1];
      diff_pow = Math.pow(diff,2);
      System.out.printf("[%d 번째 데이터] 실제값과 예측값의 편차 : %f \n", i+1, diff);
      System.out.printf("[안내] 오차의 제곱 : %f \n", diff_pow);
      sum_diff_pow += diff_pow;
    }

    // 3단계: 편차의 제곱 합
    // 40,000 + 90,000 = 130,000
    System.out.println("-".repeat(30));
    System.out.printf("[안내] 인공지능 프로그램의 성능(오차의 제곱 합) : %f ", sum_diff_pow);
  }
}

package com.amatda.util;

import java.util.HashMap;

public class CarrierConstant {

    /**
     * city_id - 나라 이름
     *   1 - 일본 오사카
     *   2 - 중국 베이징
     *   3 - 미국 하와이
     *   4 - 미국 뉴욕
     *   5 - 독일 베를린
     *   6 - 프랑스 파리
     *   7 - 베트남 다낭
     */
    public static final HashMap<Integer, String> CARRIER_CITY_LIST = initCity();

    private static HashMap<Integer, String> initCity() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "일본 오사카");
        map.put(2, "중국 베이징");
        map.put(3, "미국 하와이");
        map.put(4, "미국 뉴욕");
        map.put(5, "독일 베를린");
        map.put(6, "프랑스 파리");
        map.put(7, "베트남 다낭");
        return map;
    }
}

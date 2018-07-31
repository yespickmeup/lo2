/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotto.test;

import java.util.Arrays;
import mijzcx.synapse.desk.utils.FitIn;

/**
 *
 * @author Guinness
 */
public class Ascending {

    public static void main(String[] args) {
        String result = "47-05-17-16-57-58";
        String[] asc = result.split("-");
        int[] sort = new int[6];
        for (int i = 0; i < 6; i++) {
            sort[i] = FitIn.toInt(asc[i]);
        }
        Arrays.sort(sort);
        for (int i : sort) {
            System.out.println(i);
        }
    }

    public static String order(String result) {

        String ret = "";
        String[] asc = result.split("-");
        int[] sort = new int[6];
        for (int i = 0; i < 6; i++) {
            sort[i] = FitIn.toInt(asc[i]);
        }
        Arrays.sort(sort);
        for (int i : sort) {
            ret = ret + " - " + i;
        }
        ret = ret.substring(2, ret.length());
        return ret;
    }

    public static String order2(String result) {

        String ret = "";
        String[] asc = result.split("-");
        int[] sort = new int[6];
        for (int i = 0; i < 6; i++) {
            sort[i] = FitIn.toInt(asc[i]);
        }
        Arrays.sort(sort);
        for (int i : sort) {
            ret = ret + "-" + i;
        }
        ret = ret.substring(1, ret.length());
        return ret;
    }
}

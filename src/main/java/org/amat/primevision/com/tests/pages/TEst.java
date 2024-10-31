package org.amat.primevision.com.tests.pages;

import java.util.List;

public class TEst {

    public static void main(String[] args) {
        String s="S:\\WebAutomation\\Reports\\DetailedReport\\Results_30-10-24\\Results_30-10-24_01_48_19\\index.html";
        String index = s.substring(0, s.indexOf("index"));
        System.out.println(index);

    }

    public static void swapList(List<Integer> list1, List<Integer> list2){
        List<Integer> tmpList = list1;
        list1 = list2;
        list2 = tmpList;
    }

    public static void printVowels(String vowels)
    {
        char[] ch=vowels.toCharArray();

        for (int i=0;i<ch.length;i++)
        {
            switch (vowels.toLowerCase().charAt(i)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':

                    break;
            }
        }


    }





}

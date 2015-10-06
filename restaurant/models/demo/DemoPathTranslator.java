/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.demo;

import restaurant.crosplatformPathing.PathTranslator;

/**
 *
 * @author MAZE2
 */
public class DemoPathTranslator {
    public static void main(String[] args) {
        System.out.println(PathTranslator.translate("c:\\My folder\\files.txt"));
        System.out.println(PathTranslator.translate("c:/My folder\\files.txt"));
        System.out.println(PathTranslator.translate("c:/My folder/files.txt"));
    }
}

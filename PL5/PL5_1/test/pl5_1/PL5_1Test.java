/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl5_1;

import junit.framework.TestCase;

/**
 *
 * @author 1131345 - Jorge Mota
 */
public class PL5_1Test extends TestCase {
    
    public PL5_1Test(String testName) {
        super(testName);
    }

    /**
     * Test of main method, of class PL5_1.
     */
    public void testMediaPares() {
        System.out.println("Teste método mediaPares");
        
        PL5_1.mediaPares(10, 250);
        assertEquals(10,10);
        
        fail("The test case is a prototype.");
    }
    
}

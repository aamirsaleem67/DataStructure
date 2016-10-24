/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package first;

/**
 *
 * @author ubit
 */
public class StringTestHarness {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic nin
        
        //new StringTesting();
        //BST a=new BST();
     Phonebook a=  new Phonebook();
     a.insertself();
     a.insert("03142512151","Hamza");
     a.insert("03142645125","Sameer");
     a.insert("03143644125","Talha");
     a.insert("03159271546","Ali");
     a.insert("03159876432","Aamir");
     a.insert("03249217546","Hasan");
     a.insert("03242644125","Waqas");
     a.insert("03255217546","Shahid");
     a.insert("03252675468","Aman");
     a.insert("03462145458","Kasra");
     a.insert("9217546","yousuf");
     a.insert("03458971245","Abdul Wahab");
     a.insert("03458971454","Shahzaib");
     a.insert("03313661885","Salman");
     a.insert("03322645848","Abdul Aziz");
     a.insert("03322644125","Faizan");
     a.insert("03045454888","Awais");
     
     a.search("03045454888");
     a.search("0310");
     a.search("0314");
     a.search("0345");
     a.search("03142512151");
     a.search("03249217546");
     
    
    }
    
}

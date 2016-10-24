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
public class Phonebook {
    
    Phonebook left;
    String s;
    String name;
    
    Phonebook right;
    static Phonebook root=null;
    Phonebook()
    {
     this.left=null;
     this.right=null;
     
    }
    void insertself() // Create Buiit in Exist tree..
    {
       Phonebook temp; 
       root=new Phonebook();     // root node creation..
       root.s="";                // root node key(String) = empty
       root.left=new Phonebook(); // root left node creation
       temp=root.left;            // assigning root left node to temp variable      
       temp.s="031";              // remember now temp = root left, temp key = 031
       temp.right=new Phonebook(); // cration of temp right node
       temp=temp.right;            // assigning temp right node to temp variable..   
       temp.s="030";               // remember now temp = root left right or temp right, 
       temp.right=new Phonebook();   // creation of temp right node
       temp=temp.right;             //  assigning temp right node to temp variable..
       temp.s="1";                 // temp key  = "1"
       
       root.right=new Phonebook(); // now create root right node
       temp=root.right;            //assigning root right to temp
       temp.s="032";               // now remember temp = root right, temp key = "032"  
       temp.right=new Phonebook(); // creation of temp right node
       temp=temp.right;            // assigning temp right node to temp variable, 
       temp.s="033";               // now remember temp = temp right node, temp key = "033"
       
       temp.right=new Phonebook();  // creation of temp right node..
       temp=temp.right;             // assigning temp right node to temp, now temp = temp right node
       temp.s="034";                // temp key = "034"
       
    }
    
    
    
    void insert(String str,String tempname) // insert a number and contact name in our built in exist tree
    {
        Phonebook temp=root;          // temp  = root node
        String s1=str.substring(0,3); // Str is user input contact number, to get the number code e.g "031", "030" etc..
        if(s1.equals("031"))
        {
            temp=temp.left;  // since temp  = root, so temp = root left node
            //System.out.println(temp.s);
            
        }
        else if(s1.equals("030"))
        {
            temp=temp.left.right;      // since temp = root, temp =  root left right node..
            //System.out.println(temp.s);

        }
        else if( !(s1.equals("031")) && !(s1.equals("030")) 
                && !(s1.equals("032")) && !(s1.equals("033")) && !(s1.equals("034")) ) // for any number except any mobile number
        {
            //System.out.println("Em in just");
            temp=temp.left.right;
            foranynumber(temp,str,tempname); // calling the foranynumber function
            return;
        }
        else if(s1.equals("032"))
        {
            temp=temp.right;  // since temp = root node, so temp = right node
            //System.out.println(temp.s);

        }
        else if(s1.equals("033"))
        {
            temp=temp.right.right;      //since temp = root node, so temp = root right right node.. 
            //System.out.println(temp.s);

        }
        else if(s1.equals("034"))
        {
            temp=temp.right.right.right;  //since temp = root node, so temp = root right right right node..
            //System.out.println(temp.s);

        }
        s1=str.substring(0,4); // get four digit code e.g 0304, 0324 etc
        //System.out.println(s1);
        while(true) 
        {
            if(temp.left==null) // now go above and check if else if statements what is the value assigned to temp variable...
            {
                temp.left=new Phonebook(); // create temp left node
                temp=temp.left;           // asign temp = temp left node..
                temp.s=str;               // temp key = number
                temp.name=tempname;      // temp name = contact name  
                //System.out.println("Em in temp.left==null");
                break;              // go out of loop..
            }
            else if(temp.left!=null && temp.left.s.substring(0, 4).equals(s1) )  // s1 = four digit code e.g.. 0324,0304
            {
                while(temp.left!=null)  // until temp left is not become null
                {
                    temp=temp.left; // update temp to temp left node
                }
                temp.left=new Phonebook(); // create temp left node
                temp=temp.left;            // assign temp = temp left node;
                temp.s=str;                // temp node number = str
                temp.name=tempname;        // insert in temp name a contact name, tempname = contact name
                //System.out.println("temp.left!=null");
                break;
            }
            temp=temp.left; //now go above and check if else if statements what is the value assigned to temp variable.. temp =  temp left node
            if(temp.right==null) // remember now temp value has been change, see 124 line
            {
                temp.right=new Phonebook(); // creation of temp right node and the same process go on..
                temp=temp.right;
                temp.s=str;
                temp.name=tempname;
                //System.out.println("Em in temp.right==null");
                break;
            }
            else if(temp.right!=null)  // if temp right not equal to null..
            {
                while(true) // we'll break the loop inside the loop using break
                {
                    if(temp.s.substring(0, 4).equals(s1))
                    {
                        break;
                    }
                    else if(temp.right==null)
                    {
                        break;
                    }
                    temp=temp.right;
                    
                }
                if(temp.s.substring(0,4).equals(s1))
                {
                    while(temp.left!=null)
                    {
                        temp=temp.left;
                    }
                    temp.left=new Phonebook();
                    temp=temp.left;
                    temp.s=str;
                    temp.name=tempname;
                   // System.out.println("temp.right!=null");
                    break;
                }
                else{
                    temp.right=new Phonebook();
                    temp=temp.right;
                    temp.s=str;
                    temp.name=tempname;
                    //System.out.println("temp.right!=null else");
                    break;
                }
            }
            
        
        } // end of loop..
    }
    /*void postorder(Phonebook root)
    {
        Phonebook temp;
        temp=root;
        if(root==null)
        {
        return;
        }
        postorder(temp.left);
        System.out.println(temp.s);
        postorder(temp.right);
        //System.out.println(temp.s);
    }*/
   
    
    void search(String str) // search the contact name and number..
    {
        Phonebook temp=root;     // temp equal to root node..
        String searched="";      // seaarched = empty
        String s1="";            // s1 = empty
        if(str.length()>=3)      // if given cotact name (str) length is equal to 3 or greater than..
        {
        s1=str.substring(0, 3);  // four digit code extract from str..
        }
        
        else{
            System.out.println("Not Found or Too short number");
            return;
        }
        boolean check=false;
        /* temp =root,
           now below acoording to if else, assign temp a value..
        e.g  temp left means root left node.. etc
                */
        if(s1.equals("031"))
        {
            temp=temp.left;
            //System.out.println(temp.s);
            
        }
        else if(s1.equals("030"))
        {
            temp=temp.left.right;
            //System.out.println(temp.s);

        }
        else if(s1.equals("032"))
        {
            temp=temp.right;
            //System.out.println(temp.s);

        }
        else if(s1.equals("033"))
        {
            temp=temp.right.right;
            //System.out.println(temp.s);

        }
        else if(s1.equals("034"))
        {
            temp=temp.right.right.right;
            //System.out.println(temp.s);

        }
        else{ 
            System.out.println("NOT FOUND");
            return;
        }
        s1=str.substring(0,4);
        
        
        String s2=temp.left.s.substring(0,4);
        if(s2.equals(s1))
        {
            while(temp!=null)
            {
                if(temp.s.equals(str))
                {
                    check=true;
                    searched=temp.s;
                    System.out.println("Name: "+temp.name+ "   Number: "+searched);
                    break;
                }
                temp=temp.left;
            }
            if(check==false)
            {
                System.out.println("Not Found");
            }
            
        }
        else{
            temp=temp.left;
            while(temp!=null)
            {
                s2=temp.s.substring(0, 4);
                if(s2.equals(s1))
                {
                    check=true;
                    searched=s2;
                    //System.out.println(searched);
                    break;
                }
               
                temp=temp.right;
                check=false;
            }
            if(check==false)
            {
                System.out.println("Not Found");
                return;
            }
            while(temp!=null)
            {
                if(temp.s.equals(str))
                {
                    searched=temp.s;
                    System.out.println(searched);
                    check=true;
                    break;
                }
                
                temp=temp.left;
                check=false;
            }
            if(check==false)
            {
                System.out.println("Not Found");
                return;
            }
        }
    }
    
    
    void foranynumber(Phonebook temp2,String num,String tempname2) // temp 2 = root.left.right
    {
        temp2=temp2.right; // assigning temp2 = temp2 right node
        if(temp2.left==null)  
        {
            temp2.left=new Phonebook(); // create temt2 left node
            temp2=temp2.left;           // now assign temp2 temp2 left node
            temp2.s=num;                //insert number
            temp2.name=tempname2;       // insert contact name 
            return;
        }
        while(temp2.left!=null) // until temp2 left not become null
        {
            temp2=temp2.left; // updating temp2 = temp2 left node
        }
        temp2.left=new Phonebook(); // creation of temp2 left node
        temp2=temp2.left;           // assign temp2 =  temp2 left node;
        temp2.s=num;                // insert number 
        temp2.name=tempname2;       // insert contact name   
        
        
        
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

/**
 *
 * @author Manideep
 */

//Java class designed for getter methods used in Designed Frame
public class User {
    private int ID;
    private String TransactionType;
    private String PayeeOrSource;
    private String Description;
    private String Date;
    private String Amount;
    private String PaymentMethod;
    
    
    
    
    public User( int ID,String TransactionType,String PayeeOrSource,String Description,String Date,String Amount,String PaymentMethod){
        this.ID=ID;
        this.TransactionType=TransactionType;
        this.PayeeOrSource=PayeeOrSource;
        this.Description=Description;
        this.Date=Date;
        this.Amount=Amount;
        this.PaymentMethod=PaymentMethod;
        
    }

    /**
     * @return the PayeeOrSource
     */
    public String getPayeeOrSource() {
        return PayeeOrSource;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @return the Date
     */
    public String getDate() {
        return Date;
    }

    /**
     * @return the Amount
     */
    public String getAmount() {
        return Amount;
    }

    /**
     * @return the PaymentMethod
     */
    public String getPaymentMethod() {
        return PaymentMethod;
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @return the TransactionType
     */
    public String getTransactionType() {
        return TransactionType;
    }
    
    
    
}

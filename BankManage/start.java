package BankManage;

public class start
{
    public static void main(String[] args)
    {
        try{
            conn c = new conn();
            String m1 = "CREATE TABLE IF NOT EXISTS login(formno int, username varchar(30), password varchar(30), cardno varchar(16), accountno varchar(14))";
            String m2 = "CREATE TABLE IF NOT EXISTS userpersonaldetails(formno int, uname varchar(50), fname varchar(50), dob varchar(10), email varchar(50), mobileno bigint(20), state varchar(30), district varchar(30), address varchar(100), pincode int, gender varchar(10), religion varchar(10), category varchar(10))";
            String m3 = "CREATE TABLE IF NOT EXISTS usersdocumentdetails(formno int, income varchar(30), martialstatus varchar(10), aadhaarcard bigint(20), pancard varchar(12), seniorcitizen varchar(5))";
            String m4 = "CREATE TABLE IF NOT EXISTS userbankdetails(formno int, accounttype varchar(20), passbook varchar(5), emailsms varchar(5), atmcard varchar(5), onlineinternet varchar(5))";
            String m5 = "CREATE TABLE IF NOT EXISTS bankdetails(formno int, accountno varchar(14), cardno varchar(16), pin int(4), balance int(11))";
            String m6 = "CREATE TABLE IF NOT EXISTS transactions(formno int, date varchar(30), cardno varchar(16), deposittype varchar(10), amount int)";
            c.s.execute(m1);
            c.s.execute(m2);
            c.s.execute(m3);
            c.s.execute(m4);
            c.s.execute(m5);
            c.s.execute(m6);
        } catch (Exception e){
            e.printStackTrace();
        }
        new Main();
    }
}
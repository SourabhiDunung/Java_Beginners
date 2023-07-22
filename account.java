import java.util.*;
abstract public class account {
    Scanner sc = new Scanner(System.in);
    int accno,balance,depo;
    String owner, acctype;

    void inputdata() {
        System.out.println("Enter Account number: ");
        accno = sc.nextInt();
        System.out.println("Enter Account holder name: ");
        owner = sc.next();
        System.out.println("Enter Account balance: ");
        balance = sc.nextInt();

    }

    void showdata() {
        System.out.println("Account number: "+accno);
        System.out.println("Account holder name: "+owner);
        System.out.println("Account balance is: "+balance);
    }

    void deposite() {
        System.out.println("Enter Ammount to be deposited: ");
        depo= sc.nextInt();
        balance = balance + depo;
        System.out.println("The balance in your account is: "+balance);
    }

    account() {
        accno=0;
        balance=0;
        depo=0;
        owner=null;
        acctype=null;
    }
    
    abstract void withdrawamt();
}

class savingacc extends account {
    Scanner sc = new Scanner(System.in);
    int withdrawcash;

    void withdrawamt() {
        System.out.println("Enter the amount you want to withdraw: ");
        withdrawcash = sc.nextInt();

        if(withdrawcash>balance-1000) {
            System.out.println("Amount cannot be withdrawn minimum balancr should be 1000 ");
        }
        else {
            balance = balance - withdrawcash;
            System.out.println("Current balance will be: "+balance);
        }
    }
}

class currentacc extends account {
    Scanner sc = new Scanner(System.in);
    int withdrawmoney;

    void withdrawamt() {
        System.out.println("Enter the amount you want withdraw: ");
        withdrawmoney = sc.nextInt();
        balance = balance - withdrawmoney;
        System.out.println("Your current account balance is: "+balance);
    }
}

class bankmain {
    public static void main(String[] args) {
        int cho1,cho2,k;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("WELCOME TO 211 BANK PROJECT");
        System.out.println("Enter 1 if you have saving account: \nEnter 2 if you have current account: ");
        cho1 = sc.nextInt();

        switch(cho1) {

            case 1:
            savingacc obj1 = new savingacc();
            
            obj1.inputdata();
            obj1.showdata();
            
            do{
                System.out.println("Enter the transaction you want to carry out:\n1.Deposite\n2.Withdraw");
                cho2 = sc.nextInt();

                if(cho2==1){
                    obj1.deposite();
                }
                else{
                    obj1.withdrawamt();
                }
                System.out.println("Do you want to continue: 1.Yes\n0.No");
                k =sc.nextInt();    
            }while(k==1);
            break;

            case 2:
            currentacc obj5 = new currentacc();
            
            obj5.inputdata();
            obj5.showdata();

            do {
                System.out.println("Enter the transaction you want to carry out:\n1.Deposite\nWithdraw");
                cho2 = sc.nextInt();

                if(cho2==1){
                    obj5.deposite();
                }
                else{
                    obj5.withdrawamt();
                }
                System.out.println("Do you want to continue: 1.Yes\n0.No");
                k =sc.nextInt();    
            }while(k==1);
            }
        }
    }
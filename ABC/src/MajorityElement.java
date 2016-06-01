
//Majority Element

public class MajorityElement{
    public static void main(String s[]) {
        int a[] ={3,2,5,10,7,5,5,5};


        int max=0;
        for (int i=0;i<a.length;i++) {
            if (a[i]>max) {
                max=a[i];
            }
        }

        int hash[]= new int[max+1];

        for (int i=0;i<a.length;i++) {
            hash[a[i]]++;
        }

        int maj=-1;
        int aLength= a.length%2==0 ? a.length/2 :a.length/2+1;
        for (int i=0;i<hash.length;i++) {

            if (hash[i]>=aLength) {
                maj=i;
                break;
            }
        }

        if (maj>0) {
            System.out.println("Majority Element : "+maj);

        } else {
            System.out.println("No Majority Element");

        }


    }
}

//Using Moore’s Voting Algorithm

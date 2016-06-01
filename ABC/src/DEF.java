
public class DEF {

    public static void main(String s[]) {

        int a[] ={1,4,2,6,9,3,4};
        int max=0;


        for (int i=0;i<a.length-2;i++) {

            for (int j=i+1;j<a.length-1;j++) {

                if (a[j]>a[i]) {

                    for (int k=j+1;k<a.length;k++) {
                        int sum=0;

                        if (a[k] > a[j]) {
                            sum=sum+a[i];
                            sum=sum+a[j];
                            sum=sum+a[k];
                            if (sum>max) {
                                max=sum;
                                System.out.println(i+" "+j+" "+k +" "+sum);
                            }
                        }
                    }
                }

            }

        }

        System.out.println(max);
    }

}

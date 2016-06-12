import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class CalenderTest {

    public static void main(final String s[]) throws IOException {
        

      BufferedReader bfReader = new BufferedReader(new InputStreamReader(System.in));
      String inputs[] = bfReader.readLine().split(" ");
      
      int level = Integer.parseInt(inputs[0]);
      int testcases = Integer.parseInt(inputs[1]);
      int maxCols= (int)Math.pow(2, level);
      int arr[][] = new int[level][maxCols+1];
      
      for (int i=1;i<=maxCols;i++) {
          arr[level-1][i]=i;
      }
      
      int arrPow[] = new int[level-1];
      for (int i=0;i<=level-2;i++) {
          arrPow[i] = (int)Math.pow(2, i);
      }
      for (int j=level-2;j>=0;j--) {
          for (int k=1;k<=arrPow[j];k++) {
              arr[j][k] = arr[j+1][k*2-1]*arr[j+1][k*2]; 
          }
      }
      
      long testcaseValidMin = (long)((Math.pow(2, level)-1)*(Math.pow(2, level)+4)/6);
      long testcaseValidMax = (long)Math.pow(10, 6);
long maxVal =testcaseValidMin>testcaseValidMax?testcaseValidMax:testcaseValidMin;
      
      if (testcases>=1 && testcases<=maxVal) {
          if (level>=1 & level<=21) {
              while (testcases-->0) {
                  String nxy[] = bfReader.readLine().split(" ");
                  int n = Integer.parseInt(nxy[0]);  
                  int x = Integer.parseInt(nxy[1]);
                  int y = Integer.parseInt(nxy[2]);
                  long xValid= (long)Math.pow(2, 21);
            if (x>=1&&x<=xValid && y>=x&&y<=xValid) {
                long ans=0;

                for (int x1=x;x1<=y;x1++) {
                    ans +=arr[n-1][x1];
                }
                ans = (ans)%1299709;

                System.out.println(ans);
            }

                  
              }
          }

      }
              
        
        
        
//      BufferedReader bfReader = new BufferedReader(new InputStreamReader(System.in));
//      int testcases = Integer.parseInt(bfReader.readLine());
//      if (testcases>=1 & testcases<=10) {
//        
//          while (testcases-->0) {
//              String[] inputs = bfReader.readLine().split(" ");
//              int arr[] = new int[inputs.length];
//              int i=0;
//              for (String in : inputs) {
//                  arr[i++] = Integer.parseInt(in);
//              }
//          
//              
//              int noOfPainiting=0;
//              if (arr.length==3) {
//                  int min= Integer.MAX_VALUE;
//                  for (int a= 0; a<arr.length;a++) {
//                      if (arr[a] < min) {
//                          min = arr[a];
//                      }
//                  }
//
//                  if (min>0) {
//                      arr[0] = arr[0] - min;
//                      arr[1] = arr[1] - min;
//                      arr[2] = arr[2] - min;
//                  }
//                  noOfPainiting +=min;
//                  
//              }
//
//              noOfPainiting+= arr[0]/3;
//              noOfPainiting+=arr[1]/3;
//              noOfPainiting+=arr[2]/3;
//              System.out.println(noOfPainiting);
//              
//          }
//
//      }
                
        
//        boolean a = true;
//        boolean b = !true;
//        boolean c = a | b;
//        boolean d = a & b;
//        boolean e = d ? b : c;
//        System.out.println(d + " " + e);        //
//        String input,sub;
//        int inputLength;
//        int noOfInputs;
//        int i, character, length;
//   
//        BufferedReader bfReader = null;
//
//        bfReader = new BufferedReader(new InputStreamReader(System.in));
//
//        inputLength = Integer.parseInt(bfReader.readLine());
//        input  = bfReader.readLine();
//        if (inputLength == input.length() && (inputLength>=1 && inputLength <= 1000000)) {
//            
//        noOfInputs = Integer.parseInt(bfReader.readLine());
//        if (noOfInputs>=1 && noOfInputs <= 1000000) {
//         
//        length = input.length();
//        
//        while (noOfInputs > 0) {
//            noOfInputs--;
//
//            int j = 0;
//        
////        for (String string : stringMap) {
//            String in  = bfReader.readLine();
////            stringMap.add(in);      
//            String[] startPoints = in.split(" ");
//            String startingPoint = startPoints[0];
//            String endPoint = startPoints[1];
//            
//            for( character = 0 ; character < length ; character++ )
//            {
//               for( i = 1 ; i <= length - character ; i++ )
//               {
//                  sub = input.substring(character, character+i);
//                  if (sub.startsWith(startingPoint) && sub.endsWith(endPoint)) {
//                      j++;
//                  }
//               }
//            }
//            System.out.println(j);
//            
//        
//        
//        }
////    }
//        }
//        }
        
//        try {
//  
//        BufferedReader bfReader = null;
//
//        bfReader = new BufferedReader(new InputStreamReader(System.in));
//
//        String[] inputs= bfReader.readLine().split(" ");
//      int n = Integer.parseInt(inputs[0]);
//      int q = Integer.parseInt(inputs[1]);
//      String[] nString= bfReader.readLine().split(" ");
//      int[] inArr = new int[n];
//      
//      int i=0;
//      for (String nInput : nString) {
//          inArr[i++] = Integer.parseInt(nInput);
//      }
//      
//      if (n == nString.length) {
//          while (q-->0) {
//           String[] query = bfReader.readLine().split(" ");
//           int arr[] = new int[query.length];
//           int j=0;
//           for (String que : query) {
//               arr[j++] = Integer.parseInt(que);
//           }
//           
//           if (arr[0] == 0) {
//               inArr[arr[1]-1] =arr[2];
//           } else if (arr[0] == 1) {
//               boolean exist = false;
//               for (int k=0;k<inArr.length ; k++) {
//                   if (inArr[k] >arr[1]) {
//                       System.out.println(k+1);
//                       exist = true;
//                       break;
//                   }
//               }
//               if (!exist) {
//                   System.out.println(-1);                   
//               }
//           }
//              
//          }          
//      }
//        } catch (Exception e) {
//            
//        }
    }
}

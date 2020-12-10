public class Arr {

    public static boolean structure(int [] arr){
        int one=0;
        int four=0;
        if(arr==null || arr.length==0){
            throw new RuntimeException("Array is null");
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==1){
                one++;
            }
            if(arr[i]==4){
                four++;
            }
        }
        if(one>0&&four>0){
            return true;
        }
        return false;
    }


    public static int[] searchTo4 (int [] arr){
        int index4=0;
        int lengthNewArray;
        if(arr==null || arr.length==0){
            throw new RuntimeException("Array is null");
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==4){
                index4=i;
            }
        }
        if(index4<=0){
            throw new RuntimeException("4 not found");
        }
        lengthNewArray=(arr.length-index4)-1;
        int toSearch [] = new int[lengthNewArray];
        for (int i = 0; i < toSearch.length; i++) {
            toSearch[i]=arr[i+index4+1];
        }
        return toSearch;
    }
}